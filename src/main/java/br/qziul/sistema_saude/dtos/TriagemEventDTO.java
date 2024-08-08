package br.qziul.sistema_saude.dtos;

import br.qziul.sistema_saude.models.Paciente;
import br.qziul.sistema_saude.models.entitys.TriagemEntity;

/**
 *  Verificar como alterar DTO para não receber os IDs.
 */
public record TriagemEventDTO(
        Long codigoTriagem,
        PacienteEventDTO paciente,
        boolean atendido
) {
    public TriagemEntity toEntity() {
        TriagemEntity triagemEntity = new TriagemEntity();
        triagemEntity.setTriagemId(this.codigoTriagem());
        triagemEntity.setAtendido(this.atendido());
        triagemEntity.setPaciente(setPaciente(this));
        return triagemEntity;
    }

    private static Paciente setPaciente(TriagemEventDTO triagemEventDTO) {
        return new Paciente(
                triagemEventDTO.paciente().codigoPaciente(),
                triagemEventDTO.paciente().nome(),
                triagemEventDTO.paciente().nascimento(),
                triagemEventDTO.paciente().cpf(),
                triagemEventDTO.paciente().telefone(),
                triagemEventDTO.paciente().cep());
    }
}
