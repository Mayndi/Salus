package com.platform.salus.registry.contact.converter.input;

public class ContactInput {

    private String nomeCompleto;
    private String telefone;

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
