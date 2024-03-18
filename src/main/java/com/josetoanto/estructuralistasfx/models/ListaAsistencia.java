package com.josetoanto.estructuralistasfx.models;

import java.util.ArrayList;

public class ListaAsistencia {
    private ArrayList<Usuario>listaUsuarios= new ArrayList<>();

    public void addUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


}
