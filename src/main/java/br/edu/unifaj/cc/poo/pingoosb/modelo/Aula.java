package br.edu.unifaj.cc.poo.pingoosb.modelo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aula {
    private int id;
    private String materia;
    private String professor;
    private String diaSemana;
    private List<String> anotacoes;
    private List<Nota> notas;

    public Aula(int andIncrement, String materia, String professor, String diaSemana) {
        this.id = andIncrement;
        this.materia = materia;
        this.professor = professor;
        this.diaSemana = diaSemana;
        this.anotacoes = new java.util.ArrayList<>();
        this.notas = new java.util.ArrayList<>();
    }
}
