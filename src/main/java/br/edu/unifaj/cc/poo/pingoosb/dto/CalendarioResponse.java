package br.edu.unifaj.cc.poo.pingoosb.dto;

import lombok.Data;

@Data
public class CalendarioResponse {
    private String mensagem;

    public CalendarioResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
