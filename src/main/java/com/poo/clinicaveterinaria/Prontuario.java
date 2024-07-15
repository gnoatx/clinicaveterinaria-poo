package com.poo.clinicaveterinaria;

import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Prontuario {
    private static int ultimaId = 0;
    private int id;
    private Pet pet;
    private Tutor tutor;
    private LocalDateTime dataHora;
    private String medicamento;
    private Medico medico;
    private List<String> historicoConsultas;
    private String observacoes;

    public Prontuario(LocalDateTime dataHora, Medico medico, Tutor tutor, Pet pet, String medicamento, String observacoes) {
        this.dataHora = LocalDateTime.now();
        this.medico = medico;
        this.pet = pet;
        this.tutor = tutor;
        this.medicamento = medicamento;
        this.observacoes = observacoes;

    }

    public void adicionarConsulta(String consulta) {
        historicoConsultas.add(consulta);
    }

    public String exibirProntuario() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = dataHora.format(formatter);
        return

        "ID do Prontuário: " + id +
                "\nData e hora do atendimento: " + agoraFormatado +
                "\nMédico: " + medico.getNome() + " (CRMV - " + medico.getCrmv() + ")" +
                "\nTutor: " + tutor.getNome() +
                "\nNome do pet: " + pet.getNome() + " (" + pet.getEspecie() + ")" +
                "\nRaça" + pet.getRaca() +
                "\nIdade: " + pet.getIdade() + "  |  " + "Peso: " + pet.getPeso() +
                "\nObservações: " + observacoes +
                "\nMedicamentos: " + medicamento;

        // for (String consulta : historicoConsultas) {
        // ("- " + consulta);
    }

    public int getId() {
        return id;
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

    public static int getUltimaId() {
        return ultimaId;
    }

    public static void setUltimaId(int ultimaId) {
        Prontuario.ultimaId = ultimaId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setHistoricoConsultas(List<String> historicoConsultas) {
        this.historicoConsultas = historicoConsultas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }
}
