package com.platform.salus.registryUser.address.converter.output;

import com.platform.salus.common.utils.CommonFields;
import com.platform.salus.registryUser.user.model.UserEntity;

public class AddressOutput extends CommonFields {

        private String id;

        private String cep;
        private String estado;
        private String cidade;
        private String bairro;
        private String rua;
        private String numero;
        private String complemento;
        private String referencia;
        private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public AddressOutput setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getId() {
        return id;
    }

    public AddressOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public AddressOutput setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public AddressOutput setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public AddressOutput setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public AddressOutput setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public AddressOutput setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public AddressOutput setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public AddressOutput setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getReferencia() {
        return referencia;
    }

    public AddressOutput setReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }
}
