package br.qziul.sistema_saude.controller.dtos;

import br.qziul.sistema_saude.models.entitys.TriagemEntity;

public record TriagemResponse(
        String triagemId,
        String pacienteNome,
        boolean atendido) {
    public static TriagemResponse toResponse(TriagemEntity triagemEntity) {
        return new TriagemResponse(
                triagemEntity.getTriagemId(),
                triagemEntity.getPaciente().getNome(),
                triagemEntity.atendido());
    }
}
