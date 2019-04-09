/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.InputStream;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Francisco de Asís Domínguez Iceta <toteskuu@gmail.com>
 */
public class AhorcadoFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        if (configurar(stage)) {
            Parent root = FXMLLoader.load(getClass().getResource("/vista/FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }

    public boolean configurar(Stage stage) {
        boolean resultado = true;
        stage.setResizable(false);
        stage.setTitle("Juego del ahorcado");
        ObservableList<Image> observableList = stage.getIcons();
        InputStream inputStream = AhorcadoFX
                .class.getResourceAsStream("/img/horca.png");
        Image image = new Image(inputStream);
        observableList.add(image);
        return resultado;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
