package br.edu.ifpi.dominio;

public class ContaPoupança extends Conta {

    private double rendimento;

    public ContaPoupança(int agencia, int numero, double saldo, String cliente, double rendimento) {
        super(agencia, numero, saldo, cliente);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }
}
