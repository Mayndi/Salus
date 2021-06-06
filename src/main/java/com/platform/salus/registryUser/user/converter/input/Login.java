package com.platform.salus.registryUser.user.converter.input;

public class Login {

    String email;
    String senha;

    public String getEmail() {
        return email;
    }

    public Login setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public Login setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
