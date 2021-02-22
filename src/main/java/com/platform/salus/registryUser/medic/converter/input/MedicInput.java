package com.platform.salus.registryUser.medic.converter.input;

public class MedicInput {

    private String nSus;
    private String nConvenio;
    private String telefoneConvenio;
    private String historico;
    private String tipoSanguineo;
    private String sexo;
    private String deficiencia;
    private String alergias;
    private String obs;
    private String user;

    public String getUser() {
        return user;
    }

    public MedicInput setUser(String user) {
        this.user = user;
        return this;
    }

    public String getnSus() {
        return nSus;
    }

    public MedicInput setnSus(String nSus) {
        this.nSus = nSus;
        return this;
    }

    public String getnConvenio() {
        return nConvenio;
    }

    public MedicInput setnConvenio(String nConvenio) {
        this.nConvenio = nConvenio;
        return this;
    }

    public String getTelefoneConvenio() {
        return telefoneConvenio;
    }

    public MedicInput setTelefoneConvenio(String telefoneConvenio) {
        this.telefoneConvenio = telefoneConvenio;
        return this;
    }

    public String getHistorico() {
        return historico;
    }

    public MedicInput setHistorico(String historico) {
        this.historico = historico;
        return this;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public MedicInput setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public MedicInput setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public MedicInput setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
        return this;
    }

    public String getAlergias() {
        return alergias;
    }

    public MedicInput setAlergias(String alergias) {
        this.alergias = alergias;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public MedicInput setObs(String obs) {
        this.obs = obs;
        return this;
    }
}
