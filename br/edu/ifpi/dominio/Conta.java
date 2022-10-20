package br.edu.ifpi.dominio;

public class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private String cliente;
 
    public Conta(int agencia, int numero, double saldo, String cliente) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCliente() {
        return cliente;
    }

    public boolean setDepositar(double saldo) {
        this.saldo += saldo;
        return true;
    }

    public double setSacar(double saldo) {
        this.saldo -= saldo;
        return saldo;
    }
    
    public void setTransferir(double saldo, Conta destinatario) {
        this.saldo -= saldo;
        destinatario.saldo += saldo;
    }
}