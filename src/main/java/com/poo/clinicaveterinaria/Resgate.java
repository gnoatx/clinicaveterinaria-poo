package com.poo.clinicaveterinaria;

import java.time.LocalDate;

public class Resgate extends Animal {
    private static int ultimaId = 0;
    private int id;
    private String localDoResgate;
    private LocalDate dataResgate;
    private String descricao;
    private boolean adotado;

    public Resgate(String nome, String especie, int idade, double peso, String localDoResgate, LocalDate dataResgate,
            String descricao) {
        super(nome, especie, idade, peso);
        this.localDoResgate = localDoResgate;
        this.descricao = descricao;
        this.dataResgate = LocalDate.now();
        this.id = ++ultimaId;
        this.adotado = false;
        Dados.Resgates.add(this);
    }

    public void exibirResgate() {
        System.out.println("Número do resgate: " + this.id);
        System.out.println("Nome do animal resgatado: " + this.nome);
        System.out.println("Espécie do animal resgatado: " + this.especie);
        System.out.println("Data do resgate: " + this.dataResgate);
        System.out.println("Local do resgate: " + this.localDoResgate);
        System.out.println("Descrição do resgate: " + this.descricao);
    }

    public int getUltimaId() {
        return ultimaId;
    }

    public int getId() {
        return id;
    }

    public String getLocalDoResgate() {
        return localDoResgate;
    }

    public void setLocalDoResgate(String localDoResgate) {
        this.localDoResgate = localDoResgate;
    }

    public LocalDate getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(LocalDate dataResgate) {
        this.dataResgate = dataResgate;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }

    public boolean getAdotado() {
        return adotado;
    }

}
