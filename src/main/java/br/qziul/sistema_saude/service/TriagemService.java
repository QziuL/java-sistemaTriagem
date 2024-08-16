package br.qziul.sistema_saude.service;

import br.qziul.sistema_saude.controller.dtos.TriagemResponse;
import br.qziul.sistema_saude.events.TriagemEvent;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import br.qziul.sistema_saude.repository.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;

    public void save(TriagemEvent triagemEvent) {
        triagemRepository.save(triagemEvent.toEntity());
    }

    public void update(TriagemEntity triagemEntity) {
        triagemRepository.save(triagemEntity);
    }

    public List<TriagemResponse> getAll() {
        List<TriagemEntity> allEntities = triagemRepository.findAll();
        return allEntities.stream().map(TriagemResponse::toResponse).toList();
    }

    public TriagemResponse findByIdAndReturnResponse(String id) {
        TriagemEntity triagemEntity = triagemRepository.findById(id).orElse(null);
        return (Objects.isNull(triagemEntity))
                ? null
                : TriagemResponse.toResponse(triagemEntity);
    }

    public TriagemEntity findByIdAndReturnEntity(String id) {
        return triagemRepository.findById(id).orElse(null);
    }

    public TriagemResponse deleteById(String id) {
        TriagemEntity triagemEntity = findByIdAndReturnEntity(id);
        if(Objects.isNull(triagemEntity))
            return null;
        triagemRepository.deleteById(id);
        return TriagemResponse.toResponse(triagemEntity);
    }
}
