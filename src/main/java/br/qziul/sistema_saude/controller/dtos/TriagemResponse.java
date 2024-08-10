package br.qziul.sistema_saude.controller.dtos;

import br.qziul.sistema_saude.models.entitys.TriagemEntity;

public record TriagemResponse(
        Long triagemId,
        Long pacienteId,
        String pacienteNome,
        boolean atendido
) {
    public static TriagemResponse toResponse(TriagemEntity triagemEntity) {
        return new TriagemResponse(
                triagemEntity.getTriagemId(),
                triagemEntity.getPaciente().getPacienteId(),
                triagemEntity.getPaciente().getNome(),
                triagemEntity.isAtendido());
    }
}
