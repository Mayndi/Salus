package com.platform.salus.registryHospital.information.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class HospitalOutput extends CommonFields {

    private String id;

    private String nome;
    private String cnpj;
    private String tipo;
    private String telefone;

    public String getId() {
        return id;
    }

    public HospitalOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public HospitalOutput setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public HospitalOutput setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public HospitalOutput setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public HospitalOutput setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }
}
