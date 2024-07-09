package com.poo.clinicaveterinaria;

public abstract class Funcionarios extends Pessoa {
    private static int ultimaId = 0;
    private int id;

    public int getUltimaId() {
        return ultimaId;
    }
    public int getId() {
        return id;
    }
}
