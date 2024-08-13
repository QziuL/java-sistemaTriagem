package br.qziul.sistema_saude.models.entitys;

import br.qziul.sistema_saude.models.Paciente;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Document(collection = "tb_triagens")
public class TriagemEntity {
    @MongoId
    private Long triagemId;

    @Indexed(name = "atendidos_index")
    private boolean atendido;

    private Paciente paciente;

    public TriagemEntity() {}

    public Long getTriagemId() {
        return triagemId;
    }

    public void setTriagemId(Long triagemId) {
        this.triagemId = triagemId;
    }

    public boolean atendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return  "triagemId=" + triagemId +
                ", atendido=" + atendido +
                //", qtdPacientesEsperando=" + qtdPacientesEsperando +
                ", paciente=" + paciente;
    }
}
