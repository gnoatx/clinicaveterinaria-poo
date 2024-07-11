package com.poo.clinicaveterinaria;

public abstract class Funcionario extends Pessoa {
    private static int ultimaId = 0;
    private int id;

    public Funcionario(String nome, String telefone, String cpf, String login, String senha) {
        super(nome, telefone, cpf, login, senha);
    }

    public int getUltimaId() {
        return ultimaId;
    }

    public int getId() {
        return id;
    }
    @Override
    public boolean autentica(String login, String senha) {
        return this.getLogin().equals(loginDigitado) && this.getSenha().equals(senhaDigitada);
    }
}
