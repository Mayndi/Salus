package com.platform.salus.registry.contact.model;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "salus")
public class ContactEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeCompleto;
        private String telefone;

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
