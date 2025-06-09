package br.edu.unifaj.cc.poo.pingoosb.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendario {
    private String nomeEvento;
    private LocalDate dataEvento;
}
