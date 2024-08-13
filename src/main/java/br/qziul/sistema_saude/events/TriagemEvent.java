package br.qziul.sistema_saude.events;

import br.qziul.sistema_saude.models.Paciente;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;

public record TriagemEvent(
        Long triagemId,
        PacienteEvent paciente,
        boolean atendido
) {
    public TriagemEntity toEntity() {
        TriagemEntity triagemEntity = new TriagemEntity();
        triagemEntity.setTriagemId(this.triagemId());
        triagemEntity.setAtendido(this.atendido());
        triagemEntity.setPaciente(setPaciente(this));
        return triagemEntity;
    }

    private static Paciente setPaciente(TriagemEvent triagemEvent) {
        return new Paciente(
                triagemEvent.paciente().nome(),
                triagemEvent.paciente().nascimento(),
                triagemEvent.paciente().cpf(),
                triagemEvent.paciente().telefone(),
                triagemEvent.paciente().cep());
    }
}
