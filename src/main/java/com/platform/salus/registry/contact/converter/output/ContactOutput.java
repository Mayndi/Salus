package com.platform.salus.registry.contact.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class ContactOutput extends CommonFields {

    private String id;
    private String nomeCompleto;
    private String telefone;

    public String getId() { return id; }

    public ContactOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ContactOutput setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ContactOutput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
