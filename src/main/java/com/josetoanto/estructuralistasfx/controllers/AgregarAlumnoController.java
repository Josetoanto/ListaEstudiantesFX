package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;

import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import javafx.fxml.FXML;

import javafx.scene.control.Alert;
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
        boolean Encontrada=false;
        int age = Integer.parseInt(txt_fechaIngreso.getText());
        age=age%100;
        Estudiante estudiante=new Estudiante();
        String matricula=estudiante.generarNumeroMatricula(age);
        if (listaAsistencia.getListaEstudiantes().isEmpty()){
            estudiante=new Estudiante(Integer.parseInt(txt_fechaIngreso.getText()),matricula,txt_name.getText(),txt_lastName.getText(),estudiante.getMaterias());
            listaAsistencia.addEstudiante(estudiante);
            alertaAgregadoCorrectamente(matricula);
        }
        else {
            for (Estudiante matriculaExiste : listaAsistencia.getListaEstudiantes()) {
                if (matriculaExiste.getMatricula().equals(matricula)) {
                    Encontrada = true;
                    System.out.println("se agrego correctamente");
                }
            }
            if (Encontrada){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("matricula ya existe, por lo tanto no se agregara el alumno.");
                alert.showAndWait();
            }
            else {
                estudiante=new Estudiante(Integer.parseInt(txt_fechaIngreso.getText()),matricula,txt_name.getText(),txt_lastName.getText(),estudiante.getMaterias());
                listaAsistencia.addEstudiante(estudiante);
                alertaAgregadoCorrectamente(matricula);

            }



        }
    }

    public void setListaAsistencia(ListaAsistencia listaAsistencia) {
        this.listaAsistencia = listaAsistencia;
    }

    public void alertaAgregadoCorrectamente(String matricula){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("agregado Exitosamente");
        alert.setHeaderText(null);
        alert.setContentText("se agrego correctamente el alumno\n su matricula es: "+ matricula);
        alert.showAndWait();
        setListaAsistencia(listaAsistencia);
    }
}
