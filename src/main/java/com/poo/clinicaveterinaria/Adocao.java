package com.poo.clinicaveterinaria;

import java.time.LocalDate;

public class Adocao {
    public static int ultimaId = 0;
    public int id;
    Resgate resgate;
    Tutor tutor;
    Animal animal;
    LocalDate dataDaAdocao;

    public static int getUltimaId() {
        return ultimaId;
    }

    public static void setUltimaId(int ultimaId) {
        Adocao.ultimaId = ultimaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resgate getResgate() {
        return resgate;
    }

    public void setResgate(Resgate resgate) {
        this.resgate = resgate;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public LocalDate getDataDaAdocao() {
        return dataDaAdocao;
    }

    public void setDataDaAdocao(LocalDate dataDaAdocao) {
        this.dataDaAdocao = dataDaAdocao;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}