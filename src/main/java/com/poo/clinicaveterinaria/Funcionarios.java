package com.poo.clinicaveterinaria;

public abstract class Funcionarios extends Pessoa {
    private static int ultimaId = 0;
    private int id;

    public Funcionarios(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
    } 

    public int getUltimaId() {
        return ultimaId;
    }
    public int getId() {
        return id;
    }
}
