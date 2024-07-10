package com.poo.clinicaveterinaria;

public class Pet {
    private static int ultimaId = 0;
    private int id;
    private Animal animal;
    private Tutor tutor;

    public Pet(Animal animal, Tutor tutor) {
        this.id = ++ultimaId;
        this.animal = animal;
        this.tutor = tutor;
    }

    public static int getUltimaId() {
        return ultimaId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }
    public Tutor getTutor() {
        return tutor;
    }
}
