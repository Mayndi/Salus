package com.platform.salus.registryUser.contact.converter.input;

public class ContactInput {

    private String nomeCompleto;
    private String telefone;
    private String user;

    public String getUser() {
        return user;
    }

    public ContactInput setUser(String user) {
        this.user = user;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ContactInput setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ContactInput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
