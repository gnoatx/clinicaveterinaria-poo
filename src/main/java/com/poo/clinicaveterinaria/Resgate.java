package com.poo.clinicaveterinaria;
import java.util.ArrayList;
import java.time.LocalDate;

public class Resgate extends Animal {
    private static int contador = 1;
    private static ArrayList<Resgate> Resgates = new ArrayList<>();
    private String localDoResgate;
    private LocalDate dataResgate;
    private String descricao;
    private int numeroDoResgate;
    private boolean adotado;



    public Resgate(String nome, String especie, int idade, double peso, String localDoResgate, LocalDate dataResgate, String descricao, int numeroDoResgate) {
        super(nome, especie, idade, peso);
        this.localDoResgate = localDoResgate;
        this.descricao = descricao;
        this.dataResgate = LocalDate.now();
        this.numeroDoResgate = contador++;
        Resgates.add(this);
    }

    public void exibirResgate() {
        System.out.println("Número do resgate: " + this.numeroDoResgate);
        System.out.println("Nome do animal resgatado: " + this.nome);
        System.out.println("Espécie do animal resgatado" + this.especie);
        System.out.println("Data do resgate: " + this.dataResgate);
        System.out.println("Local do resgate: " + this.localDoResgate);
        System.out.println("Descrição do resgate: " + this.descricao);
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Resgate.contador = contador;
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

    public int getNumeroDoResgate() {
        return numeroDoResgate;
    }

    public void setNumeroDoResgate(int numeroDoResgate) {
        this.numeroDoResgate = numeroDoResgate;
    }
}
