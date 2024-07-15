package com.poo.clinicaveterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SuppressWarnings("resource")
@SpringBootApplication
public class ClinicaveterinariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaveterinariaApplication.class, args);
        Scanner sc = new Scanner(System.in);
        limpa();
		
		Atendente joaoX = new Atendente("João X", "(24) 98543-5122", "136.252.411-02","Joaox", "24321");

		Medico lucasCarvalho = new Medico("Lucas Carvalho", "(24) 93157-7625", "105.963.402-16", "02716", "lulu","2216");

		Tutor victorGnoato = new Tutor("Victor Gnoato","(47) 97654-3198","125.226.584-19","vitin","8901");
		
        Pet billy = new Pet("Billy", "Cachorro", "Vira-lata", 7, 15, victorGnoato);

        Resgate jorgeResgate = new Resgate("Jorge", "Cachorro", "Vira-Lata", 10, 30.00, "Paranaguaçu", LocalDate.of(2024,07,10), "Coitado");

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
                    if (lucasCarvalho instanceof Medico ) {
                        Medico lucasCarvalhoCast = (Medico) lucasCarvalho;
                        acessarComoMedico(lucasCarvalhoCast);
                    } else {
                        System.out.println("Apenas Médicos podem acessar es");
                    }
                    break;

                case 2:
                    if(joaoX instanceof Atendente ){
                        Atendente joaoXCast = (Atendente)joaoX;
                        acessarComoAtendente(joaoXCast);
                    }else{
                        System.out.println("Apenas Atendentes podem acessar essa área");
                        }
                    break;

                case 3:
                    if(victorGnoato instanceof Tutor ){
                        Tutor victorGnoatoCast = (Tutor)victorGnoato;
                        acessarComoTutor(victorGnoatoCast);                  
                    }else{
                        System.out.println("Apenas tutores podem acessar essa área");
                        }
                   break;
                   

                case 4:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
    }

    private static void acessarComoMedico(Medico lucasCarvalho){
        Scanner sc = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n----- Menu Medico -----");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Lançar Exame");
            System.out.println("2. Lançar Prontuário");
            System.out.println("3. Voltar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    lucasCarvalho.lancarExame();
                    break;

                case 2:
                    lucasCarvalho.lancarProntuario();
                    break;

                case 3:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
    }

    private static void acessarComoAtendente(Atendente joaoX){
        Scanner sc = new Scanner(System.in);
        Tutor tutorSelecionado = null;
        boolean sair = false;
        
        while (!sair) {
            System.out.println("\n----- Menu Atendente -----");
            tutorSelecionado = joaoX.selecionaTutor();

            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar Pet");
            System.out.println("2. Remover Pet");
            System.out.println("3. Editar Pet");
            System.out.println("4. Conduzir para fila");
            System.out.println("5. Voltar");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    tutorSelecionado.adicionarPet();
                    break;

                case 2:
                    tutorSelecionado.removerPet();
                    break;

                case 3:
                    tutorSelecionado.editarPet();
                    break;

                case 4:
                    Atendente.conduzirparaexame();
                    break;

                case 5:
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida. Escolha uma opção válida.");
                    break;
            }
        }
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
                    victorGnoato.listaPets();
                    System.out.println("\nDigite o ID do pet: ");
                    int idPet = sc.nextInt();
                    Pet petSelecionado = null;
                    
                    for (Pet i : Dados.Pets) {
                        if (i.getId() == idPet) {
                            petSelecionado = i;
                        }
                    }
                    if (petSelecionado == null) {
                        System.out.println("Não existe pet com esta ID.");
                        return;
                    } else {
                        victorGnoato.verProntuario(petSelecionado);
                    }
                    break;
                    
                case 2:
                    System.out.println("Digite a data e hora da consulta (yyyy-MM-dd HH:mm): ");
                    String dataHoraStr = sc.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

                    System.out.println("Digite o nome do animal: ");
                    String animal = sc.nextLine();

                    System.out.println("Digite o motivo da consulta: ");
                    String motivo = sc.nextLine();

                    System.out.println("Observações: ");
                    String observacoes = sc.nextLine();
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