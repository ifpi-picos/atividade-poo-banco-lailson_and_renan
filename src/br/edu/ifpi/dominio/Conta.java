package br.edu.ifpi.dominio;

public class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;
    private Notificacao notificacao;
 
    public Conta(int agencia, int numero, double saldo, Cliente cliente, Notificacao notificacao) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.cliente = cliente;
        this.notificacao = notificacao;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Notificacao getNotificacao() {
        return this.notificacao;
    }

    public boolean depositar(double saldo) {
        this.saldo += saldo;
        return true;
    }

    public double sacar(double saldo) {
        this.saldo -= saldo;
        return saldo;
    }
    
    public void transferir(double saldo, Conta destinatario) {
        this.saldo -= saldo;
        destinatario.saldo += saldo;
    }

    public void enviarNotificacao(String operacao, double valor) {
        this.notificacao.enviarNotificacao(operacao, valor);
    }
}
