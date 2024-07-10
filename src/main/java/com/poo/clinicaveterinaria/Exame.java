package com.poo.clinicaveterinaria;

import java.time.LocalDate;


public class Exame {
    private static int ultimaId;
    private int id;
    private int exame;
    private String resultadoExame ;
    private LocalDate data;
    private String animal;
    private String examerealizado;


    

    public Exame() {
        this.id = ++ultimaId;
    }

    public void gerarLaudo(){

        System.out.println("----- Laudo Clínico -----");
        System.out.println("Data: " + data);
        System.out.println("Paciente: " + animal);
        System.out.println("Exame realizado: "+ examerealizado);
        System.out.println("Resultado do exame: " + resultadoExame);
        System.out.println("-------------------------");
    
    }
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getExamerealizado() {
        return examerealizado;
    }

    public void setExamerealizado(String examerealizado) {
        this.examerealizado = examerealizado;
    }

    public String getResultadoExame(){
        return resultadoExame;
    }
    
    public static int getUltimaId() {
        return ultimaId;
    }

    public static void setUltimaId(int ultimaId) {
        Exame.ultimaId = ultimaId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExame() {
        return exame;
    }

    public void setExame(int exame) {
        this.exame = exame;
    }

    

}
