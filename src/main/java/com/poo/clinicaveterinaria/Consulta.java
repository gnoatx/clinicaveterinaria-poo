package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;

public class Consulta {
    private String veterinario;
    private String animal;
    private String motivo;
    private String observacoes;
    private LocalDateTime dataHora;

    public Consulta(LocalDateTime dataHora, String veterinario, String animal, String motivo, String observacoes) {
        this.dataHora = dataHora;
        this.veterinario = veterinario;
        this.animal = animal;
        this.motivo = motivo;
        this.observacoes = observacoes;
    }
     @Override
    public String toString() {
        return "Consulta{" +
                "Data Hora=" + dataHora +
                ", veterinario='" + veterinario + '\'' +
                ", animal='" + animal + '\'' +
                ", motivo='" + motivo + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
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
