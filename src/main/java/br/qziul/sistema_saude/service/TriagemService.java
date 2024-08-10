package br.qziul.sistema_saude.service;

import br.qziul.sistema_saude.controller.dtos.TriagemResponse;
import br.qziul.sistema_saude.events.TriagemEvent;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import br.qziul.sistema_saude.repository.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;

    public void save(TriagemEvent triagemEvent) {
        triagemRepository.save(triagemEvent.toEntity());
    }

    public List<TriagemResponse> getAll() {
        List<TriagemEntity> allEntities = triagemRepository.findAll();
        return allEntities.stream().map(TriagemResponse::toResponse).toList();
    }

    public TriagemResponse findById(Long id) {
        TriagemEntity triagemEntity = findEntityById(id);
        return TriagemResponse.toResponse(triagemEntity);
    }

    public TriagemResponse deleteById(Long id) {
        TriagemEntity triagemEntity = findEntityById(id);
        triagemRepository.deleteById(triagemEntity.getTriagemId());
        return TriagemResponse.toResponse(triagemEntity);
    }

    private TriagemEntity findEntityById(Long id) {
        return triagemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
