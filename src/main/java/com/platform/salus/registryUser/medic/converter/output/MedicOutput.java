package com.platform.salus.registryUser.medic.converter.output;

import com.platform.salus.common.utils.CommonFields;
import com.platform.salus.registryUser.user.model.UserEntity;

public class MedicOutput extends CommonFields {

    private String id;

    private String nSus;
    private String nConvenio;
    private String telefoneConvenio;
    private String historico;
    private String tipoSanguineo;
    private String deficiencia;
    private String alergias;
    private String obs;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public MedicOutput setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public String getId() {
        return id;
    }

    public MedicOutput setId(String id) {
        this.id = id;
        return this;
    }

    public String getnSus() {
        return nSus;
    }

    public MedicOutput setnSus(String nSus) {
        this.nSus = nSus;
        return this;
    }

    public String getnConvenio() {
        return nConvenio;
    }

    public MedicOutput setnConvenio(String nConvenio) {
        this.nConvenio = nConvenio;
        return this;
    }

    public String getTelefoneConvenio() {
        return telefoneConvenio;
    }

    public MedicOutput setTelefoneConvenio(String telefoneConvenio) {
        this.telefoneConvenio = telefoneConvenio;
        return this;
    }

    public String getHistorico() {
        return historico;
    }

    public MedicOutput setHistorico(String historico) {
        this.historico = historico;
        return this;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public MedicOutput setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
        return this;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public MedicOutput setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
        return this;
    }

    public String getAlergias() {
        return alergias;
    }

    public MedicOutput setAlergias(String alergias) {
        this.alergias = alergias;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public MedicOutput setObs(String obs) {
        this.obs = obs;
        return this;
    }
}
