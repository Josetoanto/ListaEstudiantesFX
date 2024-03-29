package com.josetoanto.estructuralistasfx.controllers;

import com.josetoanto.estructuralistasfx.models.Estudiante;

import com.josetoanto.estructuralistasfx.models.ListaAsistencia;
import com.josetoanto.estructuralistasfx.models.Usuario;
import javafx.fxml.FXML;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AgregarAlumnoController {

    @FXML
    private TextField txt_fechaIngreso;

    @FXML
    private TextField txt_lastName;

    @FXML
    private TextField txt_name;

    private Usuario usuario;

    @FXML
    void onAgregarClick(MouseEvent event) {
        int age = Integer.parseInt(txt_fechaIngreso.getText());
        age=age%100;
        Estudiante estudiante=new Estudiante();
        String matricula=estudiante.generarNumeroMatricula(age);
            estudiante=new Estudiante(Integer.parseInt(txt_fechaIngreso.getText()),matricula,txt_name.getText(),txt_lastName.getText(),estudiante.getMaterias());

            if (!usuario.getListaEstudiantes().contains(estudiante)&&matricula.length()==6){
                estudiante=new Estudiante(Integer.parseInt(txt_fechaIngreso.getText()),matricula,txt_name.getText(),txt_lastName.getText(),estudiante.getMaterias());
                usuario.addEstudiante(estudiante);
                alertaAgregadoCorrectamente(matricula);
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
            else if (usuario.getListaEstudiantes().contains(estudiante)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Matricula ya existe, por lo tanto no se agregara el alumno.");
                alert.showAndWait();
                try {
                    String cssFile = getClass().getResource("/Style.css").toExternalForm();
                    alert.getDialogPane().getStylesheets().add(cssFile);
                } catch (NullPointerException e) {
                    System.err.println("No se pudo encontrar el archivo CSS.");
                    e.printStackTrace();
                }
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
            if (matricula.length()!=6){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Matricula no tiene 6 digitos");
                try {
                    String cssFile = getClass().getResource("/Style.css").toExternalForm();
                    alert.getDialogPane().getStylesheets().add(cssFile);
                } catch (NullPointerException e) {
                    System.err.println("No se pudo encontrar el archivo CSS.");
                    e.printStackTrace();
                }
                alert.showAndWait();
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            }
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void alertaAgregadoCorrectamente(String matricula){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Agregado Exitosamente");
        alert.setHeaderText(null);
        alert.setContentText("Se agrego correctamente el alumno\n su matricula es: "+ matricula);
        try {
            String cssFile = getClass().getResource("/Style.css").toExternalForm();
            alert.getDialogPane().getStylesheets().add(cssFile);
        } catch (NullPointerException e) {
            System.err.println("No se pudo encontrar el archivo CSS.");
            e.printStackTrace();
        }
        alert.showAndWait();
        setUsuario(usuario);
    }
}
