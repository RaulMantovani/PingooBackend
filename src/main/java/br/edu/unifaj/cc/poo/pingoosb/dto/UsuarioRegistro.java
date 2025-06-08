package br.edu.unifaj.cc.poo.pingoosb.dto;

import lombok.Data;

@Data
public class UsuarioRegistro {
    private String usuario;
    private String email;
    private String senha;
}
