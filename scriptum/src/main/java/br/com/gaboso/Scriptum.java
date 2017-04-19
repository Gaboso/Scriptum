package br.com.gaboso;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Gabriel Carvalho - <gabrielsantiago2@gmail.com>
 * @since 19/04/2017
 * <p>
 * Scriptum
 */
public class Scriptum extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scriptoso for dumbs");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text titulo = new Text("Configurações");
        titulo.setId("config_title");
        grid.add(titulo, 0, 0, 2, 1);

        Label descricao = new Label("Informe o caminho do seu workspace:");
        grid.add(descricao, 0, 2);

        TextField descricaoTF = new TextField();
        grid.add(descricaoTF, 0, 3);
        setBorderInit(descricaoTF);

        Button salvar = new Button("Executar");
        grid.add(salvar, 0, 7);

        salvar.setOnAction(t -> {
            if (!descricaoTF.getText().isEmpty()) {
                setBorderInit(descricaoTF);
                String caminho = descricaoTF.getText();

                try {
                    executeCMD(caminho);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                descricaoTF.setBorder(new Border(new BorderStroke(Color.RED,
                        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setBorderInit(TextField descricaoTF) {
        descricaoTF.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.NONE, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }

    private void executeCMD(String path) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd " + path + " && dir");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;

        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

}