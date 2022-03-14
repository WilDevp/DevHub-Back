package com.devhubback.controller;

import com.devhubback.model.Usuario;
import com.devhubback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>>findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable("id") Integer idUsusario){
        return usuarioService.findById(idUsusario).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario>create(@Valid @RequestBody Usuario usuario){return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.ACCEPTED);}

    @PutMapping
    public ResponseEntity<Usuario>update(@Valid @RequestBody Usuario usuario){
        return usuarioService.findById(usuario.getIdUsuario())
                .map(c->ResponseEntity.ok(usuarioService.update(usuario)))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable("id") Integer idUsuario){
        return usuarioService.findById(idUsuario)
                .map(c -> {usuarioService.delete(idUsuario);
                    return ResponseEntity.ok(c);
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
