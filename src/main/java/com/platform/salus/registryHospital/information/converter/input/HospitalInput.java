package com.platform.salus.registryHospital.information.converter.input;

public class HospitalInput {

    private String nome;
    private String cnpj;
    private String tipo;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public HospitalInput setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public HospitalInput setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public HospitalInput setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public HospitalInput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
