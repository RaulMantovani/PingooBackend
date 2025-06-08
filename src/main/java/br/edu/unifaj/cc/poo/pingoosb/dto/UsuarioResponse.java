package br.edu.unifaj.cc.poo.pingoosb.dto;

import lombok.Data;

@Data
public class UsuarioResponse {
    private String mensagem;

    public UsuarioResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
