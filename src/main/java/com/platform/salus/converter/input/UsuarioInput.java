package com.platform.salus.converter.input;

public class UsuarioInput {

	private String nomeCompleto;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String senha;
    private String confSenha;
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public UsuarioInput setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		return this;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public UsuarioInput setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}
	public String getCpf() {
		return cpf;
	}
	public UsuarioInput setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}
	public String getEmail() {
		return email;
	}
	public UsuarioInput setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getSenha() {
		return senha;
	}
	public UsuarioInput setSenha(String senha) {
		this.senha = senha;
		return this;
	}
	public String getConfSenha() {
		return confSenha;
	}
	public UsuarioInput setConfSenha(String confSenha) {
		this.confSenha = confSenha;
		return this;
	}
}
