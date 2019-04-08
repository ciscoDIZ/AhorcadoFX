/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
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
    private Label lblOportunidades;
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
    private GraphicsContext gcHorca;
    private GraphicsContext gcMonigote;
    

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
        gcHorca = cvAhorcado.getGraphicsContext2D();
        gcMonigote = cvAhorcado.getGraphicsContext2D();
        gcHorca.setLineWidth(5);
        gcHorca.setStroke(Paint.valueOf("Black"));
        dibujarHorca();
        actualizarOportunidades();
    }

    public void apostar(ActionEvent event) {
        
        char intento = txtApostar.getText().charAt(0);
        txtTablero.setText(String.valueOf(ahorcado.apostar(intento)));
        dibujerMonigote();
        lblErrores.setText(ahorcado.getErrores());
        
        actualizarOportunidades();
        
        if (!ahorcado.isPartidaActiva()) {
            if (ahorcado.comprobarVictoria()) {
                crearDialogoVictoria().showAndWait();
            } else {
                crearDialogoDerrota().showAndWait();
            }
            btnApostar.setText("Reset");
            btnApostar.setOnAction(evt -> resetPartida(evt));
        }
        txtApostar.setText(null);
    }

    private Dialog crearDialogoVictoria() {
        Label label = new Label();
        label.setText("Errores:\n" + ahorcado.getErrores());
        Dialog d = new Dialog();
        d.setTitle("Has ganado!!");
        d.setHeaderText("¿Deseas jugar otra partida?");
        d.getDialogPane()
                .getButtonTypes()
                .addAll(ButtonType.YES, ButtonType.NO);
        d.getDialogPane().setContent(label);
        return d;
    }

    private Dialog crearDialogoDerrota() {
        Label label = new Label();
        label.setText("Errores:\n" + ahorcado.getErrores() + "\nPalabra secreta: " + ahorcado.getPALABRA_SECRETA());
        Dialog d = new Dialog();
        d.setTitle("Has perdido!!");
        d.setHeaderText("¿Deseas jugar otra partida?");
        d.getDialogPane()
                .getButtonTypes()
                .addAll(ButtonType.YES, ButtonType.NO);
        d.getDialogPane().setContent(label);
        return d;
    }

    private void resetPartida(ActionEvent evt) {
        ahorcado = new Ahorcado();
        txtTablero.setText(String.valueOf(ahorcado.getTablero()));
        lblErrores.setText(null);
        btnApostar.setText("Apostar");
        btnApostar.setOnAction(event -> apostar(event));
        actualizarOportunidades();
        dibujerMonigote();
    }

    private void dibujarHorca() {
        gcHorca.strokeLine(10, 200, 80, 200);
        gcHorca.strokeLine(20, 199, 20, 35);
        gcHorca.strokeLine(20, 34, 76, 34);
        gcHorca.strokeLine(21, 60, 45, 35);

        

    }

    private void dibujerMonigote() {
        gcMonigote.setStroke(Paint.valueOf("Blue"));
        int opt = ahorcado.getERRORES_POSIBLES() - ahorcado.getErroresString().length();
        if (opt == 0) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
            gcMonigote.strokeLine(75, 130, 75, 90);
            gcMonigote.strokeLine(75, 100, 90, 110);
            gcMonigote.strokeLine(75, 100, 60, 110);
            gcMonigote.strokeOval(65, 70, 20, 20);
            gcMonigote.setStroke(Paint.valueOf("Black"));
            gcMonigote.strokeLine(74, 34, 74, 65);
        } else if (opt == 1) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
            gcMonigote.strokeLine(75, 130, 75, 90);
            gcMonigote.strokeLine(75, 100, 90, 110);
            gcMonigote.strokeLine(75, 100, 60, 110);
            gcMonigote.strokeOval(65, 70, 20, 20);
        } else if (opt == 2) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
            gcMonigote.strokeLine(75, 130, 75, 90);
            gcMonigote.strokeLine(75, 100, 90, 110);
            gcMonigote.strokeLine(75, 100, 60, 110);
        } else if (opt == 3) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
            gcMonigote.strokeLine(75, 130, 75, 90);
            gcMonigote.strokeLine(75, 100, 90, 110);
        } else if (opt == 4) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
            gcMonigote.strokeLine(75, 130, 75, 90);
        } else if (opt == 5) {
            gcMonigote.strokeLine(60, 160, 75, 130);
            gcMonigote.strokeLine(90, 160, 75, 130);
        } else if (opt == 6) {
            gcMonigote.strokeLine(60, 160, 75, 130);
        }else if(opt == 7){
            gcMonigote.clearRect(0, 0, cvAhorcado.getWidth(), cvAhorcado.getHeight());
            gcMonigote.setStroke(Paint.valueOf("Black"));
            dibujarHorca();
            
        }
    }

    private void actualizarOportunidades() {
        lblOportunidades
                .setText(String.valueOf(ahorcado.getERRORES_POSIBLES()
                        - ahorcado.getErroresString().length()));
    }
}
