package com.poo.clinicaveterinaria;

public class Pet extends Animal {
    private static int ultimaId = 0;
    private int id;
    protected Tutor tutor;
    
 

    public Pet(String nome, String especie, String raca, int idade, double peso, Tutor tutor) {
        super(nome, especie, raca, idade, peso);
        this.id = ++ultimaId;
        this.tutor = tutor;
        Dados.Pets.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
        
    }
}