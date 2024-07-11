package com.poo.clinicaveterinaria;

public class Pet extends Animal {
    private static int ultimaId = 0;
    private int id;
    protected Tutor tutor;
 

    public Pet(String nome, String especie, int idade, double peso, Tutor tutor) {
        super(nome, especie, idade, peso);
        this.id = ++ultimaId;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
        
    }

    }