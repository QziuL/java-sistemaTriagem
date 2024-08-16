package br.qziul.sistema_saude.controller;

import br.qziul.sistema_saude.controller.dtos.request.TriagemUpdateRequest;
import br.qziul.sistema_saude.controller.dtos.response.TriagemTotalResponse;
import br.qziul.sistema_saude.controller.dtos.response.TriagemResponse;
import br.qziul.sistema_saude.models.Paciente;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import br.qziul.sistema_saude.service.TriagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class TriagemController {
    @Autowired
    private TriagemService triagemService;

    @GetMapping("/triagem")
    public ResponseEntity<TriagemTotalResponse> getAll() {
        List<TriagemResponse> triagemResponses = triagemService.getAll();
        int naoAtendidos = 0;
        int total = triagemResponses.size();

        for(TriagemResponse t : triagemResponses) {
            if(!t.atendido()) naoAtendidos++;
        }

        TriagemTotalResponse response = new TriagemTotalResponse(total, naoAtendidos, triagemResponses);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/triagem/{triagemId}")
    public ResponseEntity<Object> getById(@PathVariable("triagemId") String triagemId) {
        TriagemResponse triagemResponse = triagemService.findByIdAndReturnResponse(triagemId);
        return (Objects.isNull(triagemResponse))
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID ["+ triagemId +"] not found.")
                : ResponseEntity.ok(triagemResponse);
    }

    @DeleteMapping("/triagem/{triagemId}")
    public ResponseEntity<Object> deleteById(@PathVariable("triagemId") String triagemId) {
        TriagemResponse triagemResponse = triagemService.deleteById(triagemId);
        return (Objects.isNull(triagemResponse))
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID ["+ triagemId +"] not found.")
                : ResponseEntity.ok(triagemResponse);
    }

    @PutMapping("/triagem/{triagemId}")
    public ResponseEntity<Object> updateById(
            @PathVariable("triagemId") String triagemId,
            @RequestBody TriagemUpdateRequest requestBody
    ) {
        TriagemEntity triagemEntity = triagemService.findByIdAndReturnEntity(triagemId);
        if(Objects.isNull(triagemEntity))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID ["+ triagemId +"] not found.");
//        if(!Objects.equals(triagemEntity.getPaciente().getNome(), requestBody.pacienteNome()))
//            triagemEntity.getPaciente().setNome(requestBody.pacienteNome());
        if(!Objects.equals(triagemEntity.atendido(), requestBody.atendido()))
            triagemEntity.setAtendido(requestBody.atendido());
        triagemService.update(triagemEntity);

        return ResponseEntity.ok(TriagemResponse.toResponse(triagemEntity));
    }

    @GetMapping("triagem/{triagemId}/paciente")
    public ResponseEntity<Object> getPacienteByTriagemId(@PathVariable("triagemId") String triagemId) {
        Paciente paciente = triagemService.findPacienteByTriagemId(triagemId);
        return (Objects.isNull(paciente))
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID ["+ triagemId +"] not found.")
                : ResponseEntity.ok(paciente);
    }
}
