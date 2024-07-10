package com.poo.clinicaveterinaria;

public abstract class Pessoa {
    private static int ultimaId = 0;
    private int id;
    protected String nome;
    protected String telefone;
    protected String cpf;
    private String login;
    private String senha;

    public Pessoa(String nome, String telefone, String cpf) {
        this.id = ++ultimaId;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
    }


    public int getUltimaId() {
        return ultimaId;
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


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getCpf() {
        return cpf;
    }


    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }
}
