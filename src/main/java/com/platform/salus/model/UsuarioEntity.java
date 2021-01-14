package com.platform.salus.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuario", schema = "salus")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    private LocalDate dataNascimento;
    private String cpf;
    private String email;
    private String senha;
    private String confSenha;
    private byte[] imagem;

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public UsuarioEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public UsuarioEntity setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public UsuarioEntity setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public UsuarioEntity setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsuarioEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public UsuarioEntity setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getConfSenha() {
        return confSenha;
    }

    public UsuarioEntity setConfSenha(String confSenha) {
        this.confSenha = confSenha;
        return this;
    }
}
