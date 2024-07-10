package com.poo.clinicaveterinaria;

public class Medico extends Funcionarios {
    private static int ultimaId = 0;
    private int id;
    private String especialidade;
    private String crmv;
   
    

    public Medico(String nome, String telefone, String cpf) {
        super(nome, telefone, cpf);
        this.id = ++ultimaId;
        this.nome = nome;
        this.telefone = telefone;
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
}
