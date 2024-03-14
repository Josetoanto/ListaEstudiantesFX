package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

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

    }

}
