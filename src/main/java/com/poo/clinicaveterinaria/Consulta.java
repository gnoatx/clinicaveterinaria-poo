package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Consulta {
    private static int ultimaId = 0;
    private int id;    
    private Medico medico;
    private String medicamento;
    private Pet pet;
    private String motivo;
    protected String observacoes;
    private LocalDateTime dataHora;
    private Tutor tutor;

    public Consulta(LocalDateTime dataHora, Medico medico,Tutor tutor, Pet pet, String motivo, String observacoes) {
        this.id = ++ultimaId;
        this.dataHora = dataHora;
        this.medico = medico;
        this.pet = pet;
        this.motivo = motivo;
        this.observacoes = observacoes;
        Dados.Consultas.add(this);
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = dataHora.format(formatter);
        return "Consulta" +
                "\n ⮞Data Hora: " + agoraFormatado +
                "\n ⮞Medico: " + medico.getNome() +
                "\n ⮞Pet: " + pet.getNome() + " ✔ | " + "Raça: " + pet.getRaca() + " ✔ | " + "Espécie: " + pet.getEspecie() +"✔ "+
                "\n ⮞Motivo='" + motivo +
                "\n ⮞Observacoes='" + observacoes;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Tutor getTutor() {
        return tutor;
    }
}
