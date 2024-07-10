package com.poo.clinicaveterinaria;

import java.util.ArrayList;
import java.util.Scanner;

public class Atendente extends Funcionarios {
    private static int ultimaId = 0;
    private int id;
    private String nome;

    public Atendente(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
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

    public void addRemovpet() {
        int opçao;
        System.out.println("oque deseja fazer? ");
        System.out.println("1- adicionar um pet \n 2- remover um pet\n");
        Scanner sc1 = new Scanner(System.in);
        opçao = sc1.nextInt();
        ArrayList<String> animais = new ArrayList<String>();

        switch (opçao) {
            case 1:
                String animaladd;

                Scanner sc = new Scanner(System.in);
                System.out.println("Qual animal deseja adicionar? ");
                animaladd = sc.nextLine();
                animais.add(animaladd);
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
    }
}
