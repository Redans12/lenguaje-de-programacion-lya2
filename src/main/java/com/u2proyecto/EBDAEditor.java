package com.u2proyecto;

import java.io.*;
import java.nio.file.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class EBDAEditor extends Application {

    private TextArea editorArea;
    private TextArea consoleArea;
    private Label statusLabel;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        stage.setTitle("EBDA Editor — Lenguajes y Autómatas II");

        // ==================== EDITOR ====================
        editorArea = new TextArea();
        editorArea.setStyle("-fx-font-family: 'Consolas', monospace; -fx-font-size: 14px;");
        editorArea.setPromptText("Escribe tu código EBDA aquí...");
        editorArea.setPrefRowCount(20);

        Label editorLabel = new Label("📝 Editor EBDA");
        editorLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13px;");

        VBox editorBox = new VBox(5, editorLabel, editorArea);
        VBox.setVgrow(editorArea, Priority.ALWAYS);

        // ==================== CONSOLA ====================
        consoleArea = new TextArea();
        consoleArea.setStyle(
                "-fx-font-family: 'Consolas', monospace; -fx-font-size: 13px;" +
                        "-fx-control-inner-background: #1e1e1e; -fx-text-fill: #d4d4d4;");
        consoleArea.setEditable(false);
        consoleArea.setPrefRowCount(10);

        Label consoleLabel = new Label("🖥 Consola de salida");
        consoleLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 13px;");

        VBox consoleBox = new VBox(5, consoleLabel, consoleArea);
        VBox.setVgrow(consoleArea, Priority.ALWAYS);

        // ==================== SPLIT ====================
        SplitPane splitPane = new SplitPane(editorBox, consoleBox);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setDividerPositions(0.6);

        // ==================== BARRA DE BOTONES ====================
        Button btnAbrir = new Button("📂 Abrir");
        Button btnGuardar = new Button("💾 Guardar");
        Button btnEjecutar = new Button("▶ Ejecutar");
        Button btnLimpiar = new Button("🗑 Limpiar");

        btnAbrir.setStyle("-fx-font-size: 13px;");
        btnGuardar.setStyle("-fx-font-size: 13px;");
        btnEjecutar.setStyle("-fx-font-size: 13px; -fx-background-color: #4CAF50; -fx-text-fill: white;");
        btnLimpiar.setStyle("-fx-font-size: 13px;");

        // menú de traducción
        MenuButton btnTraducir = new MenuButton("🌐 Traducir a...");
        btnTraducir.setStyle("-fx-font-size: 13px; -fx-background-color: #2196F3; -fx-text-fill: white;");

        MenuItem itemPython = new MenuItem("Python (.py)");
        MenuItem itemC = new MenuItem("C (.c)");
        MenuItem itemCSharp = new MenuItem("C# (.cs)");
        MenuItem itemJS = new MenuItem("JavaScript (.js)");
        MenuItem itemCpp = new MenuItem("C++ (.cpp)");

        btnTraducir.getItems().addAll(itemPython, itemC, itemCSharp, itemJS, itemCpp);

        HBox toolbar = new HBox(10, btnAbrir, btnGuardar, btnEjecutar, btnLimpiar, btnTraducir);
        toolbar.setPadding(new Insets(10));

        // ==================== STATUS BAR ====================
        statusLabel = new Label("Listo.");
        statusLabel.setStyle("-fx-font-size: 12px; -fx-padding: 5px;");

        // ==================== LAYOUT PRINCIPAL ====================
        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setCenter(splitPane);
        root.setBottom(statusLabel);
        BorderPane.setMargin(splitPane, new Insets(0, 10, 0, 10));

        // ==================== ACCIONES ====================
        btnAbrir.setOnAction(e -> abrirArchivo());
        btnGuardar.setOnAction(e -> guardarArchivo());
        btnEjecutar.setOnAction(e -> ejecutar());
        btnLimpiar.setOnAction(e -> {
            consoleArea.clear();
            statusLabel.setText("Consola limpiada.");
        });

        itemPython.setOnAction(e -> traducir("Python", ".py", new EBDAToPythonVisitor()));
        itemC.setOnAction(e -> traducir("C", ".c", new EBDAToCVisitor()));
        itemCSharp.setOnAction(e -> traducir("C#", ".cs", new EBDAToCSharpVisitor()));
        itemJS.setOnAction(e -> traducir("JavaScript", ".js", new EBDAToJavaScriptVisitor()));
        itemCpp.setOnAction(e -> traducir("C++", ".cpp", new EBDAToCppVisitor()));

        Scene scene = new Scene(root, 1000, 700);
        stage.setScene(scene);
        stage.show();
    }

    // ==================== ABRIR ARCHIVO ====================
    private void abrirArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Abrir archivo EBDA");
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos EBDA", "*.ebda"));
        File file = fc.showOpenDialog(primaryStage);
        if (file != null) {
            try {
                String contenido = Files.readString(file.toPath());
                editorArea.setText(contenido);
                statusLabel.setText("Abierto: " + file.getName());
            } catch (IOException ex) {
                log("[Error] No se pudo abrir el archivo: " + ex.getMessage());
            }
        }
    }

    // ==================== GUARDAR ARCHIVO ====================
    private void guardarArchivo() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Guardar archivo EBDA");
        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos EBDA", "*.ebda"));
        File file = fc.showSaveDialog(primaryStage);
        if (file != null) {
            try {
                Files.writeString(file.toPath(), editorArea.getText());
                statusLabel.setText("Guardado: " + file.getName());
            } catch (IOException ex) {
                log("[Error] No se pudo guardar: " + ex.getMessage());
            }
        }
    }

    // ==================== EJECUTAR ====================
    private void ejecutar() {
        consoleArea.clear();
        String codigo = editorArea.getText();
        if (codigo.isBlank()) {
            log("[Aviso] El editor está vacío.");
            return;
        }

        // redirigir System.out y System.err a la consola
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        System.setErr(ps);

        try {
            CharStream input = CharStreams.fromString(codigo);
            EBDALexer lexer = new EBDALexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EBDAParser parser = new EBDAParser(tokens);
            EBDAParser.StartContext tree = parser.start();

            EBDACustomVisitor visitor = new EBDACustomVisitor();
            visitor.visit(tree);

        } catch (Exception ex) {
            System.err.println("[Error] " + ex.getMessage());
        } finally {
            System.out.flush();
            System.err.flush();
            System.setOut(originalOut);
            System.setErr(originalErr);
        }

        log(baos.toString());
        statusLabel.setText("Ejecución completada.");
    }

    // ==================== TRADUCIR ====================
    private void traducir(String lenguaje, String extension, EBDABaseVisitor<String> visitor) {
        String codigo = editorArea.getText();
        if (codigo.isBlank()) {
            log("[Aviso] El editor está vacío.");
            return;
        }

        try {
            CharStream input = CharStreams.fromString(codigo);
            EBDALexer lexer = new EBDALexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EBDAParser parser = new EBDAParser(tokens);
            EBDAParser.StartContext tree = parser.start();

            String codigoGenerado = visitor.visit(tree);

            FileChooser fc = new FileChooser();
            fc.setTitle("Exportar a " + lenguaje);
            fc.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter(lenguaje, "*" + extension));
            fc.setInitialFileName("traduccion" + extension);
            File file = fc.showSaveDialog(primaryStage);

            if (file != null) {
                Files.writeString(file.toPath(), codigoGenerado);
                log("✅ Código " + lenguaje + " exportado a: " + file.getAbsolutePath());
                statusLabel.setText("Exportado a " + lenguaje + ": " + file.getName());
            }

        } catch (Exception ex) {
            log("[Error] " + ex.getMessage());
        }
    }

    // ==================== LOG ====================
    private void log(String texto) {
        Platform.runLater(() -> consoleArea.appendText(texto + "\n"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}