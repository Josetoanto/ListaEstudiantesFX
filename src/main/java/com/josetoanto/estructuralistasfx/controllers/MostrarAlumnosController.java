package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MostrarAlumnosController {

    @FXML
    private ListView<String> listaAlumnos;

    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    @FXML
    void onSalirClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    @FXML
    void onActualizarClick(MouseEvent event) {
        listaAlumnos.getItems().clear();
        for (Estudiante estudiante: listaEstudiantes){
            listaAlumnos.getItems().add(estudiante.imprimirDatos());
        }
    }

    public void setListaAsistencia(Usuario usuario) {
        this.listaEstudiantes = usuario.getListaEstudiantes();
        for (Estudiante estudiante: listaEstudiantes){
            listaAlumnos.getItems().add(estudiante.imprimirDatos());
        }
    }
}
