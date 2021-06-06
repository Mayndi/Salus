package com.platform.salus.registryUser.contact.converter.input;

import com.platform.salus.registryUser.user.converter.input.UserInput;

public class ContactInput {

    private String nomeContato;
    private String telefoneContato;
    private UserInput user;

    public UserInput getUser() {
        return user;
    }

    public ContactInput setUser(UserInput user) {
        this.user = user;
        return this;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }
}
