package br.qziul.sistema_saude.repository;

import br.qziul.sistema_saude.models.entitys.TriagemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriagemRepository extends MongoRepository<TriagemEntity, Long> {}
