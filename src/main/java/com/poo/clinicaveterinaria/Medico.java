package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;

public class Medico extends Funcionario {
    private static int ultimaId = 0;
    private int id;
    private String especialidade;
    private String crmv;
    String medicamento;

    public Medico(String nome, String telefone, String cpf, String crmv, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
        this.nome = nome;
        this.telefone = telefone;
        this.crmv = crmv;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrmv() {
        return crmv;
    }

    public void setCrmv(String crmv) {
        this.crmv = crmv;
    }

    public void lancarAtendimento(Pet pet, Atendente atendente){
        Atendimento atendimento = new Atendimento(pet, atendente);
        Dados.Atendimentos.add(atendimento);
        System.out.println("Atendimento lançado para o pet: " + pet.getNome());
    }

    public void lancarExame(){
    }
    
    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(loginDigitado) && this.getSenha().equals(senhaDigitada);
    }
    public void lancareceita(){
        System.out.println("paciente: "+ this.nome + " medicamento para tomar: "+ medicamento);
    }
}
