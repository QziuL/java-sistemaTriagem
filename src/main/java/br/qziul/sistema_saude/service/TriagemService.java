package br.qziul.sistema_saude.service;

import br.qziul.sistema_saude.dtos.TriagemEventDTO;
import br.qziul.sistema_saude.repository.TriagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriagemService {
    @Autowired
    private TriagemRepository triagemRepository;

    public void save(TriagemEventDTO triagemEventDTO) {
        triagemRepository.save(triagemEventDTO.toEntity());
    }
}
