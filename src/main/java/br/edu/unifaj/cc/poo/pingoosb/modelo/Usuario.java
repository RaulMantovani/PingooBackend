package br.edu.unifaj.cc.poo.pingoosb.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String usuario;
    private String email;
    private String senha;

}
