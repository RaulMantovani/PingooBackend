package br.edu.unifaj.cc.poo.pingoosb.controller;

import br.edu.unifaj.cc.poo.pingoosb.dto.AulaRequest;
import br.edu.unifaj.cc.poo.pingoosb.dto.AulaResponse;
import br.edu.unifaj.cc.poo.pingoosb.dto.NotaRequest;
import br.edu.unifaj.cc.poo.pingoosb.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aulas")
@CrossOrigin
public class AulaController {

    @Autowired
    private AulaService aulaService;

    @GetMapping
    public List<AulaResponse> listarAulas() {
        return aulaService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AulaResponse> buscarPorId(@PathVariable int id) {
        AulaResponse aula = aulaService.buscarPorId(id);
        if (aula != null) {
            return ResponseEntity.ok(aula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/notas")
    public ResponseEntity<AulaResponse> adicionarNota(@PathVariable int id, @RequestBody NotaRequest notaRequest) {
        try {
            AulaResponse atualizada = aulaService.adicionarNota(id, notaRequest);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AulaResponse adicionarAula(@RequestBody AulaRequest request) {
        return aulaService.adicionar(request);
    }

    @PutMapping("/{id}")
    public AulaResponse atualizarAula(@PathVariable int id, @RequestBody AulaRequest request) {
        return aulaService.atualizarAula(id, request);
    }
}

