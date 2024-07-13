package com.poo.clinicaveterinaria;

import java.time.LocalDate;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Atendente extends Funcionario {
    private static int ultimaId = 0;
    private int id;
    private String nome;
    static int pontosdesaude;

    public Atendente(String nome, String telefone, String cpf, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
        Dados.Atendentes.add(this);
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

    /*
    public void addRemovetutor() {
        int opçao;
        System.out.println("O que deseja fazer? ");
        System.out.println("1- adicionar um tutor \n 2- remover um tutor\n");
        Scanner sc1 = new Scanner(System.in);
        opçao = sc1.nextInt();
        ArrayList<String> tutores = new ArrayList<String>();

        switch (opçao) {
            case 1:
                String tutoradd;

                Scanner sc = new Scanner(System.in);
                System.out.println("Qual tutor deseja adicionar? ");
                tutoradd = sc.nextLine();
                tutores.add(tutoradd);
                break;
            case 2:
                String tutorremov;

                Scanner sc2 = new Scanner(System.in);
                System.out.println("Qual tutor deseja remover? ");
                tutorremov = sc2.nextLine();
                tutores.remove(tutorremov);
                break;
            default:
                break;
        }
        sc1.close();
    } */

    public Tutor selecionaTutor() {
        Tutor tutorSelecionado = null;
        int idDigitado;
        Scanner sc = new Scanner(System.in);

        while (tutorSelecionado == null) {
            System.out.println("Selecione um tutor: ");
            for (Tutor i : Dados.Tutores) {
                System.out.println("ID: " + i.getId() + " / Nome: " + i.getNome() + " / Telefone: " + i.getTelefone() + " / CPF: " + i.getCpf());
            }

            System.out.print("Digite o ID do tutor cadastrado: ");
            idDigitado = sc.nextInt();

            for (Tutor i : Dados.Tutores) {
                if (i.getId() == idDigitado) {
                    tutorSelecionado = i;
                }
            }

            if (tutorSelecionado == null) {
                System.out.println("Não existe tutor com este ID.");
            } else {
                System.out.println("O tutor " + tutorSelecionado.getNome() + " foi selecionado.");
            }
        }
        return tutorSelecionado;
    }

    public void lancarAtendimento(Pet pet, Atendente atendente){
        Atendimento atendimento = new Atendimento(pet, atendente);
        Dados.Atendimentos.add(atendimento);
        System.out.println("Atendimento lançado para o pet: " + pet.getNome());
    }

    public void addNaListaAdocao(){
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);

        String nomeAnimal;
        LocalDate cadastroDataDaAdocao;
        String especieAnimal;
        String racaAnimal;
        int idadeAnimal;
        double pesoAnimal;
        
        System.out.println("----------------------------");
        System.out.print("Digite o nome do animal: ");
        nomeAnimal = scString.nextLine();
        System.out.println("-----------------------------");
        cadastroDataDaAdocao = LocalDate.now();
        System.out.print("Digite a espécie do animal");
        especieAnimal = scString.nextLine();
        System.out.println("-----------------------------");
        System.out.print("Digite a raça do animal: ");
        racaAnimal = scString.nextLine();
        System.out.println("-----------------------------");
        System.out.print("Digite a idade do animal: ");
        idadeAnimal = scInt.nextInt();
        System.out.println("-----------------------------");
        System.out.print("Digite o peso do animal: ");
        pesoAnimal = scDouble.nextDouble();
        System.out.println("-----------------------------");
        //Adocao.setDataDaAdocao();
        Adocao cadastroAdocao = new Adocao(cadastroDataDaAdocao, nomeAnimal, especieAnimal,racaAnimal, idadeAnimal, pesoAnimal);
        System.out.println("Pet adicionado com sucesso.");
        

    }
    public static void conduzirparaexame(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" DE ACORDO COM A CLÍNICA, NUMA ESCALA DE 1 A 10 QUANTOS PONTOS DE SAÚDE O PET TEM");
        pontosdesaude = sc.nextInt();
        if(pontosdesaude <=4 ){
            System.out.println("LEVE SEU PET PARA A FILA EMERGENCIAL");
            
        }else{System.out.println("LEVE SEU PET PARA A FILA EXAME DE ROTINA");}
       
        

    }


    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(login) && this.getSenha().equals(senha);
    }
}
