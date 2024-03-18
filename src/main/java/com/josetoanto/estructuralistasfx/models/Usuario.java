package com.josetoanto.estructuralistasfx.models;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {
    private String name;
    private String password;
    private ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();


    public Usuario(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Usuario(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario login = (Usuario) o;
        return Objects.equals(name, login.name);
    }

    public ArrayList<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }
    public void addEstudiante(Estudiante alumno) {
        listaEstudiantes.add(alumno);
    }

    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}