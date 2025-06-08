package br.edu.unifaj.cc.poo.pingoosb.service;

import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioLogin;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioRegistro;
import br.edu.unifaj.cc.poo.pingoosb.dto.UsuarioResponse;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public UsuarioResponse registrar(UsuarioRegistro dto) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(dto.getEmail())) {
                return new UsuarioResponse("Email já cadastrado.");
            }
            if (u.getUsuario().equalsIgnoreCase(dto.getUsuario())) {
                return new UsuarioResponse("Usuário já existe.");
            }
        }

        Usuario novo = new Usuario();
        novo.setUsuario(dto.getUsuario());
        novo.setEmail(dto.getEmail());
        novo.setSenha(dto.getSenha());

        usuarios.add(novo);

        return new UsuarioResponse("Usuário registrado com sucesso.");
    }

    public UsuarioResponse login(UsuarioLogin dto) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(dto.getUsuario()) &&
                    u.getSenha().equals(dto.getSenha())) {
                return new UsuarioResponse("Login bem-sucedido.");
            }
        }

        return new UsuarioResponse("Usuário ou senha inválidos.");
    }

    public List<Usuario> listar() {
        return usuarios;
    }
}
