package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.Main;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuProfesorController {

    @FXML
    private AnchorPane txt_Bienvenido;

    @FXML
    private Label txt_bienvenida;

    ListaAsistencia listaAsistencia;

    public void agregarNombre(String nombre){
        txt_bienvenida.setText("Bienvenido " + nombre);
    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    @FXML
    void onAgregarAlumnosClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("agregarAlumno.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Agregar Alumno");
            stage.setScene(scene);
            stage.show();
            AgregarAlumnoController agregarAlumnoController = fxmlLoader.getController();
            agregarAlumnoController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onBuscarAlumnosClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("buscarAlumno.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Buscar Alumno");
            stage.setScene(scene);
            stage.show();
            BuscarAlumnoController buscarAlumnoController = fxmlLoader.getController();
            buscarAlumnoController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onEliminarAlumnosClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("eliminarAlumno.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Eliminar Alumno");
            stage.setScene(scene);
            stage.show();
            EliminarAlumnoController eliminarAlumnoController = fxmlLoader.getController();
            eliminarAlumnoController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onModificarAlumnosClick(MouseEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("modificarAlumno.fxml"));
            Pane root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setTitle("Modificar Alumno");
            stage.setScene(scene);
            stage.show();
            ModificarAlumnoController modificarAlumnoController = fxmlLoader.getController();
            modificarAlumnoController.setListaAsistencia(listaAsistencia);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onMostrarAlumnosClick(MouseEvent event) {
        if (listaAsistencia.getListaEstudiantes().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Lista vacia");
            alert.showAndWait();
        } else {
            try {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("mostrarAlumnos.fxml"));
                Pane root = fxmlLoader.load();
                Scene scene = new Scene(root);
                stage.setTitle("Mostrar Alumnos");
                stage.setScene(scene);
                stage.show();
                MostrarAlumnosController mostrarAlumnosController = fxmlLoader.getController();
                mostrarAlumnosController.setListaAsistencia(listaAsistencia);
            } catch (IOException e) {
                e.printStackTrace();
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
