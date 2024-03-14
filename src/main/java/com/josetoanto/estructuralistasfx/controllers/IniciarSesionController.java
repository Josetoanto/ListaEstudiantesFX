package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.Main;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class IniciarSesionController {

    @FXML
    private TextField contraseñaSesion;

    @FXML
    private TextField nombreSesion;
    private int intentos = 0;

    private ListaAsistencia listaAsistencia;

    void setListaAsistencia (ListaAsistencia listaAsistencia){
        this.listaAsistencia=listaAsistencia;
    }

    @FXML
    void onIniciarClick(MouseEvent event) {
        boolean encontro=false;
        for (Usuario usuarioActual : listaAsistencia.getListaUsuarios()) {
            if (usuarioActual.getName().equals(nombreSesion.getText()) && usuarioActual.getPassword().equals(contraseñaSesion.getText())) {
                encontro=true;
            }
        }
        if (encontro){
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menuProfesor.fxml"));
                Pane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setTitle("Bienvenido");
                stage.setScene(scene);
                stage.show();
                MenuProfesorController menuProfesorController = fxmlLoader.getController();
                menuProfesorController.setListaAsistencia(listaAsistencia);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            intentos++;
            if (intentos >= 3) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Se ha excedido el número máximo de intentos. La aplicación se cerrará.");
                alert.showAndWait();
                System.exit(1);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Usuario o contraseña incorrectos. Intento " + intentos + " de 3.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void onSalirClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
