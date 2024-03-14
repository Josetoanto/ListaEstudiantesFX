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

public class EliminarAlumnoController {

    @FXML
    private Label lbl_Advertencia;

    @FXML
    private TextField txt_MatriculaEliminar;

    @FXML
    private TextArea txt_MostrarEstudiante;
    private ListaAsistencia listaAsistencia;
    private HashMap<String, Estudiante> clonListaEstudiantes = new HashMap<>();

    @FXML
    void onEliminarClick(MouseEvent event) {
        if (!listaAsistencia.getListaEstudiantes().isEmpty()) {
            System.out.println("Ingrese matricula de alumno a eliminar");
            String matriculaEliminar = txt_MatriculaEliminar.getText();
            if (matriculaEliminar.length() == 6) {
                if (!(clonListaEstudiantes.get(matriculaEliminar) == null)){
                    if (listaAsistencia.getListaEstudiantes().remove(clonListaEstudiantes.get(matriculaEliminar)))
                        lbl_Advertencia.setText("Estudiante borrado con exito");
                } else {
                    lbl_Advertencia.setText("Estudiante no encontrado");
                }
            } else {
                lbl_Advertencia.setText("La matricula debe llevar 6 caracteres");
            }
        } else {
            lbl_Advertencia.setText("Lista de estudiantes vacia");
        }
    }

    @FXML
    void onSalirClick(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void txta_BuscadorAlumnos(KeyEvent event) {
        txt_MostrarEstudiante.setText(clonListaEstudiantes.get(txt_MatriculaEliminar).imprimirDatos());
    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
        for (Estudiante iterador : listaAsistencia.getListaEstudiantes()) {
            clonListaEstudiantes.put(iterador.getMatricula(), iterador);
        }
    }
}
