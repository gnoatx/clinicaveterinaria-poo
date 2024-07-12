package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;
import java.util.List;

public class Tutor extends Pessoa {
    private static int ultimaId = 0;
    private int id;

    public Tutor(String nome, String telefone, String cpf, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
    }

    public void verProntuario(Pet pet) {
        List<Prontuario> prontuarios = Dados.Prontuarios;
        System.out.println("----- Prontuários dos Pets -----");
        for (Prontuario prontuario : prontuarios) {
            if (prontuario.getPet().equals(pet) && prontuario.getPet().getTutor().equals(this)) {
                prontuario.exibirProntuario();
                return;
            }
        }
        
        System.out.println("Prontuário não encontrado para o pet " + pet.getNome());
    }

    public void agendarConsulta(LocalDateTime dataHora, String veterinario, String animal, String motivo, String observacoes) {
        Consulta consulta = new Consulta (dataHora, veterinario, animal, motivo, observacoes);
        Dados.Consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso para o animal: " + animal);
    }

    public void verListaAdocoes() {
        boolean encontrouPetsParaAdocao = false;
        System.out.println("----- Lista de Pets para Adoção -----");
        for(Resgate resgate : Dados.Resgates){
            if(!resgate.getAdotado()){
                System.out.println("Animal: " + resgate.getNome() + " (" + resgate.getEspecie() + ")" );
                encontrouPetsParaAdocao = true;
            }
        }
        if(!encontrouPetsParaAdocao){
            System.out.println("Não há pets disponíveis para adoção no momento.");
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(loginDigitado) && this.getSenha().equals(senhaDigitada);
    }
}