package com.platform.salus.registryUser.medicament.converter.output;

import com.platform.salus.common.utils.CommonFields;

public class MedicamentOutput extends CommonFields {

    private String id;

    private String nomeMedicamento;
    private String inicioMed;
    private String fimMed;
    private String usoContinuo;
    private String user;

    public String getUser() {
        return user;
    }

    public MedicamentOutput setUser(String user) {
        this.user = user;
        return this;
    }

    public String getId() {
        return id;
    }

    public MedicamentOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public MedicamentOutput setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
        return this;
    }

    public String getInicioMed() {
        return inicioMed;
    }

    public MedicamentOutput setInicioMed(String inicioMed) {
        this.inicioMed = inicioMed;
        return this;
    }

    public String getFimMed() {
        return fimMed;
    }

    public MedicamentOutput setFimMed(String fimMed) {
        this.fimMed = fimMed;
        return this;
    }

    public String getUsoContinuo() {
        return usoContinuo;
    }

    public MedicamentOutput setUsoContinuo(String usoContinuo) {
        this.usoContinuo = usoContinuo;
        return this;
    }
}
