package br.edu.unifaj.cc.poo.pingoosb.controller;

import br.edu.unifaj.cc.poo.pingoosb.dto.CalendarioResponse;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioLogin;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioRegistro;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioResponse;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Calendario;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Usuario;
import br.edu.unifaj.cc.poo.pingoosb.service.CalendarioService;
import br.edu.unifaj.cc.poo.pingoosb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CalendarioController {

    @Autowired
    private CalendarioService calendarioService;

    @PostMapping("/calendario/registrar")
    public CalendarioResponse registrar(@RequestBody Calendario dto) {

        return calendarioService.registrar(dto);
    }

    @GetMapping("/calendario/listar")
    public List<Calendario> listar() {
        return calendarioService.listar();
    }
}
