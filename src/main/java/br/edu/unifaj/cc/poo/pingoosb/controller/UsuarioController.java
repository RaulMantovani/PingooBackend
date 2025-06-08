package br.edu.unifaj.cc.poo.pingoosb.controller;

import br.edu.unifaj.cc.poo.pingoosb.dto.*;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Usuario;
import br.edu.unifaj.cc.poo.pingoosb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registrar")
    public UsuarioResponse registrar(@RequestBody UsuarioRegistro dto) {
        return usuarioService.registrar(dto);
    }

    @PostMapping("/login")
    public UsuarioResponse login(@RequestBody UsuarioLogin dto) {
        return usuarioService.login(dto);
    }

    @GetMapping("/listar")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }
}
