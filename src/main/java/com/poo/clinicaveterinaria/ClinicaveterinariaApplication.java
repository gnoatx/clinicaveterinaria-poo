package com.poo.clinicaveterinaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.Scanner;

@SpringBootApplication
public class ClinicaveterinariaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaveterinariaApplication.class, args);
        limpa();
		

		Atendente joaoX = new Atendente("João X", "(24) 98543-5122", "136.252.411-02","Joaox", "24321");

		Medico lucasCarvalho = new Medico("Lucas Carvalho", "(24) 93157-7625", "105.963.402-16", "02716", "lulu","2216");

		Tutor victorGnoato = new Tutor("Victor Gnoato","(47) 97654-3198","125.226.584-19","vitin","8901");
		
		
        Resgate viralata = new Resgate("Jorge", "Cachorro", 10, 30.00, "Paranaguaçu", LocalDate.of(2024,07,10), "Coitado");
        Tutor.verListaAdocoes();



	
    }
    public void menuDeAcesso(int opcao){
		System.out.println("-----------------------------------");
		System.out.println("============ Bem Vindo ============");
		System.out.println("-----------------------------------");
		System.out.println("1 - Acesso de funcionários");
		System.out.println("2 - Acesso de clientes");
		System.out.println("---------------------------");
		System.out.print("Digite o número de acesso correspondente: ");
		Scanner sc1 = new Scanner(System.in);
		opcao = sc1.nextInt();

		switch(opcao){
			case 1:
				//Pessoa.digitarLogin();
			
		}

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
