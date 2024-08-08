package br.qziul.sistema_saude.dtos;


public record TriagemEventDTO(
        Long codigoTriagem,
        PacienteEventDTO paciente,
        boolean atendido
) {}
