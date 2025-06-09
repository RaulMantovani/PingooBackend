package br.edu.unifaj.cc.poo.pingoosb.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Anotacao {
    private int id;
    private String titulo;
    private String conteudo;

}
