package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
            alert.setHeaderText("Esta seguro que sus datos son correctos?\n"
                    + nombreSesion.getText() + " " + contraseñaSesion.getText());

            ButtonType buttonTypeSi = new ButtonType("Sí");
            ButtonType buttonTypeNo = new ButtonType("No");


            try {
                String cssFile = getClass().getResource("/Style.css").toExternalForm();
                alert.getDialogPane().getStylesheets().add(cssFile);
                alert.getButtonTypes().setAll(buttonTypeSi, buttonTypeNo);
            } catch (NullPointerException e) {
                System.err.println("No se pudo encontrar el archivo CSS.");
                e.printStackTrace();
            }


            alert.showAndWait().ifPresent(response -> {
                if (response == buttonTypeSi) {
                    Usuario u1 = new Usuario(nombreSesion.getText(), contraseñaSesion.getText());
                    if(!listaAsistencia.getListaUsuarios().contains(u1)){
                    listaAsistencia.addUsuario(u1);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Éxito");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Usuario agregado correctamente");
                    try {
                        String cssFile = getClass().getResource("/Style.css").toExternalForm();
                        alert1.getDialogPane().getStylesheets().add(cssFile);
                    } catch (NullPointerException e) {
                        System.err.println("No se pudo encontrar el archivo CSS.");
                        e.printStackTrace();
                    }
                    alert1.showAndWait();
                    System.out.println("Usuario agregado correctamente");
                    setListaAsistencia(listaAsistencia);
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                }else {
                        System.out.println("usuario repetido");
                        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("error");
                        alert1.setHeaderText(null);
                        alert1.setContentText("Nombre de usuario ya esta en uso\nfavor de cambiarlo");
                        try {
                            String cssFile = getClass().getResource("/Style.css").toExternalForm();
                            alert1.getDialogPane().getStylesheets().add(cssFile);
                        } catch (NullPointerException e) {
                            System.err.println("No se pudo encontrar el archivo CSS.");
                            e.printStackTrace();
                        }
                        alert1.showAndWait();
                    }

                } else if (response == buttonTypeNo) {
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Cancelado");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Usuario no se creó");
                    try {
                        String cssFile = getClass().getResource("/Style.css").toExternalForm();
                        alert1.getDialogPane().getStylesheets().add(cssFile);
                    } catch (NullPointerException e) {
                        System.err.println("No se pudo encontrar el archivo CSS.");
                        e.printStackTrace();
                    }
                    alert1.showAndWait();
                    System.out.println("Usuario no se creó");
                }
            });
        }
            else {
            Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Cancelado");
            alert1.setHeaderText(null);
            alert1.setContentText("Contraseña no cumple con los criterios");
            try {
                String cssFile = getClass().getResource("/Style.css").toExternalForm();
                alert1.getDialogPane().getStylesheets().add(cssFile);
            } catch (NullPointerException e) {
                System.err.println("No se pudo encontrar el archivo CSS.");
                e.printStackTrace();
            }
            alert1.showAndWait();
            System.out.println("Contraseña no cumple con los criterios");
            }
    }
    @FXML
    void onCancelarClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
