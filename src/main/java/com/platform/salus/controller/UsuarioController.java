package com.platform.salus.controller;

import com.platform.salus.config.Base;
import com.platform.salus.converter.UsuarioConverter;
import com.platform.salus.converter.input.UsuarioInput;
import com.platform.salus.converter.output.SalusErrorOutput;
import com.platform.salus.converter.output.UsuarioOutput;
import com.platform.salus.exceptions.InvalidPageRequestException;
import com.platform.salus.exceptions.SalusException;
import com.platform.salus.model.UsuarioEntity;
import com.platform.salus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/salus")
public class UsuarioController extends Base {

    private UsuarioService usuarioService;
    private UsuarioConverter usuarioConverter;

    @Autowired
    public UsuarioController(UsuarioService usuarioService, UsuarioConverter usuarioConverter) {
        this.usuarioConverter = usuarioConverter;
        this.usuarioService = usuarioService;
    }

    @PostMapping
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<UsuarioOutput> create(@RequestBody UsuarioInput usuario) {

        try {
            UsuarioEntity usuarioEntity = usuarioService.create(this.usuarioConverter.inputToEntity(usuario));

            return ok(this.usuarioConverter.entityToOutput(usuarioEntity));
        } catch (SalusException ex) {
            return error(new SalusErrorOutput(ex.getMessage()));
        }
    }
    
    @PutMapping
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UsuarioOutput> update(@PathVariable Long id, @RequestBody UsuarioInput usuario) {

        try {
        	UsuarioEntity usuarioEntity = usuarioService.update(id, this.usuarioConverter.inputToEntity(usuario)); //NÃO FUNCIONA DIREITO

            return ok(this.usuarioConverter.entityToOutput(usuarioEntity));
        } catch (SalusException ex) {
            return error(new SalusErrorOutput(ex.getMessage()));
        }
    }
    
    @GetMapping
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioOutput> findById(@PathVariable Long id) {

        try {
        	UsuarioEntity usuarioEntity = usuarioService.findById(id);

            return ok(this.usuarioConverter.entityToOutput(usuarioEntity));
        } catch (SalusException ex) {
            return error(new SalusErrorOutput(ex.getMessage()));
        }
    }
    
    @GetMapping
    @RequestMapping(value = "/list/{page}/{count}", method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioOutput>> list(@PathVariable Long page, @PathVariable Long count) {

        try {
            List<UsuarioEntity> usuarios = usuarioService.list(page, count);

            return ok(usuarios.stream()
                    .map(usuario -> this.usuarioConverter.entityToOutput(usuario))
                    .collect(Collectors.toList()));
        } catch (InvalidPageRequestException ex) {
            return error(new SalusErrorOutput(ex.getMessage()));
        }
    }
    
    @DeleteMapping
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UsuarioOutput> delete(@PathVariable Long id) {

        try {
        	UsuarioEntity usuarioEntity = usuarioService.delete(id);

            return ok("");
        } catch (SalusException ex) {
            return error(new SalusErrorOutput(ex.getMessage()));
        }
    }
}
