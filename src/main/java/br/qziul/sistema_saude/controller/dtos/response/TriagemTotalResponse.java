package br.qziul.sistema_saude.controller.dtos.response;

import java.util.List;

public record TriagemTotalResponse(Integer total,
                                   Integer naoAtendidos,
                                   List<TriagemResponse> triagens) {
}
