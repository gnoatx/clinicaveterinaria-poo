package com.poo.clinicaveterinaria;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Atendimento {
    private static int ultimaId = 0;
    private int id;
    private Pet pet;
    private Atendente atendente;
    private LocalDateTime horario;

    public Atendimento(Pet pet, Atendente atendente) {
        this.id = ++ultimaId;
        this.pet = pet;
        this.atendente = atendente;
        horario = LocalDateTime.now();
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

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public LocalDateTime getHorario() {
        return horario;
    }
    public void acessarpetsDisponiveis(){
        System.out.println("ANIMAIS DISPONIVEIS \n");
        

    }
}
