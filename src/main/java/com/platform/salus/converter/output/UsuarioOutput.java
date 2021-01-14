package com.platform.salus.converter.output;

public class UsuarioOutput {

	private Long id;
	
	private String nomeCompleto;
	private String dataNascimento;
	private String cpf;
	private String email;
	private String senha;
	
	public Long getId() {
		return id;
	}

	public UsuarioOutput setId(Long id) {
		this.id = id;
		return this;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public UsuarioOutput setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
		return this;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public UsuarioOutput setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public String getCpf() {
		return cpf;
	}

	public UsuarioOutput setCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UsuarioOutput setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public UsuarioOutput setSenha(String senha) {
		this.senha = senha;
		return this;
	}
}
