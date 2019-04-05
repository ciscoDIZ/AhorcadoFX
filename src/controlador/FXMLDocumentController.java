/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import modelo.Ahorcado;

/**
 *
 * @author Francisco de Asís Domínguez Iceta <toteskuu@gmail.com>
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txtTablero;
    @FXML
    private TextField txtApostar;
    @FXML
    private Button btnApostar;
    @FXML
    private Label lblErrores;
    Ahorcado ahorcado;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtTablero.setEditable(false);
        ahorcado = new Ahorcado();
        btnApostar.setOnMouseClicked(event -> apostar(event));
        txtTablero.setText(String.copyValueOf(ahorcado.getTablero()));
    }    
    public void apostar(MouseEvent event){
        ahorcado.setIntento(txtApostar.getText().charAt(0));
        ahorcado.comprobarAcierto();
        ahorcado.actualizarTablero();
    }
}
