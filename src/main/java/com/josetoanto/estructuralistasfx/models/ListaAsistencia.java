package com.josetoanto.estructuralistasfx.models;

import java.util.ArrayList;

public class ListaAsistencia {
    private ArrayList<Estudiante> listaEstudiantes=new ArrayList<>();
    private ArrayList<Usuario>listaUsuarios= new ArrayList<>();


    public void addEstudiante(Estudiante alumno) {
        listaEstudiantes.add(alumno);
    }
    public void addUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

}
