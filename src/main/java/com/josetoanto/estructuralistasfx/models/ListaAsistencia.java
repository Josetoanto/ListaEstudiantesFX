package com.josetoanto.estructuralistasfx.models;

import java.util.ArrayList;

public class ListaAsistencia {
    private ArrayList<Estudiante> listaEstudiantes=new ArrayList<>();
    private ArrayList<Usuario>listaUsuarios= new ArrayList<>();

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void addEstudiante(Estudiante alumno) {
        listaEstudiantes.add(alumno);
    }
    public void addUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

}
