package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
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

    public void initialize(){
        listaAlumnos.getItems().addAll(listaEstudiantes.toString());
    }

    @FXML
    void onSalirClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAlumnos = listaAlumnos;
    }
}
