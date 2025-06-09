package br.edu.unifaj.cc.poo.pingoosb.service;

import br.edu.unifaj.cc.poo.pingoosb.dto.CalendarioResponse;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioLogin;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioRegistro;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioResponse;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Calendario;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalendarioService {

    private List<Calendario> calendarios = new ArrayList<>();

    public CalendarioResponse registrar(Calendario dto) {
        calendarios.add(dto);

        return new CalendarioResponse("Evento registrado com sucesso.");
    }

    public List<Calendario> listar() {
        return calendarios;
    }
}
