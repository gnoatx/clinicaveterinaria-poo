package com.poo.clinicaveterinaria;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

@SuppressWarnings("resource")
public class Medico extends Funcionario {
    private static int ultimaId = 0;
    protected String nome;
    private int id;
    private String especialidade;
    private String crmv;
    private String medicamento;
    private Pet pet;
    private Tutor tutor;

    public Medico(String nome, String telefone, String cpf, String crmv, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
        this.id = ++ultimaId;
        this.nome = nome;
        this.telefone = telefone;
        this.crmv = crmv;
        Dados.Medicos.add(this);
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

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
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

    public void lancarExame() {
        Scanner sc = new Scanner(System.in);

        // Listar pets para escolher qual pet terá exame lançado
        System.out.println("Lista de Pets:");
        for (Pet pet : Dados.Pets) {
            System.out.println(pet.getId() + ". " + pet.getNome() + " (" + pet.getEspecie() + ")");
        }

        // Escolher o pet pelo Id
        System.out.println("Digite o Id do Pet para lançar o exame: ");
        int petId = sc.nextInt();
        sc.nextLine();

        // Encontra o pet pelo Id
        Pet petSelecionado = null;
        for (Pet pet : Dados.Pets) {
            if (pet.getId() == petId) {
                petSelecionado = pet;
                break;
            }
        }

        if (petSelecionado == null) {
            System.out.println("Pet não encontrado com o Id fornecido.");
            return;
        }

        // Preencher informações do exame
        System.out.println("Tipo de exame: ");
        String tipoExame = sc.nextLine();

        System.out.println("Resultado do exame: ");
        String resultadoExame = sc.nextLine();

        // Criar o objeto exame
        Exame exame = new Exame(petSelecionado.getNome(), tipoExame, resultadoExame, LocalDate.now());
        Dados.Exames.add(exame);
    }

    public void lancarProntuario() {
       Scanner scInt = new Scanner(System.in);
       Scanner scString = new Scanner(System.in);
       
       String motivo = null;
       
       System.out.println("Lista de Pets:");
       for (Pet pet : Dados.Pets) {
           System.out.println(pet.getId() + ". " + pet.getNome() + " (" + pet.getEspecie() + ") - Tutor: " + pet.getTutor().getNome());
       }

        // Escolher o pet pelo Id
        System.out.println("Digite o Id do Pet para lançar o prontuário: ");
        int petId = scInt.nextInt();
        // Encontra o pet pelo Id
        Pet petSelecionado = null;
        for (Pet pet : Dados.Pets) {
            if (pet.getId() == petId) {
                petSelecionado = pet;
                break;
            }
        }
        if (petSelecionado == null) {
            System.out.println("Não existe um pet com este ID.");
            return;
        }
        
        System.out.print("Medicamentos: ");
        String medicamento = scString.nextLine();
        System.out.println("--------------");
        System.out.print("Observações: ");
        String observacoes = scString.nextLine();
        System.out.println("--------------");
        
        Prontuario prontuario = new Prontuario(LocalDateTime.now(), this, petSelecionado.getTutor(), petSelecionado, medicamento, observacoes);
        Dados.Prontuarios.add(prontuario);
        System.out.println(prontuario.exibirProntuario());
    }
    

    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(loginDigitado) && this.getSenha().equals(senhaDigitada);
    }
}