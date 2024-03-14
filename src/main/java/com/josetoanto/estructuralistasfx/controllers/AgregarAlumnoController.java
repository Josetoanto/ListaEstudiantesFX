package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgregarAlumnoController {

    @FXML
    private TextField txt_fechaIngreso;

    @FXML
    private TextField txt_lastName;

    @FXML
    private TextField txt_name;

    private ListaAsistencia listaAsistencia;

    @FXML
    void onAgregarClick(MouseEvent event) {

    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }
}
