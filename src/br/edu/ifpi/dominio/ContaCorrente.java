package br.edu.ifpi.dominio;

public class ContaCorrente extends Conta {

    private double chequeEspecial;

    public ContaCorrente(int agencia, int numero, double saldo, String cliente, Notificacao notificacao, double chequeEspecial) {
        super(agencia, numero, saldo, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    } 
}
