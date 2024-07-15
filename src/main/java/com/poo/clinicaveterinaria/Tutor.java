package com.poo.clinicaveterinaria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Tutor extends Pessoa {
    private static int ultimaId = 0;
    private int id;
    private Pet pet;

    public Tutor(String nome, String telefone, String cpf, String login, String senha, Pet pet) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
        this.pet = pet;
        Dados.Tutores.add(this);
    }

    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void verProntuario(Pet pet) {
        List<Prontuario> prontuarios = Dados.Prontuarios;
        System.out.println("----- Prontuários dos Pets -----");
        // for (Prontuario prontuario : prontuarios) {
        //     if (prontuario.getPet().equals(pet) && prontuario.getPet().getTutor().equals(this)) {
                // prontuario.exibirProntuario();
            //     return;
            // }
        //}
        
        System.out.println("Prontuário não encontrado para o pet " + pet.getNome());
    }

    public void agendarConsulta(LocalDateTime dataHora, Medico medico, String nome, String animal, String motivo, String observacoes) {
        Consulta consulta = new Consulta (dataHora, medico, this, pet, motivo, observacoes);
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

    public void listaPets() {
        int contadorPets = 0;
        System.out.println("Tutor selecionado: " + this.getNome());
        for (Pet i : Dados.Pets) {
            if (i.getTutor() == this) {
                System.out.println("ID: " + i.getId() + " / Nome: " + i.getNome() + " / Espécie: " + i.getEspecie() + " / Raça: " + i.getRaca() + " / Idade: " + i.getIdade() + " / Peso: " + i.getPeso());
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

        System.out.println("\nDeseja adicionar este pet a(o) tutor(a) " + this.getNome() + "? (s/n)");
        confirma = scString.nextLine().charAt(0);
        if (confirma == 's' || confirma == 'S') {
            Pet pet = new Pet(nomeDigitado, especieDigitada, racaDigitada, idadeDigitada, pesoDigitado);
            System.out.println("Pet adicionado com sucesso.");
        } else {
            System.out.println("Cancelado.");
        }
    }

    public void removerPet() {
        Scanner scInt = new Scanner(System.in);
        Scanner scString = new Scanner(System.in);
        int idPet;
        char confirma;
        Pet petSelecionado = null;
        this.listaPets();

        System.out.print("Digite a ID do pet a ser removido: ");
        idPet = scInt.nextInt();
        for (Pet i : Dados.Pets) {
            if (i.getId() == idPet) {
                petSelecionado = i;
            }
        }
        if (petSelecionado == null) {
            System.out.println("Não existe pet com esta ID.");
        } else {
            System.out.println("Deseja remover o pet " + petSelecionado.getNome() + " do tutor " + this.getNome() + "? (s/n)");
            confirma = scString.nextLine().charAt(0);
            if (confirma == 's' || confirma == 'S') {
                Dados.Pets.remove(petSelecionado);
                System.out.println("Pet removido com sucesso.");
            } else {
                System.out.println("Cancelado.");
            }
        }
    }

    public void editarPet() {
        String nomeDigitado, especieDigitada, racaDigitada;
        int idadeDigitada, opcao;
        double pesoDigitado;
        char confirma;
        Pet petSelecionado = null;
        Scanner scString = new Scanner(System.in);
        Scanner scInt = new Scanner(System.in);
        Scanner scDouble = new Scanner(System.in);

        this.listaPets();
        System.out.print("Digite a ID do pet que deseja editar: ");
        opcao = scInt.nextInt();
        for (Pet i : Dados.Pets) {
            if (i.getId() == opcao) {
                petSelecionado = i;
            }
        }
        if (petSelecionado == null) {
            System.out.println("Não existe pet com esta ID.");
        } else {
            System.out.println("\n1. Nome: " + petSelecionado.getNome());
            System.out.println("2. Espécie: " + petSelecionado.getEspecie());
            System.out.println("3. Raça: " + petSelecionado.getRaca());
            System.out.println("4. Idade: " + petSelecionado.getIdade());
            System.out.println("5. Peso: " + petSelecionado.getPeso());
            System.out.print("\nDigite a opção que deseja editar: ");
            opcao = scInt.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    nomeDigitado = scString.nextLine();
                    System.out.println(petSelecionado.getNome() + " ==> " + nomeDigitado + "? (s/n)");
                    confirma = scString.nextLine().charAt(0);
                    if (confirma == 's' || confirma == 'S') {
                        petSelecionado.setNome(nomeDigitado);
                        System.out.println("Alteração feita com sucesso.");
                    } else {
                        System.out.println("Cancelado.");
                    }
                    break;
                case 2:
                    System.out.print("Digite a nova espécie: ");
                    especieDigitada = scString.nextLine();
                    System.out.println(petSelecionado.getEspecie() + " ==> " + especieDigitada + "? (s/n)");
                    confirma = scString.nextLine().charAt(0);
                    if (confirma == 's' || confirma == 'S') {
                        petSelecionado.setEspecie(especieDigitada);
                        System.out.println("Alteração feita com sucesso.");
                    } else {
                        System.out.println("Cancelado.");
                    }
                    break;
                case 3:
                    System.out.print("Digite a nova raça: ");
                    racaDigitada = scString.nextLine();
                    System.out.println(petSelecionado.getRaca() + " ==> " + racaDigitada + "? (s/n)");
                    confirma = scString.nextLine().charAt(0);
                    if (confirma == 's' || confirma == 'S') {
                        petSelecionado.setRaca(racaDigitada);
                        System.out.println("Alteração feita com sucesso.");
                    } else {
                        System.out.println("Cancelado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite a nova idade: ");
                    idadeDigitada = scInt.nextInt();
                    System.out.println(petSelecionado.getIdade() + " ==> " + idadeDigitada + "? (s/n)");
                    confirma = scString.nextLine().charAt(0);
                    if (confirma == 's' || confirma == 'S') {
                        petSelecionado.setIdade(idadeDigitada);
                        System.out.println("Alteração feita com sucesso.");
                    } else {
                        System.out.println("Cancelado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o novo peso: ");
                    pesoDigitado = scDouble.nextDouble();
                    System.out.println(petSelecionado.getPeso() + " ==> " + pesoDigitado + "? (s/n)");
                    confirma = scString.nextLine().charAt(0);
                    if (confirma == 's' || confirma == 'S') {
                        petSelecionado.setPeso(pesoDigitado);
                        System.out.println("Alteração feita com sucesso.");
                    } else {
                        System.out.println("Cancelado.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }

    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(loginDigitado) && this.getSenha().equals(senhaDigitada);
    }
}