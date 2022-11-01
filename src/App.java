import br.edu.ifpi.dominio.*;
//import java.time.LocalDate;
import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        int option1, option2;

        String nome, cpf, data_nascimento, rua; int numero; String bairro, cidade, uf;

        while (true) {
            
            System.out.println("\n             [BANCO MAUT / MENU PRINCIPAL]");
            System.out.println("\nOPÇÔES:");
            System.out.println("\n[1] CRIAR CONTA  [2] ENTRAR NA CONTA  [3] FECHAR SISTEMA");
    
            System.out.print("\nDIGITE: ");
            option1 = scanner.nextInt();

            switch (option1) {
                case 1:
                
                    while (true) {

                        System.out.println("\nCRIAR CONTA:");
                        
                        System.out.println("\n[1] CONTA CORRENTE  [2] CONTA POUPANÇA  [3] VOLTAR");

                        System.out.print("\nDIGITE: ");
                        option2 = scanner.nextInt();
                        
                        if (option2 == 1 || option2 == 2) {
                            
                            System.out.println("\n                  [DADOS DO CLIENTE]");
                            
                            System.out.print("\nNOME: ");
                            nome = scanner.nextLine();
                            nome = scanner.nextLine();
                            
                            System.out.print("\nCPF: ");
                            cpf = scanner.next();
         
                            System.out.print("\nDATA DE NASCIMENTO: ");
                            data_nascimento = scanner.next();
                            System.out.println();
             
                            System.out.print("\nRUA: ");
                            rua = scanner.nextLine();
                            rua = scanner.nextLine();
             
                            System.out.print("\nNÚMERO: ");
                            numero = scanner.nextInt();
             
                            System.out.print("\nBAIRRO: ");
                            bairro = scanner.nextLine();
                            bairro = scanner.nextLine();
             
                            System.out.print("\nCIDADE: ");
                            cidade = scanner.nextLine();
             
                            System.out.print("\nUF: ");
                            uf = scanner.next();

                            if (option2 == 1) {
                                
                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf);
    
                                Cliente cliente = new Cliente(nome, cpf, null, endereco);
    
                                ContaCorrente contaCorrente = new ContaCorrente(0, 0, 0, cliente, null, numero);
                            }

                            if (option2 == 2) {
                                Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf);
    
                                Cliente cliente = new Cliente(nome, cpf, null, endereco);

                                ContaPoupanca contaPoupanca = new ContaPoupanca(0, 0, 0, cliente, null, 0);
                            }

                    }
                    
                    else if (option2 == 3) {
                        break;
                    }
                }
            
                default:
                    break;
            }
        }
    }
}
