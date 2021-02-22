package com.platform.salus.registryUser.user.converter.input;

public class UserUpdateInput {

    private String nomeCompleto;
    private String telefone;
    private String email;
    private String senha;
    private String confSenha;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UserUpdateInput setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public UserUpdateInput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserUpdateInput setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UserUpdateInput setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public UserUpdateInput setConfSenha(String confSenha) {
        this.confSenha = confSenha;
        return this;
    }
}
