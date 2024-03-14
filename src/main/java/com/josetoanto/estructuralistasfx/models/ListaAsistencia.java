package com.josetoanto.estructuralistasfx.models;

import java.util.ArrayList;

public class ListaAsistencia {
    private ArrayList<Estudiante> listaEstudiantes=new ArrayList<>();
    public void addEstudiante(Estudiante alumno) {
        listaEstudiantes.add(alumno);
    }
}
