package br.qziul.sistema_saude.models;

public class Paciente {
    private Long pacienteId;
    private String nome;
    private String nascimento;
    private String cpf;
    private String telefone;
    private String cep;

    public Paciente() {}

    public Paciente(Long pacienteId, String nome, String nascimento, String cpf, String telefone, String cep) {
        this.pacienteId = pacienteId;
        this.nome = nome;
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "pacienteId=" + pacienteId +
                ", nome='" + nome + '\'' +
                ", nascimento='" + nascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'';
    }
}
