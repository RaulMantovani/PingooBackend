package br.edu.unifaj.cc.poo.pingoosb.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nota {
    private float valor;
    private String descricao;
}
