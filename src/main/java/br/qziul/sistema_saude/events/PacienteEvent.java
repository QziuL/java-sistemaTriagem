package br.qziul.sistema_saude.events;

public record PacienteEvent(
        String nome,
        String nascimento,
        String cpf,
        String telefone,
        String cep
) {}
