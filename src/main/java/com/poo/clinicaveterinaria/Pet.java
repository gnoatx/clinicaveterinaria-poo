package com.poo.clinicaveterinaria;

public class Pet extends Animal {
    private static int ultimaId = 0;
    private int id;
    protected Tutor tutor;
    
 

    public Pet(String nome, String especie, String raca, int idade, double peso) {
        super(nome, especie, raca, idade, peso);
        this.id = ++ultimaId;
        Dados.Pets.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

}