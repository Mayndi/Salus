package com.platform.salus.registryUser.contact.model;

import com.platform.salus.registryUser.user.model.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "user")
public class ContactEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeContato;
        private String telefoneContato;

        @OneToOne
        private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public ContactEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ContactEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public ContactEntity setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
        return this;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public ContactEntity setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
        return this;
    }
}
