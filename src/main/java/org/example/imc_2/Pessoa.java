package org.example.imc_2;

public class Pessoa {
    private int id;
    private String nome;
    private double altura;
    private double peso;
    private double imc;

    public Pessoa(int id, String nome, double altura, double peso) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        calcularImc();
    }

    private void calcularImc() {
        if (altura > 0) {
            this.imc = peso / (altura * altura);
        }
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getAltura() { return altura; }
    public double getPeso() { return peso; }
    public double getImc() { return imc; }
    public void setImc(double imc) { this.imc = imc; }
}