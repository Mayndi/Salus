package com.platform.salus.user.converter.input;

public class UserInput {

    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private String confSenha;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UserInput setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public UserInput setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public UserInput setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public UserInput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserInput setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UserInput setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public UserInput setConfSenha(String confSenha) {
        this.confSenha = confSenha;
        return this;
    }
}
