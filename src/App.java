import br.edu.ifpi.dominio.*;
//import java.time.LocalDate;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
        ArrayList<ContaPoupanca> contaPoupancas = new ArrayList<>();
        ArrayList<Integer> numAgenciaIntegers = new ArrayList<>();
        ArrayList<Integer> numContaIntegers = new ArrayList<>();
        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> cpfs = new ArrayList<>();
        ArrayList<String> datasNascimento = new ArrayList<>();

        int option1, option2, option3, numAgencia, numConta;

        String nome, cpf, dtString, rua; int numero; String bairro, cidade, uf;

        String dtVetor[];

        double saldo = 0, chequeEspecial = 5000, taxaRendimento = 0.10, rendimento = 0;

        LocalDate dataNascimento;

        Notificacao notificacao = null;

        while (true) {
            
            System.out.println("\n             [BANCO MAUT / MENU PRINCIPAL]");
            System.out.println("\nOPÇÔES");
            System.out.println("\n[1] CRIAR CONTA  [2] ENTRAR NA CONTA  [3] FECHAR SISTEMA");
    
            System.out.print("\nDIGITE: ");
            option1 = scanner.nextInt();
    
            if (option1 == 1) {
                
                System.out.println();
                System.out.println("\nTIPO DA CONTA");
                
                System.out.println("\n[1] CONTA CORRENTE  [2] CONTA POUPANÇA");
    
                System.out.print("\nDIGITE: ");
                option2 = scanner.nextInt();
                
                if (option2 == 1 || option2 == 2) {
                    
                    System.out.println("\n                   [DADOS DO CLIENTE]");
                    
                    System.out.print("\nNOME: ");
                    nome = scanner.nextLine();
                    nome = scanner.nextLine();
    
                    System.out.print("\nCPF: ");
                    cpf = scanner.next();
    
                    if (option2 == 1) {
                        for (ContaCorrente iterable_element : contaCorrentes) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {
                                
                                System.out.println("\nCPF JÁ CADASTRADO NO SISTEMA!");
    
                                System.out.print("\nCPF: ");
                                cpf = scanner.next();
                            }
                        }
                    }
    
                    else if (option2 == 2) {
                        for (ContaPoupanca iterable_element : contaPoupancas) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {
                                
                                System.out.println("\nCPF JÁ CADASTRADO NO SISTEMA!");
    
                                System.out.print("\nCPF: ");
                                cpf = scanner.next();
                            }
                        }
                    }
    
                    
                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: ");
                    dtString = scanner.next();
                    System.out.println();
                    
                    dtVetor = dtString.split("/");
                    
                    dataNascimento = LocalDate.of(Integer.parseInt(dtVetor[2]), 
                    Integer.parseInt(dtVetor[1]), 
                    Integer.parseInt(dtVetor[0]));
                    
                    if (cpfs.contains(cpf) && option2 == 1) {
                        for (ContaPoupanca iterable_element : contaPoupancas) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {

                                while (nome.equals(iterable_element.getCliente().getNome()) == false && dataNascimento.equals(iterable_element.getCliente().getDataNascimento()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Nome " + iterable_element.getCliente().getNome() + " e a Data de Nascimento " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.print("\nNOME: ");
                                    nome = scanner.nextLine();
                                    nome = scanner.nextLine();
                                    System.out.println("\nCPF: " + cpf);
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: ");
                                    dtString = scanner.next();
                                    System.out.println();
                                    
                                    dtVetor = dtString.split("/");
                                    
                                    dataNascimento = LocalDate.of(Integer.parseInt(dtVetor[2]), 
                                    Integer.parseInt(dtVetor[1]), 
                                    Integer.parseInt(dtVetor[0]));
                                }

                                while (nome.equals(iterable_element.getCliente().getNome()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Nome " + iterable_element.getCliente().getNome());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.print("\nNOME: ");
                                    nome = scanner.nextLine();
                                    nome = scanner.nextLine();
                                    System.out.println("\nCPF: " + cpf);
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println();
                                }
                                    
                                while (dataNascimento.equals(iterable_element.getCliente().getDataNascimento()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Data de Nascimento " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.println("\nNOME: " + iterable_element.getCliente().getNome());

                                    System.out.println("\nCPF: " + cpf);
                                    
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: ");
                                    dtString = scanner.next();
                                    System.out.println();
                                    
                                    dtVetor = dtString.split("/");
                                    
                                    dataNascimento = LocalDate.of(Integer.parseInt(dtVetor[2]), 
                                    Integer.parseInt(dtVetor[1]), 
                                    Integer.parseInt(dtVetor[0]));
                                }                                
                            }
                        }
                    }

                    else if (cpfs.contains(cpf) && option2 == 2) {
                        for (ContaCorrente iterable_element : contaCorrentes) {
                            if (cpf.equals(iterable_element.getCliente().getCpf())) {

                                while (nome.equals(iterable_element.getCliente().getNome()) == false && dataNascimento.equals(iterable_element.getCliente().getDataNascimento()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Nome " + iterable_element.getCliente().getNome() + " e a Data de Nascimento " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.print("\nNOME: ");
                                    nome = scanner.nextLine();
                                    nome = scanner.nextLine();
                                    System.out.println("\nCPF: " + cpf);
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: ");
                                    dtString = scanner.next();
                                    System.out.println();
                                    
                                    dtVetor = dtString.split("/");
                                    
                                    dataNascimento = LocalDate.of(Integer.parseInt(dtVetor[2]), 
                                    Integer.parseInt(dtVetor[1]), 
                                    Integer.parseInt(dtVetor[0]));
                                }

                                while (nome.equals(iterable_element.getCliente().getNome()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Nome " + iterable_element.getCliente().getNome());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.print("\nNOME: ");
                                    nome = scanner.nextLine();
                                    nome = scanner.nextLine();
                                    System.out.println("\nCPF: " + cpf);
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println();
                                }
                                    
                                while (dataNascimento.equals(iterable_element.getCliente().getDataNascimento()) == false) {
                                    System.out.println("\nO CPF " + cpf + " está Cadastrado com Data de Nascimento " + iterable_element.getCliente().getDataNascimento());
                                    System.out.println("\nPor favor, insira seus dados corretamente");
                                    
                                    System.out.println("\nNOME: " + iterable_element.getCliente().getNome());

                                    System.out.println("\nCPF: " + cpf);
                                    
                                    System.out.print("\nDATA DE NASCIMENTO [DD/MM/AAAA]: ");
                                    dtString = scanner.next();
                                    System.out.println();
                                    
                                    dtVetor = dtString.split("/");
                                    
                                    dataNascimento = LocalDate.of(Integer.parseInt(dtVetor[2]), 
                                    Integer.parseInt(dtVetor[1]), 
                                    Integer.parseInt(dtVetor[0]));
                                }                               
                            }
                        }
                    }

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
    
                    System.out.println("\n                    [DADOS DA CONTA]");
                    System.out.println("\nNOTIFICAÇÃO");
                    System.out.println("\n[1] EMAIL  [2] SMS");
    
                    System.out.print("\nDIGITE: ");
                    option3 = scanner.nextInt();
    
                    if (option3 == 1) {
                        Notificacao email = new Email();
                        notificacao = email;
                    }
    
                    else if (option3 == 2) {
                        Notificacao sms = new Sms();
                        notificacao = sms;
                    }

                    cpfs.add(cpf);
                    nomes.add(nome);
                    datasNascimento.add(dtString);
    
                    numAgencia = random.nextInt(1, 100);
    
                    if (numAgenciaIntegers.contains(numAgencia) == false) {
                        numAgenciaIntegers.add(numAgencia);
                    }
                    numConta = random.nextInt(10000, 100000);
    
                    while (numContaIntegers.contains(numConta)) {
                        numConta = random.nextInt(10000, 100000);
                    }
    
                    numAgenciaIntegers.add(numConta);
    
                    if (option2 == 1) {
                        
                        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf);
    
                        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
    
                        ContaCorrente contaCorrente = new ContaCorrente(numAgencia, 
                                                                        numConta, 
                                                                        saldo, 
                                                                        cliente, 
                                                                        notificacao, 
                                                                        chequeEspecial);

                        contaCorrentes.add(contaCorrente);
                    }
    
                    if (option2 == 2) {
                        Endereco endereco = new Endereco(rua, numero, bairro, cidade, uf);
    
                        Cliente cliente = new Cliente(nome, cpf, dataNascimento, endereco);
    
                        ContaPoupanca contaPoupanca = new ContaPoupanca(numAgencia, 
                                                                        numConta, 
                                                                        saldo, 
                                                                        cliente, 
                                                                        notificacao, 
                                                                        rendimento);
                        
                        contaPoupancas.add(contaPoupanca);
                    }               
                }       
            }

            else if (option1 == 2) {
                
            }

            else if (option1 == 3) {
                System.out.println("\nSISTEMA FINALIZADO\n");
                break;
            }
        }
    }
}
