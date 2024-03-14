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


    @FXML
    void onSalirClick(MouseEvent event) {
<<<<<<< HEAD
        

=======
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
>>>>>>> logicaAcabada
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

