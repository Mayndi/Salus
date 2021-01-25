package com.platform.salus.registry.medic.model;

import javax.persistence.*;

@Entity
@Table(name = "medic", schema = "salus")
public class MedicEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nSus;
    private String nConvenio;
    private String telefoneConvenio;
    private String historico;
    private String tipoSanguineo;
    private String sexo;
    private String deficiencia;
    private String alergias;
    private String obs;

    public Long getId() {
        return id;
    }

    public MedicEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getnSus() {
        return nSus;
    }

    public MedicEntity setnSus(String nSus) {
        this.nSus = nSus;
        return this;
    }

    public String getnConvenio() {
        return nConvenio;
    }

    public MedicEntity setnConvenio(String nConvenio) {
        this.nConvenio = nConvenio;
        return this;
    }

    public String getTelefoneConvenio() {
        return telefoneConvenio;
    }

    public MedicEntity setTelefoneConvenio(String telefoneConvenio) {
        this.telefoneConvenio = telefoneConvenio;
        return this;
    }

    public String getHistorico() {
        return historico;
    }

    public MedicEntity setHistorico(String historico) {
        this.historico = historico;
        return this;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public MedicEntity setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
        return this;
    }

    public String getSexo() {
        return sexo;
    }

    public MedicEntity setSexo(String sexo) {
        this.sexo = sexo;
        return this;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public MedicEntity setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
        return this;
    }

    public String getAlergias() {
        return alergias;
    }

    public MedicEntity setAlergias(String alergias) {
        this.alergias = alergias;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public MedicEntity setObs(String obs) {
        this.obs = obs;
        return this;
    }
}
