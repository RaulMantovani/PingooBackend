package br.edu.unifaj.cc.poo.pingoosb.dto;

import lombok.Data;


@Data
public class AulaRequest {
    private String materia;
    private String professor;
    private String diaSemana;
}
