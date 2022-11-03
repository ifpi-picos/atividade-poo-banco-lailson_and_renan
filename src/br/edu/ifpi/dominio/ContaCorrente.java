package br.edu.ifpi.dominio;

public class ContaCorrente extends Conta {

    private double chequeEspecial;

    public ContaCorrente(int numAgencia, int numConta, double saldo, Cliente cliente, Notificacao notificacao, double chequeEspecial) {
        super(numAgencia, numConta, saldo, cliente, notificacao);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double setChequeEspecial(double chequeEspecial) {
        return this.chequeEspecial -= chequeEspecial; 
    }

    @Override
    public String toString() {
        return "[" + this.getnumAgencia() + ", " 
                   + this.getnumConta() + ", "
                   + this.getSaldo() + ", "
                   + this.getCliente() + ", "
                   + this.getNotificacao() + ", "
                   + this.getChequeEspecial() + "]";
    }

}
