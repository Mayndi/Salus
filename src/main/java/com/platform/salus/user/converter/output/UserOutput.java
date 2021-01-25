package com.platform.salus.user.converter.output;

public class UserOutput extends UserOutputCommonFields{

    private String id;
    private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    private String confSenha;

    public String getId() { return id; }

    public UserOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UserOutput setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public UserOutput setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public UserOutput setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public UserOutput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserOutput setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UserOutput setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public UserOutput setConfSenha(String confSenha) {
        this.confSenha = confSenha;
        return this;
    }
}
