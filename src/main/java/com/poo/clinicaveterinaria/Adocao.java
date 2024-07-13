package com.poo.clinicaveterinaria;

import java.time.LocalDate;

public class Adocao extends Animal{
    private static int ultimaId = 0;
    private int id;
    protected String tutor;
    protected LocalDate dataDaAdocao;

    public Adocao(LocalDate dataDaAdocao, String nome, String especie, String raca, int idade, double peso){
       super(nome, especie, raca, idade, peso);
        this.id = ++ultimaId;
        this.dataDaAdocao = LocalDate.now();
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.peso = peso;
        this.idade = idade;
        Dados.Adocoes.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataDaAdocao() {
        return dataDaAdocao;
    }

    public void setDataDaAdocao(LocalDate dataDaAdocao) {
        this.dataDaAdocao = LocalDate.now();
    }
}