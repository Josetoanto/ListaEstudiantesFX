package com.josetoanto.estructuralistasfx.models;

import java.util.Objects;

public class Usuario {
    String name;
    String password;

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

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}