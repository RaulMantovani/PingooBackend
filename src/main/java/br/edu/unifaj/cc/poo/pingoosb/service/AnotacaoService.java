package br.edu.unifaj.cc.poo.pingoosb.service;

import br.edu.unifaj.cc.poo.pingoosb.dto.AnotacaoRequest;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Anotacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnotacaoService {
    private List<Anotacao> anotacoes = new ArrayList<>();
    private int proximoId = 1;

    public List<Anotacao> listar(){
        return anotacoes;
    }

    public Anotacao buscarPorId(int id) {
        return anotacoes.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Anotacao adicionar(AnotacaoRequest request){
        Anotacao nova = new Anotacao();
        nova.setId(proximoId++);
        nova.setTitulo(request.getTitulo());
        nova.setConteudo(request.getConteudo());
        anotacoes.add(nova);
        return nova;
    }

    public void excluir(int id){
        anotacoes.removeIf(a -> a.getId() == id);
    }

    public Anotacao atualizar(int id, AnotacaoRequest request){
        Anotacao anotacao = buscarPorId(id);
        if (anotacao != null) {
            anotacao.setTitulo(request.getTitulo());
            anotacao.setConteudo(request.getConteudo());
        }
        return anotacao;
    }
}
