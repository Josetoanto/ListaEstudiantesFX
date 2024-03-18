package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class ModificarAlumnoController {

    @FXML
    private Label lbl_Advertencia;

    @FXML
    private TextField txt_CalCal;

    @FXML
    private TextField txt_CalED;

    @FXML
    private TextField txt_CalIngles;

    @FXML
    private TextField txt_CalPOO;

    @FXML
    private TextField txt_MatriculaModificar;
    private Usuario usuario;
    private HashMap<String, Estudiante> clonListaEstudiantes = new HashMap<>();

    private String matricula;


    @FXML
    void onModificarClick(ActionEvent event) {
        boolean noRango=false;
        lbl_Advertencia.setTextFill(Color.GREEN);
        if (!usuario.getListaEstudiantes().isEmpty()) {
            if (matricula.length() == 6) {
                if (!(clonListaEstudiantes.get(txt_MatriculaModificar.getText()) == null)) {
                    clonListaEstudiantes.get(txt_MatriculaModificar.getText()).inicializarMaterias();
                    if (Integer.parseInt(txt_CalCal.getText()) >= 10 && Integer.parseInt(txt_CalCal.getText()) <= 100 &&
                            Integer.parseInt(txt_CalED.getText()) >= 10 && Integer.parseInt(txt_CalED.getText()) <= 100 &&
                            Integer.parseInt(txt_CalIngles.getText()) >= 10 && Integer.parseInt(txt_CalIngles.getText()) <= 100 &&
                            Integer.parseInt(txt_CalPOO.getText()) >= 10 && Integer.parseInt(txt_CalPOO.getText()) <= 100) {
                        clonListaEstudiantes.get(txt_MatriculaModificar.getText()).setMaterias("Inglés", Double.valueOf(txt_CalIngles.getText()));
                        System.out.println("Agrege la calificacion de POO");
                        clonListaEstudiantes.get(txt_MatriculaModificar.getText()).setMaterias("POO",Double.valueOf(txt_CalPOO.getText()));
                        System.out.println("Agrege la calificacion de Estructura de datos");
                        clonListaEstudiantes.get(txt_MatriculaModificar.getText()).setMaterias("Estructura de datos",Double.valueOf(txt_CalED.getText()));
                        System.out.println("Agrege la calificacion de Cálculo diferencial");
                        clonListaEstudiantes.get(txt_MatriculaModificar.getText()).setMaterias("Cálculo diferencial",Double.valueOf(txt_CalCal.getText()));
                        lbl_Advertencia.setText("Estudiante modificado");
                    }else {
                        lbl_Advertencia.setTextFill(Color.RED);
                        lbl_Advertencia.setText("Las calificaciones deben estar entre 10 y 100");
                    }
                } else {
                    Node source = (Node) event.getSource();
                    Stage stage = (Stage) source.getScene().getWindow();
                    stage.close();
                }
            } else {
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
        } else {
            lbl_Advertencia.setText("No hay estudiantes en la lista");
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
        lbl_Advertencia.setTextFill(Color.RED);
       matricula = txt_MatriculaModificar.getText();
        if (!usuario.getListaEstudiantes().isEmpty()) {
            if (matricula.length() == 6) {
                if (clonListaEstudiantes.get(txt_MatriculaModificar.getText()) == null) {
                    lbl_Advertencia.setText("Estudiante no encontrado");
                }
                else{lbl_Advertencia.setText(clonListaEstudiantes.get(txt_MatriculaModificar.getText()).getName()+" "+
                        clonListaEstudiantes.get(txt_MatriculaModificar.getText()).getLastname());
                    lbl_Advertencia.setTextFill(Color.GREEN);}

            } else {
                lbl_Advertencia.setText("6 caracteres minimo");
                }
        } else {
            lbl_Advertencia.setText("No hay estudiantes");
        }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        for (Estudiante iterador : usuario.getListaEstudiantes()) {
            clonListaEstudiantes.put(iterador.getMatricula(), iterador);
        }
    }
}

