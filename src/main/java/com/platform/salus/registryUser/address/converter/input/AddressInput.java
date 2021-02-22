package com.platform.salus.registryUser.address.converter.input;

public class AddressInput {

        private String cep;
        private String pais;
        private String estado;
        private String cidade;
        private String bairro;
        private String rua;
        private String numero;
        private String complemento;
        private String referencia;
        private String user;

    public String getUser() {
        return user;
    }

    public AddressInput setUser(String user) {
        this.user = user;
        return this;
    }

    public String getCep() {
        return cep;
    }

    public AddressInput setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public String getPais() {
        return pais;
    }

    public AddressInput setPais(String pais) {
        this.pais = pais;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public AddressInput setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getCidade() {
        return cidade;
    }

    public AddressInput setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public String getBairro() {
        return bairro;
    }

    public AddressInput setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public String getRua() {
        return rua;
    }

    public AddressInput setRua(String rua) {
        this.rua = rua;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public AddressInput setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public String getComplemento() {
        return complemento;
    }

    public AddressInput setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public String getReferencia() {
        return referencia;
    }

    public AddressInput setReferencia(String referencia) {
        this.referencia = referencia;
        return this;
    }
}
