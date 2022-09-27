package br.edu.ifpi.dominio;
import javax.swing.JOptionPane;

public class Conta {
    private int agencia ;
    private int nmuConta;
    private Double saldo;
    private Cliente cliente;

public Conta(int nmuConta,  Cliente cliente) {
    this.cliente = cliente;
    this.saldo = 0.0;
    this.nmuConta = nmuConta;
    this.agencia = 2211;
}

public int getAgencia() {
    return agencia;
}

public void setAgencia(int agencia) {
    this.agencia = agencia;
}

public int getNmuConta() {
    return nmuConta;
}

public void setNmuConta(int nmuConta) {
    this.nmuConta = nmuConta;
}

public Double getSaldo() {
    return saldo;
}

public void setSaldo(Double saldo) {
    this.saldo = saldo;
}

public Cliente getCliente() {
    return cliente;
}

public void setCliente(Cliente cliente) {
    this.cliente = cliente;
}
public String toString() {
    return "\nAgencia: " + this.getAgencia() +
           "\nNumero da Conta: " + this.getNmuConta() +
           "\nSaldo: " + this.getSaldo() +
           "\nCliente: " + this.getCliente();
}

public void sacar(Double sacar) {
    if (this.getSaldo() > 0){

        this.setSaldo(this.getSaldo() - sacar);
    }
    else {
        JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE","SAQUE",JOptionPane.ERROR_MESSAGE);
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