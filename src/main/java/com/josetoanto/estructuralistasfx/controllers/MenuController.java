package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.Main;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MenuController {

    private ListaAsistencia listaAsistencia= new ListaAsistencia();
    void setListaAsistencia(ListaAsistencia listaAsistencia){
        this.listaAsistencia=listaAsistencia;
    }

    @FXML
    void onAgregarUsuarioClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AgregarSesion.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Agregando usuario");
            stage.setScene(scene);
            stage.show();
            AgregarSesionController agregarSesionController = fxmlLoader.getController();
            agregarSesionController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onIniciarSesionClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("IniciarSesion.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Iniciando Sesion");
            stage.setScene(scene);
            stage.show();
            IniciarSesionController iniciarSesionController = fxmlLoader.getController();
            iniciarSesionController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onSalirClick(MouseEvent event) {
        System.exit(1);
    }

}
