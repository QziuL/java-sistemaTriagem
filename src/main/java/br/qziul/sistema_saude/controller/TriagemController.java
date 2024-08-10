package br.qziul.sistema_saude.controller;

import br.qziul.sistema_saude.controller.dtos.TriagemResponse;
import br.qziul.sistema_saude.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TriagemController {
    @Autowired
    private TriagemService triagemService;

    @GetMapping("/triagem")
    public ResponseEntity<List<TriagemResponse>> getAll() {
        return ResponseEntity.ok(triagemService.getAll());
    }

    @GetMapping("/triagem/{triagemId}")
    public ResponseEntity<TriagemResponse> getById(@PathVariable("triagemId") Long triagemId) {
        TriagemResponse triagemResponse = triagemService.findById(triagemId);
        return ResponseEntity.ok(triagemResponse);
    }

    @DeleteMapping("/triagem/{triagemId}")
    public ResponseEntity<TriagemResponse> deleteById(@PathVariable("triagemId") Long triagemId) {
        return ResponseEntity.ok(triagemService.deleteById(triagemId));
    }

    /*@PutMapping("/triagem/{triagemId}")
    public ResponseEntity<TriagemResponse> updateById(@PathVariable("triagemId") Long triagemId,
                                                      @RequestBody TriagemEntity triagemEntity) {

    }*/
}
