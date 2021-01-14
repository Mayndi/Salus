package com.platform.salus.service;

import com.platform.salus.config.Internationalization;
import com.platform.salus.exceptions.InvalidPageRequestException;
import com.platform.salus.exceptions.SalusException;
import com.platform.salus.model.UsuarioEntity;
import com.platform.salus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {

	private final Internationalization messagesBundle;
	private final UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(Internationalization Internationalization, UsuarioRepository usuarioRepository) {
		this.messagesBundle = Internationalization;
		this.usuarioRepository = usuarioRepository;
	}

	public UsuarioEntity create(UsuarioEntity usuario) throws SalusException {
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	public UsuarioEntity update(Long id, UsuarioEntity usuario) throws SalusException {

		UsuarioEntity usuarioEntityToSave = this.findById(id);
		UsuarioEntity updatedUsuario = usuarioRepository.save(usuarioEntityToSave);

		if (usuario == null) {
			throw new SalusException(this.messagesBundle.getMessage("invalid_user_information_id"));
		}

		return updatedUsuario;
	}

	public List<UsuarioEntity> list(Long page, Long count) throws InvalidPageRequestException {

		List<UsuarioEntity> usuarioEntityArrayList = usuarioRepository
				.findAll(PageRequest.of(page.intValue(), count.intValue())).toList();

		return usuarioEntityArrayList;
	}

	public UsuarioEntity findById(Long id) throws SalusException {

		UsuarioEntity usuario = usuarioRepository.getOne(id);

		if (usuario == null) {
			throw new SalusException(this.messagesBundle.getMessage("invalid_user_information_id"));
		}

		return usuario;
	}

	public UsuarioEntity delete(Long id) throws SalusException {

		UsuarioEntity usuario = this.findById(id);
		usuarioRepository.delete(usuario); 

		if (usuario == null) {
			throw new SalusException(this.messagesBundle.getMessage("invalid_user_information_id"));
		}

		return usuario;
	}
}
