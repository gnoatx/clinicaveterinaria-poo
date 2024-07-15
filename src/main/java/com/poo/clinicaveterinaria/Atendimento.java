package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;

public class Atendimento {
    private static int ultimaId = 0;
    private int id;
    private Pet pet;
    private Atendente atendente;
    private LocalDateTime dataHora;

    public Atendimento(Pet pet, Atendente atendente) {
        this.id = ++ultimaId;
        this.pet = pet;
        this.atendente = atendente;
        dataHora = LocalDateTime.now();
        Dados.Atendimentos.add(this);
    }

    public int getId() {
        return id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

}
