package com.poo.clinicaveterinaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Atendente extends Funcionario {
    private static int ultimaId = 0;
    private int id;
    private String nome;
    private Tutor tutorSelecionado; //Essa variável é só pra métodos

    public Atendente(String nome, String telefone, String cpf, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
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

  /*   public void addRemovpet() {
        int opçao;
        System.out.println("oque deseja fazer? ");
        System.out.println("1- adicionar um pet \n 2- remover um pet\n");
        Scanner sc1 = new Scanner(System.in);
        opçao = sc1.nextInt();
        
Pets.add(animaladd);
                break;
            case 2:
                String animalremov;

                Scanner sc2 = new Scanner(System.in);
                System.out.println("Qual animal deseja remover? ");
                animalremov = sc2.nextLine();
                animais.remove(animalremov);
                break;
            default:
                break;
        }
        sc1.close();
    }

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

    public void selecionaTutor() {
        tutorSelecionado = null;
        String cpfDigitado;
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o CPF do tutor cadastrado: ");
        cpfDigitado = sc.nextLine();

        for (int i = 0; i < Dados.Tutores.size(); i++) {
            if (cpfDigitado.equals(Dados.Tutores.get(i).getCpf())) {
                tutorSelecionado = Dados.Tutores.get(i);
            }
        }

        if (tutorSelecionado == null) {
            System.out.println("Não foi encontrado um tutor com este CPF.");
        } else {
            System.out.println("O tutor " + tutorSelecionado.getNome() + " foi selecionado.");
        }
    }

    public void listaPetsTutor() {
        int contadorPets = 0;
        System.out.println("Tutor selecionado: " + tutorSelecionado.getNome());
        for (int i = 0; i < Dados.Pets.size(); i++) {
            if (Dados.Pets.get(i).getTutor() == tutorSelecionado) {
                System.out.println("ID: " + Dados.Pets.get(i).getId() + " / Nome: " + Dados.Pets.get(i).getNome() + " / Espécie: " + Dados.Pets.get(i).getEspecie() + " / Raça: " + Dados.Pets.get(i).getRaca() + " / Idade: " + Dados.Pets.get(i).getIdade() + " / Peso: " + Dados.Pets.get(i).getPeso());
                contadorPets++;
            }
        }
        if (contadorPets == 0) {
            System.out.println("Este tutor não tem nenhum pet cadastrado.");
        }
    }

    public void adicionarPet() {
        String nomeDigitado, especieDigitada, racaDigitada;
        int idadeDigitada;
        double pesoDigitado;
        char confirma;
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);

        System.out.print("Nome: ");
        nomeDigitado = scString.nextLine();
        System.out.print("Espécie: ");
        especieDigitada = scString.nextLine();
        System.out.print("Raça: ");
        racaDigitada = scString.nextLine();
        System.out.print("Idade: ");
        idadeDigitada = scInt.nextInt();
        System.out.print("Peso: ");
        pesoDigitado = scDouble.nextDouble();

        System.out.println("\nDeseja adicionar este pet a(o) tutor(a) " + tutorSelecionado.getNome() + "? (s/n)");
        confirma = scString.nextLine().charAt(0);
        if (confirma == 's' || confirma == 'S') {
            Pet pet = new Pet(nomeDigitado, especieDigitada, racaDigitada, idadeDigitada, pesoDigitado, tutorSelecionado);
            System.out.println("Pet adicionado com sucesso.");
        } else {
            System.out.println("Cancelado.");
        }
    }

    public void removerPet() {
        Scanner sc = new Scanner(System.in);

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
        String especieAnimal;
        String racaAnimal;
        int idadeAnimal;
        double pesoAnimal;
        
        System.out.println("----------------------------");
        System.out.print("Digite o nome do animal: ");
        nomeAnimal = scString.nextLine();
        System.out.println("-----------------------------");
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

    }

    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(login) && this.getSenha().equals(senha);
    }
}
