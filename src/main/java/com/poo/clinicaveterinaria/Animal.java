package com.poo.clinicaveterinaria;

import java.time.LocalDate;
import java.time.Period;

public abstract class Animal {
    protected static int ultimaId = 0;
    protected int id;
    protected String nome;
    protected int idade;
    protected double peso;
    protected LocalDate dataCadastro;
    protected String especie;

    public Animal(String nome, String especie, int idade, double peso) {
        this.id = ++ultimaId;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.peso = peso;
        this.dataCadastro = LocalDate.now();
    }

    public int getUltimaId() {
        return ultimaId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade + Period.between(dataCadastro, LocalDate.now()).getYears();
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

}
