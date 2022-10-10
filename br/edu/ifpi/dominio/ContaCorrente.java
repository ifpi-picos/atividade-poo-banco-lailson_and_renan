package br.edu.ifpi.dominio;

public class ContaCorrente {
    private double chequeEspecial;
    private double saldo;

public ContaCorrente(double chequeEspecial, double saldo){
    this.chequeEspecial = chequeEspecial;
    this.saldo = saldo;
}

public double getChequeEspecial() {
    return chequeEspecial;
}

public void setChequeEspecial(double chequeEspecial) {
    this.chequeEspecial = chequeEspecial;
}

public double getSaldo() {
    return saldo;
}

public void setSaldo(double saldo) {
    this.saldo = saldo;
}

public void sacar(Double sacar) {
    if (this.getSaldo() > 0){
        this.setSaldo(this.getSaldo() - sacar);
        System.out.println("Saque efetuado com sucesso");
    }
    else {
        System.out.println("Não foi possivel realizar o saque");
    }
   }

public void depositar(Double depositar) {
    if (this.getSaldo() >= 0){
        this.setSaldo(this.getSaldo() + depositar);
        System.out.println("Deposito efetuado com sucesso");
    }
    else {

        System.out.println("Deposito falhou");
    }
    }
public void transferir(Double transferir) {
    if (this.getSaldo() > 0){
        this.setSaldo(this.getSaldo() - transferir);
        System.out.println("Transferencia efetuada com sucesso");
    }
    else {
        System.out.println("Não foi possivel efetuar a transferencia");
    }
    }

}