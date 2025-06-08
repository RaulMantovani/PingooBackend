package br.edu.unifaj.cc.poo.pingoosb.dto;

import br.edu.unifaj.cc.poo.pingoosb.modelo.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AulaResponse {
    private int id;
    private String materia;
    private String professor;
    private String diaSemana;
    private List<Nota> notas;
    private List<String> anotacoes;
}
