package com.poo.clinicaveterinaria;

import java.util.List;
import java.util.ArrayList;

public class Prontuario {
    private static int ultimaId = 0;
    private int id;
    private Pet pet;
    private List<String> historicoConsultas;
    private String observacoes;

    public Prontuario(Pet pet) {
        this.id = ++ultimaId;
        this.pet = pet;
        this.historicoConsultas = new ArrayList<>();
        this.observacoes = "";

    }

    public void adicionarConsulta(String consulta) {
        historicoConsultas.add(consulta);
    }

    public void adicionarObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void exibirProntuario() {
        System.out.println("ID do Prontuário: " + id);
        System.out.println("Animal: " + pet.getNome() + " (" + pet.getEspecie() + ")");
        System.out.println("Observações:");
        System.out.println(observacoes);
        System.out.println("Histórico de Consultas:");
        for (String consulta : historicoConsultas) {
            System.out.println("- " + consulta);
        }
    }

    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<String> getHistoricoConsultas() {
        return historicoConsultas;
    }

    public void setHistoricoConsultas(ArrayList<String> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
