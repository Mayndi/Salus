package com.platform.salus.config;

import com.platform.salus.model.UsuarioEntity;
import com.platform.salus.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Check {

    private final UsuarioRepository usuarioRepository;
    private final Internationalization messagesBundle;

    @Autowired
    public Check(UsuarioRepository usuarioRepository,
                   Internationalization internationalizationConfig){
        this.usuarioRepository = usuarioRepository;
        this.messagesBundle = internationalizationConfig;
    }

    public boolean healthCheck(){

        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNomeCompleto(this.messagesBundle.getMessage("test_salus_name"));

        usuarioRepository.save(usuarioEntity);

        usuarioRepository.delete(usuarioEntity);

        return true;
    }
}

