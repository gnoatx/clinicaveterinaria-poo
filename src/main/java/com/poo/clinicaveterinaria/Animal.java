package com.projeto.veterinaria;

public class Animal {
    private static int ultimaId = 0;
    private int id;
    private String nome;
    private int idade;
    private double peso;
    
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
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    }
    
