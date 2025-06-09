package br.edu.unifaj.cc.poo.pingoosb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnotacaoRequest {
    private String titulo;
    private String conteudo;
}
