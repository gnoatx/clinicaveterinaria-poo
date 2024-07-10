package com.poo.clinicaveterinaria;

public class Tutor extends Pessoa {
    private static int ultimaId = 0;
    private int id;
    
    public Tutor(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
        this.id = ++ultimaId;
    }

    public void verProntuario() {

    }

    public void agendarConsulta() {

    }

    public void listarAdocoes() {

    }

    public int getId() {
        return id;
    }

}
