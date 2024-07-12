package com.poo.clinicaveterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SpringBootApplication
public class ClinicaveterinariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaveterinariaApplication.class, args);
        Scanner sc = new Scanner(System.in);
        limpa();
		
		Atendente joaoX = new Atendente("João X", "(24) 98543-5122", "136.252.411-02","Joaox", "24321");

		Medico lucasCarvalho = new Medico("Lucas Carvalho", "(24) 93157-7625", "105.963.402-16", "02716", "lulu","2216");

		Tutor victorGnoato = new Tutor("Victor Gnoato","(47) 97654-3198","125.226.584-19","vitin","8901");
		
        /*Resgate jorgeResgate = new Resgate("Jorge", "Cachorro", 10, 30.00, "Paranaguaçu", LocalDate.of(2024,07,10), "Coitado");*/

        boolean sair = false;
        while(!sair){
            System.out.println("\n----- Menu Principal -----");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Acessar como Médico");
            System.out.println("2. Acessar como Atendente");
            System.out.println("3. Acessar como Tutor");
            System.out.println("4. Sair");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    acessarComoMedico(lucasCarvalho);
                    break;

                case 2:
                    acessarComoAtendente(joaoX);
                    break;

                case 3:
                    acessarComoTutor(victorGnoato);
                    break;

                case 4:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
        sc.close(); 
    }

    private static void acessarComoMedico(Medico lucasCarvalho){
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n----- Menu Medico -----");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Lançar Exame");
            System.out.println("2. Lançar Receita");
            System.out.println("3. Voltar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    lucasCarvalho.lancarExame();
                    break;

                case 2:
                    System.out.println("Digite o medicamento: ");
                    String medicamento = sc.nextLine();
                    lucasCarvalho.lancarReceita(medicamento);
                    break;

                case 3:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
        sc.close();
    }

    private static void acessarComoAtendente(Atendente joaoX){
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n----- Menu Atendente -----");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Pet");
            System.out.println("2. Remover Pet");
            System.out.println("3. Voltar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    joaoX.adicionarPet();
                    break;

                case 2:
                    sair = true;
                    break;

                /*case 2:
                    joaoX.removerPet();
                    break;*/

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
        sc.close();
    }

    private static void acessarComoTutor(Tutor victorGnoato){
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n----- Menu Tutor -----");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Ver Prontuário de um Pet");
            System.out.println("2. Agendar Consulta");
            System.out.println("3. Ver Lista de Adoções");
            System.out.println("4. Voltar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do pet: ");
                    String nomePet = sc.nextLine();
                    Pet pet = buscarPetPorNome(nomePet);
                    if(pet != null){
                        victorGnoato.verProntuario(pet);
                    } else {
                        System.out.println("Pet não encontrado");
                    }
                    break;
                    
                case 2:
                    System.out.println("Digite a data e hora da consulta (yyyy-MM-dd HH:mm): ");
                    String dataHoraStr = sc.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    System.out.println("Digite o nome do veterinário: ");
                    String veterinario = sc.nextLine();

                    System.out.println("Digite o nome do animal: ");
                    String animal = sc.nextLine();

                    System.out.println("Digite o motivo da consulta: ");
                    String motivo = sc.nextLine();

                    System.out.println("Observações: ");
                    String observacoes = sc.nextLine();

                    victorGnoato.agendarConsulta(dataHora, veterinario, animal, motivo, observacoes);
                    break;

                case 3:
                    victorGnoato.verListaAdocoes();
                    break;

                case 4:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
        sc.close();
    }

    private static Pet buscarPetPorNome(String nomePet){
        for(Pet pet : Dados.Pets){
            if(pet.getNome().equalsIgnoreCase(nomePet)){
                return pet;
            }
        }
        return null;
    }
    
    static void limpa() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (System.getProperty("os.name").contains("Linux")
                    || System.getProperty("os.name").contains("Mac")) {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            } else {
                System.out.println("Este comando não funciona no seu sistema operacional.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
