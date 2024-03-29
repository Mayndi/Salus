package com.platform.salus.registryUser.address.model;

import com.platform.salus.registryUser.user.model.UserEntity;

import javax.persistence.*;

@Entity
@Table(name = "address", schema = "user")
public class AddressEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String cep;
        private String estado;
        private String cidade;
        private String bairro;
        private String rua;
        private String numero;
        private String complemento;
        private String referencia;
        @OneToOne
        private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public AddressEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public AddressEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public AddressEntity setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public AddressEntity setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public AddressEntity setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public AddressEntity setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public AddressEntity setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public AddressEntity setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public AddressEntity setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getReferencia() {
        return referencia;
    }

    public AddressEntity setReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }
}
