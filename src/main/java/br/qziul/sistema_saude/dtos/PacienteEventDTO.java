package br.qziul.sistema_saude.dtos;

public record PacienteEventDTO(
        Long codigoPaciente,
        String nome,
        String nascimento,
        String cpf,
        String telefone,
        String cep
) {}
