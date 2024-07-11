package com.poo.clinicaveterinaria;

public abstract class Pessoa {
    private static int ultimaId = 0;
    private int id;
    protected String nome;
    protected String telefone;
    protected String cpf;
    protected Endereco endereco;
    public String loginDigitado;
    public String senhaDigitada;
    private String login;
    private String senha;

    public Pessoa( String nome, String telefone, String cpf, String login, String senha) {
        this.id = ++ultimaId;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getLoginDigitado() {
        return loginDigitado;
    }

    public void setLoginDigitado(String loginDigitado) {
        this.loginDigitado = loginDigitado;
    }

    public String getSenhaDigitada() {
        return senhaDigitada;
    }

    public void setSenhaDigitada(String senhaDigitada) {
        this.senhaDigitada = senhaDigitada;
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

    public void criarLogin(){
        System.out.print("Crie seu login: ");
        setLogin(login);
    }

    public void criarSenha(){
        System.out.print("Crie sua senha: ");
        setSenha(senha);
    }

    public void digitarLogin(){
        System.out.print("Digite o seu login: ");
        setLoginDigitado(loginDigitado);
    }

    public void digitarSenha(){
        System.out.print("Digite sua senha: ");
        setSenhaDigitada(senhaDigitada);
    }

    // Método abstrato para autenticação
    public abstract boolean autentica(String login, String senha);
}
