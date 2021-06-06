package com.platform.salus.registryUser.medicament.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.platform.salus.registryUser.user.model.UserEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicament", schema = "user")
public class MedicamentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMedicamento;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicioMed;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fimMed;
    private boolean usoContinuo;
    private Byte foto;
    @OneToOne
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public MedicamentEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Long getId() {
        return id;
    }

    public MedicamentEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public MedicamentEntity setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
        return this;
    }

    public LocalDate getInicioMed() {
        return inicioMed;
    }

    public MedicamentEntity setInicioMed(LocalDate inicioMed) {
        this.inicioMed = inicioMed;
        return this;
    }

    public LocalDate getFimMed() {
        return fimMed;
    }

    public MedicamentEntity setFimMed(LocalDate fimMed) {
        this.fimMed = fimMed;
        return this;
    }

    public boolean isUsoContinuo() {
        return usoContinuo;
    }

    public MedicamentEntity setUsoContinuo(boolean usoContinuo) {
        this.usoContinuo = usoContinuo;
        return this;
    }

    public Byte getFoto() {
        return foto;
    }

    public MedicamentEntity setFoto(Byte foto) {
        this.foto = foto;
        return this;
    }
}
