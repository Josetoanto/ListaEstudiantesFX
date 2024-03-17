package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.HashMap;

public class BuscarAlumnoController {

    @FXML
    private Label lbl_Advertencia;

    @FXML
    private TextField txt_MatriculaEliminar;

    @FXML
    private TextArea txt_MostrarEstudiante;
    private ListaAsistencia listaAsistencia;
    private HashMap<String, Estudiante> clonListaEstudiantes = new HashMap<>();

    private int intentos = 0;


    @FXML
    void onSalirClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void txta_BuscadorAlumnos(KeyEvent event) {
        String matriculaEliminar = txt_MatriculaEliminar.getText();
        if (!listaAsistencia.getListaEstudiantes().isEmpty()) {
            if (matriculaEliminar.length() == 6) {
                if (clonListaEstudiantes.get(txt_MatriculaEliminar.getText()) == null) {
                    lbl_Advertencia.setText("Estudiante no encontrado");
                    txt_MostrarEstudiante.setText("");
                    intentos++;
                    if (intentos==3){
                        Node source = (Node) event.getSource();
                        Stage stage = (Stage) source.getScene().getWindow();
                        stage.close();
                    }
                } else {
                    lbl_Advertencia.setText("Estudiante encontrado");
                    txt_MostrarEstudiante.setText(clonListaEstudiantes.get(txt_MatriculaEliminar.getText()).imprimirDatos());
                    intentos = 0;
                }
            } else {
                lbl_Advertencia.setText("6 caracteres minimo");
                txt_MostrarEstudiante.setText("");
            }
        } else {
            lbl_Advertencia.setText("No hay estudiantes");
        }
    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
        for (Estudiante iterador : listaAsistencia.getListaEstudiantes()) {
            clonListaEstudiantes.put(iterador.getMatricula(), iterador);
        }
    }
}

