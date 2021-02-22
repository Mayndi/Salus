package com.platform.salus.registryUser.contact.model;

import com.platform.salus.registryUser.user.model.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "user")
public class ContactEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeCompleto;
        private String telefone;

        @ManyToOne
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

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ContactEntity setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ContactEntity setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
