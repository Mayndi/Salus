package com.platform.salus.converter;

import com.platform.salus.config.Internationalization;
import com.platform.salus.converter.input.UsuarioInput;
import com.platform.salus.converter.output.UsuarioOutput;
import com.platform.salus.model.UsuarioEntity;
import com.platform.salus.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioConverter {

	private final Internationalization messagesBundle;
	private final ConverterUtils converter;

	@Autowired
	public UsuarioConverter(Internationalization internationalization, ConverterUtils converter) {
		this.messagesBundle = internationalization;
		this.converter = converter;
	}

	public UsuarioEntity inputToEntity(UsuarioInput input) {
		return new UsuarioEntity()
				.setNomeCompleto(input.getNomeCompleto())
				.setDataNascimento(converter.convertStringToLocalDate(input.getDataNascimento()))
				.setCpf(input.getCpf())
				.setEmail(input.getEmail())
				.setSenha(input.getSenha())
				.setConfSenha(input.getConfSenha());
	}

	public UsuarioOutput entityToOutput(UsuarioEntity usuario) {
		UsuarioOutput usuarioOutput = new UsuarioOutput();
		usuarioOutput.setId(usuario.getId())
		.setNomeCompleto(usuario.getNomeCompleto())
		.setDataNascimento(converter.convertDateToString(usuario.getDataNascimento()))
		.setCpf(usuario.getCpf())
		.setEmail(usuario.getEmail())
		.setSenha(usuario.getSenha());

		return usuarioOutput;
	}
}
