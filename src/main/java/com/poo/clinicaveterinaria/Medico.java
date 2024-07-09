package com.projeto.veterinaria;

public class Medico extends Funcionarios {
    private int id;
    private String especialidade;
    private String crmv;

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
