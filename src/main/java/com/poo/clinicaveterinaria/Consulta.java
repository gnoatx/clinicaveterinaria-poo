package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;

public class Consulta {
    private Medico medico;
    private String animal;
    private String motivo;
    protected String observacoes;
    private LocalDateTime dataHora;

    public Consulta(LocalDateTime dataHora, Medico medico, String animal, String motivo, String observacoes) {
        this.dataHora = LocalDateTime.now();
        this.medico = medico;
        this.animal = animal;
        this.motivo = motivo;
        this.observacoes = observacoes;
        Dados.Consultas.add(this);
    }

    public String toString() {
        return "Consulta" +
                "\nData Hora=" + dataHora +
                "\n Medico='" + medico.getNome()+
                "\n animal='" + animal+
                "\n motivo='" + motivo +
                "\n observacoes='" + observacoes;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}
