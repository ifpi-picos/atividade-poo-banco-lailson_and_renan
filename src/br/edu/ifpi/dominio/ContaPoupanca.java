package br.edu.ifpi.dominio;

public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca(int agencia, int numero, double saldo, Cliente cliente, Notificacao notificacao, double rendimento) {
        super(agencia, numero, saldo, cliente, notificacao);
        this.rendimento = rendimento;
    }

    public double getRendimento() {
        return rendimento;
    }

    public double setRendimento(double rendimento) {
        return this.rendimento = rendimento;
    }

    @Override
    public String toString() {
        return "[" + this.getnumAgencia() + ", " 
                   + this.getnumConta() + ", "
                   + this.getSaldo() + ", "
                   + this.getCliente() + ", "
                   + this.getNotificacao() + ", "
                   + this.getRendimento() + "]";
    }
}
