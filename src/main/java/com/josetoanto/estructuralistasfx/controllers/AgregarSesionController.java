package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AgregarSesionController {
    private ListaAsistencia listaAsistencia;

    @FXML
    private TextField contraseñaSesion;

    @FXML
    private TextField nombreSesion;

    void setListaAsistencia(ListaAsistencia listaAsistencia){
        this.listaAsistencia=listaAsistencia;
    }


    @FXML
    void onAgregarClick(MouseEvent event) {
        nombreSesion.getText();
        contraseñaSesion.getText();
        char esnumero = contraseñaSesion.getText().charAt(0);
        if (!Character.isDigit(esnumero) && contraseñaSesion.getText().length() == 6) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText("¿esta seguro que sus datos son correctos?\n"
                    + nombreSesion.getText() + " " + contraseñaSesion.getText());

            ButtonType buttonTypeSi = new ButtonType("Sí");
            ButtonType buttonTypeNo = new ButtonType("No");
            alert.getButtonTypes().setAll(buttonTypeSi, buttonTypeNo);

            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeSi) {
                    Usuario u1 = new Usuario(nombreSesion.getText(), contraseñaSesion.getText());
                    listaAsistencia.addUsuario(u1);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Éxito");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Usuario agregado correctamente");
                    alert1.showAndWait();
                    System.out.println("Usuario agregado correctamente");
                    setListaAsistencia(listaAsistencia);
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();

                } else if (response == buttonTypeNo) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Éxito");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Usuario no se creó");
                    alert1.showAndWait();
                    System.out.println("Usuario no se creó");
                }
            });
        }
            else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Éxito");
            alert1.setHeaderText(null);
            alert1.setContentText("contraseña no cumple con los criterios");
            alert1.showAndWait();
            System.out.println("contraseña no cumple con los criterios");
            }
    }
}
