package com.platform.salus.registry.user.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "user", schema = "salus")
public class UserEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeCompleto;
        private LocalDate dataNascimento;
        private String cpf;
        private String telefone;
        private String email;
        private String senha;
        private String confSenha;
        private Byte foto;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UserEntity setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UserEntity setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public UserEntity setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public UserEntity setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UserEntity setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public UserEntity setConfSenha(String confSenha) {
        this.confSenha = confSenha;
        return this;
    }

    public Byte getFoto() {
        return foto;
    }

    public UserEntity setFoto(Byte foto) {
        this.foto = foto;
        return this;
    }
}
