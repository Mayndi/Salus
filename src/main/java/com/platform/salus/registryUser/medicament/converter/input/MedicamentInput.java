package com.platform.salus.registryUser.medicament.converter.input;

public class MedicamentInput {

        private String nomeMedicamento;
        private String inicioMed;
        private String fimMed;
        private String usoContinuo;
        private String user;

    public String getUser() {
        return user;
    }

    public MedicamentInput setUser(String user) {
        this.user = user;
        return this;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public MedicamentInput setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
        return this;
    }

    public String getInicioMed() {
        return inicioMed;
    }

    public MedicamentInput setInicioMed(String inicioMed) {
        this.inicioMed = inicioMed;
        return this;
    }

    public String getFimMed() {
        return fimMed;
    }

    public MedicamentInput setFimMed(String fimMed) {
        this.fimMed = fimMed;
        return this;
    }

    public String getUsoContinuo() {
        return usoContinuo;
    }

    public MedicamentInput setUsoContinuo(String usoContinuo) {
        this.usoContinuo = usoContinuo;
        return this;
    }
}
