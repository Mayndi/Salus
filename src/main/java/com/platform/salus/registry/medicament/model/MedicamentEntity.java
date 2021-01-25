package com.platform.salus.registry.medicament.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "medicament", schema = "salus")
public class MedicamentEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeMedicamento;
        private LocalDate inicioMed;
        private LocalDate fimMed;
        private boolean usoContinuo;
        private Byte foto;

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
