package br.edu.unifaj.cc.poo.pingoosb.controller;

import br.edu.unifaj.cc.poo.pingoosb.dto.AnotacaoRequest;
import br.edu.unifaj.cc.poo.pingoosb.modelo.Anotacao;
import br.edu.unifaj.cc.poo.pingoosb.service.AnotacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anotacoes")
@CrossOrigin
public class AnotacaoController {

    private final AnotacaoService service;

    public AnotacaoController (AnotacaoService service){
        this.service = service;
    }

    @GetMapping
    public List<Anotacao> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anotacao> buscarPorId(@PathVariable int id) {
        Anotacao anotacao = service.buscarPorId(id);
        if (anotacao != null) {
            return ResponseEntity.ok(anotacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Anotacao adicionar(@RequestBody AnotacaoRequest request){
        return service.adicionar(request);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    public Anotacao atualizar(@PathVariable int id, @RequestBody AnotacaoRequest request){
        return service.atualizar(id, request);
    }

}
