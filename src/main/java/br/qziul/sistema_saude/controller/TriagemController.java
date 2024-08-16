package br.qziul.sistema_saude.controller;

import br.qziul.sistema_saude.controller.dtos.TriagemTotalResponse;
import br.qziul.sistema_saude.controller.dtos.TriagemResponse;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import br.qziul.sistema_saude.service.TriagemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<TriagemResponse> getById(@PathVariable("triagemId") String triagemId) {
        TriagemResponse triagemResponse = triagemService.findByIdAndReturnResponse(triagemId);
        return (Objects.isNull(triagemResponse))
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(triagemResponse);
    }

    @DeleteMapping("/triagem/{triagemId}")
    public ResponseEntity<TriagemResponse> deleteById(@PathVariable("triagemId") String triagemId) {
        TriagemResponse triagemResponse = triagemService.deleteById(triagemId);
        return (Objects.isNull(triagemResponse))
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(triagemResponse);
    }

    @PutMapping("/triagem/{triagemId}")
    public ResponseEntity<Object> updateById(
            @PathVariable("triagemId") String triagemId,
            @RequestBody TriagemResponse requestBody
    ) {
        TriagemEntity triagemEntity = triagemService.findByIdAndReturnEntity(requestBody.triagemId());
        if(Objects.isNull(triagemEntity))
            return ResponseEntity.notFound().build();

//      triagemEntity.setTriagemId(triagemEntity.getTriagemId());
        if(!Objects.equals(triagemEntity.getPaciente().getNome(), requestBody.pacienteNome()))
            triagemEntity.getPaciente().setNome(requestBody.pacienteNome());
        if(!Objects.equals(triagemEntity.atendido(), requestBody.atendido()))
            triagemEntity.setAtendido(requestBody.atendido());

//        BeanUtils.copyProperties(bodyEntity, entity);
//        System.out.println(bodyEntity.getPaciente());
//        entity.setPaciente(triagemEntity.getPaciente());
        triagemService.update(triagemEntity);

        return ResponseEntity.ok(TriagemResponse.toResponse(triagemEntity));
    }
}
