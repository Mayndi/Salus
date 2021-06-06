package com.platform.salus.registryUser.contact.converter.output;

import com.platform.salus.common.utils.CommonFields;
import com.platform.salus.registryUser.user.model.UserEntity;

public class ContactOutput extends CommonFields {

    private String id;
    private String nomeContato;
    private String telefoneContato;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public ContactOutput setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getId() { return id; }

    public ContactOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public ContactOutput setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
        return this;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public ContactOutput setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
        return this;
    }
}
