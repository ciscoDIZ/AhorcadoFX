/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import modelo.Ahorcado;

/**
 *
 * @author Francisco de Asís Domínguez Iceta <toteskuu@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas cvAhorcado;
    @FXML
    private TextField txtTablero;
    @FXML
    private TextField txtApostar;
    @FXML
    private Button btnApostar;
    @FXML
    private Label lblErrores;
    private Ahorcado ahorcado;
    private GraphicsContext gc;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTablero.setEditable(false);
        ahorcado = new Ahorcado();
        btnApostar.setOnAction(event -> apostar(event));
        txtApostar.setOnAction(event -> apostar(event));
        txtTablero.setText(String.copyValueOf(ahorcado.getTablero()));
        txtTablero.setFocusTraversable(false);
        txtApostar.setFocusTraversable(true);
        txtApostar.requestFocus();
        gc = cvAhorcado.getGraphicsContext2D();
        gc.setLineWidth(5);
        gc.setStroke(Paint.valueOf("Brown"));
        gc.strokeLine(8, 10, 38, 10);
    }

    public void apostar(ActionEvent event) {
        char intento = txtApostar.getText().charAt(0);
        txtTablero.setText(String.valueOf(ahorcado.apostar(intento)));
        if (!ahorcado.isPartidaActiva()) {
            ahorcado = new Ahorcado();
            txtTablero.setText(String.valueOf(ahorcado.getTablero()));
        }

        txtApostar.setText(null);
    }
}
