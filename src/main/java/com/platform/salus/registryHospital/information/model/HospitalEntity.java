package com.platform.salus.registryHospital.information.model;

import javax.persistence.*;

@Entity
@Table(name = "hospital", schema = "hospital")
public class HospitalEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String cnpj;
        private String tipo;
        private String telefone;

    public Long getId() {
        return id;
    }

    public HospitalEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public HospitalEntity setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public HospitalEntity setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public HospitalEntity setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public HospitalEntity setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
