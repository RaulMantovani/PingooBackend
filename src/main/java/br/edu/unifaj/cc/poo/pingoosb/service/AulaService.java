package br.edu.unifaj.cc.poo.pingoosb.service;

import br.edu.unifaj.cc.poo.pingoosb.dto.AnotacoesAulaRequest;
import br.edu.unifaj.cc.poo.pingoosb.dto.AulaRequest;
import br.edu.unifaj.cc.poo.pingoosb.dto.AulaResponse;
import br.edu.unifaj.cc.poo.pingoosb.dto.NotaRequest;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Aula;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Nota;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AulaService {

    private final List<Aula> aulas = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(1);

    public List<AulaResponse> listar() {
        List<AulaResponse> resposta = new ArrayList<>();
        for (Aula aula : aulas) {
            resposta.add(toResponse(aula));
        }
        return resposta;
    }

    public AulaResponse buscarPorId(int id) {
        for (Aula aula : aulas) {
            if (aula.getId() == id) {
                return toResponse(aula);
            }
        }
        return null; // ou lançar exceção se preferir
    }

    public AulaResponse adicionar(AulaRequest request) {
        Aula nova = new Aula(
                contadorId.getAndIncrement(),
                request.getMateria(),
                request.getProfessor(),
                request.getDiaSemana()
        );
        aulas.add(nova);
        return toResponse(nova);
    }

    public AulaResponse atualizarAula(int id, AulaRequest request) {
        Optional<Aula> aulaOpt = aulas.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (aulaOpt.isPresent()) {
            Aula aula = aulaOpt.get();
            aula.setMateria(request.getMateria());
            aula.setProfessor(request.getProfessor());
            aula.setDiaSemana(request.getDiaSemana());
            return toResponse(aula);
        } else {
            // Pode lançar exceção, retornar null ou criar nova aula, dependendo da sua regra
            throw new RuntimeException("Aula não encontrada com id: " + id);
        }
    }

    public AulaResponse adicionarNota(int id, NotaRequest notaRequest) {
        Optional<Aula> aulaOpt = aulas.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (aulaOpt.isPresent()) {
            Aula aula = aulaOpt.get();
            aula.getNotas().add(new Nota(notaRequest.getValor(), notaRequest.getDescricao()));
            return toResponse(aula);
        } else {
            throw new RuntimeException("Aula não encontrada com id: " + id);
        }
    }

    public AulaResponse adicionarAnotacao(int id, AnotacoesAulaRequest anotacaoRequest) {
        Optional<Aula> aulaOpt = aulas.stream()
                .filter(a -> a.getId() == id)
                .findFirst();

        if (aulaOpt.isPresent()) {
            Aula aula = aulaOpt.get();
            aula.getAnotacoes().add(anotacaoRequest.getTexto());
            return toResponse(aula);
        } else {
            throw new RuntimeException("Aula não encontrada com id: " + id);
        }
    }

    public void excluirAula(int id) {
        boolean removida = aulas.removeIf(aula -> aula.getId() == id);
        if (!removida) {
            throw new RuntimeException("Aula não encontrada com id: " + id);
        }
    }

    private AulaResponse toResponse(Aula aula) {
        return new AulaResponse(
                aula.getId(),
                aula.getMateria(),
                aula.getProfessor(),
                aula.getDiaSemana(),
                aula.getNotas(),
                aula.getAnotacoes()
        );
    }
}
