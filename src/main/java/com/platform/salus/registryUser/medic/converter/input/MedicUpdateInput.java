package com.platform.salus.registryUser.medic.converter.input;

public class MedicUpdateInput {

    private String nSus;
    private String nConvenio;
    private String telefoneConvenio;
    private String historico;
    private String deficiencia;
    private String alergias;
    private String obs;

    public String getnSus() {
        return nSus;
    }

    public MedicUpdateInput setnSus(String nSus) {
        this.nSus = nSus;
        return this;
    }

    public String getnConvenio() {
        return nConvenio;
    }

    public MedicUpdateInput setnConvenio(String nConvenio) {
        this.nConvenio = nConvenio;
        return this;
    }

    public String getTelefoneConvenio() {
        return telefoneConvenio;
    }

    public MedicUpdateInput setTelefoneConvenio(String telefoneConvenio) {
        this.telefoneConvenio = telefoneConvenio;
        return this;
    }

    public String getHistorico() {
        return historico;
    }

    public MedicUpdateInput setHistorico(String historico) {
        this.historico = historico;
        return this;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public MedicUpdateInput setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
        return this;
    }

    public String getAlergias() {
        return alergias;
    }

    public MedicUpdateInput setAlergias(String alergias) {
        this.alergias = alergias;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public MedicUpdateInput setObs(String obs) {
        this.obs = obs;
        return this;
    }
}
