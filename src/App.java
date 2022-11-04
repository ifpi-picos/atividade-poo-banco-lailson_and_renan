import br.edu.ifpi.dominio.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ArrayList<ContaCorrente> contaCorrentes = new ArrayList<>();
        ArrayList<ContaPoupanca> contaPoupancas = new ArrayList<>();
        ArrayList<Integer> numAgenciaIntegers = new ArrayList<>();
        ArrayList<Integer> numContaIntegers = new ArrayList<>();
        ArrayList<String> cpfs = new ArrayList<>();

        int option1, option2, option3, option4, resposta, numAgencia, numConta;

        String nome, cpf, dtString, rua; int numero; String bairro, cidade, uf;

        String dtVetor[];

        double saldo = 0, chequeEspecial = 5000, taxaRendimento = 0.10, rendimento = saldo * taxaRendimento, saque, deposito, tranferencia, taxaTranferencia = 0.05;

        LocalDate dataNascimento;

        Notificacao notificacao = null;

        //MENU PRINCIAPL

        while (true) {
            
            System.out.println("\n\t\t[BANCO MAUT / MENU PRINCIPAL]");
            System.out.println("\nOPÇÔES:");
            System.out.println("\n[1] CRIAR CONTA  [2] ENTRAR NA CONTA  [3] FECHAR SISTEMA");
    
            System.out.print("\nDIGITE: ");
            option1 = scanner.nextInt();

            System.out.println();

            //CRIAR CONTA
    
            if (option1 == 1) {
                
                System.out.println("\n\t\t[CRIAR CONTA]");
                System.out.println("\nOPÇÕES:");
                
                System.out.println("\n[1] CONTA CORRENTE  [2] CONTA POUPANÇA");
    
                System.out.print("\nDIGITE: ");
                option2 = scanner.nextInt();
                
                System.out.println("\n\n\t\t[DADOS DO CLIENTE]");
                
                System.out.print("\nNOME: ");
                nome = scanner.nextLine();
                nome = scanner.nextLine();

                System.out.print("\nCPF (XXX.XXX.XXX-XX): ");
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

                System.out.println("\n\n\t\t[DADOS DA CONTA]");
                System.out.println("\nNOTIFICAÇÃO - OPÇÕES:");
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

                numAgencia = random.nextInt(1, 100);

                if (numAgenciaIntegers.contains(numAgencia) == false) {
                    numAgenciaIntegers.add(numAgencia);
                }
                numConta = random.nextInt(10000, 100000);

                while (numContaIntegers.contains(numConta)) {
                    numConta = random.nextInt(10000, 100000);
                }

                numAgenciaIntegers.add(numConta);

                //CRIAÇÃO DA CONTA CORRENTE

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

                //CRIAÇÃO DA CONTA POUPANÇA

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
                
                System.out.println("\nCONTA CRIADA COM SUCESSO!\n");
                                    
            }

            //ACESSAR CONTA

            else if (option1 == 2) {
                
                System.out.println("\n\t\t[ACESSAR CONTA]");
                System.out.println("\nOPÇÕES:");
                
                System.out.println("\n[1] CONTA CORRENTE  [2] CONTA POUPANÇA");
    
                System.out.print("\nDIGITE: ");
                option2 = scanner.nextInt();

                System.out.println("\n\t\t[LOGIN]");

                System.out.print("\nCPF (XXX.XXX.XXX-XX): ");
                cpf = scanner.next();

                while (cpfs.contains(cpf) == false) {

                    System.out.println("\nCPF NÂO CADASTRADO NO SISTEMA!");

                    System.out.print("\nCPF (XXX.XXX.XXX-XX): ");
                    cpf = scanner.next();
                    
                }

                //LOGIN: CONTA CORRENTE

                if (option2 == 1) {
                    for (ContaCorrente dados : contaCorrentes) {
                        if (cpf.equals(dados.getCliente().getCpf())) {

                            while (true) {
                                
                                System.out.println("\n\n\t\t[DADOS DA CONTA]");
                                System.out.println("\nNÚMERO DA AGÊNCIA: " + dados.getnumAgencia());
                                System.out.println("\nNÚMERO DA CONTA: " + dados.getnumConta());
                                System.out.println("\nSALDO: " + dados.getSaldo());
                                System.out.println("\nCHEQUE ESPECIAL: " + dados.getChequeEspecial());
                                System.out.println("\nTIPO DE NOTIFICAÇÃO: " + dados.getNotificacao());
                                System.out.println("\n\n\t\t[DADOS DO CLIENTE]");
                                System.out.println("\nNOME: " + dados.getCliente().getNome());
                                System.out.println("\nCPF: " + dados.getCliente().getCpf());
                                System.out.println("\nDATA DE NASCIMENTO: " + dados.getCliente().getDataNascimento());
                                System.out.println("\n\n\t\t[DADOS DO ENDEREÇO]");
                                System.out.println("\nRUA: " + dados.getCliente().getEndereco().getLogradouro());
                                System.out.println("\nNÚMERO: " + dados.getCliente().getEndereco().getNumero());
                                System.out.println("\nBAIRRO: " + dados.getCliente().getEndereco().getBairro());
                                System.out.println("\nCIDADE: " + dados.getCliente().getEndereco().getCidade());
                                System.out.println("\nUF: " + dados.getCliente().getEndereco().getUf());
    
                                while (true) {
                                    System.out.println("\n\t\t[OPERAÇÕES]");
                                    
                                    System.out.println("\nOPÇÕES:");
                                    System.out.println("\n[1] DEPOSITAR [2] SACAR [3] TRANSFERIR");
    
                                    System.out.print("\nDIGITE: ");
                                    option3 = scanner.nextInt();
    
                                    if (option3 == 1) {
                                        
                                        System.out.println("\n\t\t[DEPÓSITO]");
        
                                        System.out.print("\nVALOR: ");
                                        deposito = scanner.nextDouble();
        
                                        dados.depositar(deposito);
                                        System.out.println("\nREALIZADO COM SUCESSO!");
        
                                        System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                        
                                    }
    
                                    else if (option3 == 2) {
                                        System.out.println("\n\t\t[SAQUE]");
        
                                        System.out.print("\nVALOR: ");
                                        saque = scanner.nextDouble();

                                        while (saque > dados.getSaldo()) {
                                            System.out.println("\nVALOR INFORMADO MAIOR QUE SALDO DA CONTA!");

                                            System.out.print("\nVALOR: ");
                                            saque = scanner.nextDouble();
                                        }

                                        System.out.println("\nAQUI ESTÁ SEU SAQUE: " + dados.sacar(saque));
        
                                        System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                    }
    
                                    else if (option3 == 3) {
                                        System.out.println("\n\t\t[TRANSFERÊNCIA]");

                                        System.out.println("\nOPÇÔES:");
                                        System.out.println("\n[1] CONTA CORRENTE [2] CONTA POUPANÇA");
                                        
                                        System.out.print("\nDIGITE: ");
                                        option4 = scanner.nextInt();

                                        System.out.print("\nNÚMERO DA AGÊNCIA: ");
                                        numAgencia = scanner.nextInt();
                                        System.out.print("\nNÚMERO DA CONTA: ");
                                        numConta = scanner.nextInt();
                                        System.out.print("\nVALOR: ");
                                        tranferencia = scanner.nextInt();

                                        while ((tranferencia + (tranferencia * taxaTranferencia)) > dados.getSaldo()) {
                                            System.out.println("\nVALOR INFORMADO MAIOR QUE SALDO DA CONTA!");

                                            System.out.print("\nVALOR: ");
                                            tranferencia = scanner.nextDouble();
                                        }

                                        if (option4 == 1) {
                                            for (ContaCorrente contaCorrente : contaCorrentes) {
                                                if (numAgencia == contaCorrente.getnumAgencia() && numConta == contaCorrente.getnumConta()) {
                                                    dados.sacar((tranferencia * taxaTranferencia));
                                                    dados.transferir(tranferencia, contaCorrente);
                                                    System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                                }

                                                else {
                                                    System.out.println("\nCONTA NÃO ENCONTRADA!");
                                                }
                                            }
                                        }

                                        else if (option4 == 2) {
                                            for (ContaPoupanca contaPoupanca : contaPoupancas) {
                                                if (numAgencia == contaPoupanca.getnumAgencia() && numConta == contaPoupanca.getnumConta()) {
                                                    dados.sacar((tranferencia * taxaTranferencia));
                                                    dados.transferir(tranferencia, contaPoupanca);
                                                    contaPoupanca.setRendimento((contaPoupanca.getSaldo() * taxaRendimento));
                                                    System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                                }

                                                else {
                                                    System.out.println("\nCONTA NÃO ENCONTRADA!");
                                                }
                                            }
                                        }

                                    }

                                    System.out.println("\n\t\t[ENCERRRAR OPERAÇÕES]");

                                    System.out.println("\nOPÇÕES:");
                                    System.out.println("\n[1] SIM [2] NÃO");

                                    System.out.print("\nDIGITE: ");
                                    resposta = scanner.nextInt();

                                    if (resposta == 1) {
                                        break;
                                    }

                                }

                                System.out.println("\n\t\t[SAIR DA CONTA]");
                                
                                System.out.println("\nOPÇÕES:");
                                System.out.println("\n[1] SIM [2] NÃO");

                                System.out.print("\nDIGITE: ");
                                resposta = scanner.nextInt();

                                if (resposta == 1) {
                                    break;
                                }
                            
                            }
                           
                        }
                    }
                }

                //LOGIN: CONTA POUPANÇA

                else if (option2 == 2) {
                    for (ContaPoupanca dados : contaPoupancas) {
                        if (cpf.equals(dados.getCliente().getCpf())) {

                            while (true) {
                                
                                System.out.println("\n\t\t[DADOS DA CONTA]");
                                System.out.println("\nNÚMERO DA AGÊNCIA: " + dados.getnumAgencia());
                                System.out.println("\nNÚMERO DA CONTA: " + dados.getnumConta());
                                System.out.println("\nSALDO: " + dados.getSaldo());
                                System.out.println("\nRENDIMENTO: " + dados.getRendimento());
                                System.out.println("\nTIPO DE NOTIFICAÇÃO: " + dados.getNotificacao());
                                System.out.println("\n\t\t[DADOS DO CLIENTE]");
                                System.out.println("\nNOME: " + dados.getCliente().getNome());
                                System.out.println("\nCPF: " + dados.getCliente().getCpf());
                                System.out.println("\nDATA DE NASCIMENTO: " + dados.getCliente().getDataNascimento());
                                System.out.println("\n\t\t[DADOS DO ENDEREÇO]");
                                System.out.println("\nRUA: " + dados.getCliente().getEndereco().getLogradouro());
                                System.out.println("\nNÚMERO: " + dados.getCliente().getEndereco().getNumero());
                                System.out.println("\nBAIRRO: " + dados.getCliente().getEndereco().getBairro());
                                System.out.println("\nCIDADE: " + dados.getCliente().getEndereco().getCidade());
                                System.out.println("\nUF: " + dados.getCliente().getEndereco().getUf());

                                while (true) {
                                    System.out.println("\n\t\t[OPERAÇÕES]");
                                    System.out.println("\n\t\t[TRANSFERÊNCIA]");

                                    System.out.println("\nOPÇÔES:");
                                    System.out.println("\n[1] CONTA CORRENTE [2] CONTA POUPANÇA");
                                    
                                    System.out.print("\nDIGITE: ");
                                    option4 = scanner.nextInt();

                                    System.out.print("\nNÚMERO DA AGÊNCIA: ");
                                    numAgencia = scanner.nextInt();
                                    System.out.print("\nNÚMERO DA CONTA: ");
                                    numConta = scanner.nextInt();
                                    System.out.print("\nVALOR: ");
                                    tranferencia = scanner.nextInt();

                                    while ((tranferencia + (tranferencia * taxaTranferencia)) > dados.getSaldo()) {
                                        System.out.println("\nVALOR INFORMADO MAIOR QUE SALDO DA CONTA!");

                                        System.out.print("\nVALOR: ");
                                        tranferencia = scanner.nextDouble();
                                    }

                                    if (option4 == 1) {
                                        for (ContaCorrente contaCorrente : contaCorrentes) {
                                            if (numAgencia == contaCorrente.getnumAgencia() && numConta == contaCorrente.getnumConta()) {
                                                dados.sacar((tranferencia * taxaTranferencia));
                                                dados.transferir(tranferencia, contaCorrente);
                                                dados.setRendimento((dados.getRendimento() * taxaRendimento));
                                                System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                                System.out.println("\nRENDIMENT0: " + dados.getRendimento());
                                            }

                                            else {
                                                System.out.println("\nCONTA NÃO ENCONTRADA!");
                                            }
                                        }
                                    }

                                    else if (option4 == 2) {
                                        for (ContaPoupanca contaPoupanca : contaPoupancas) {
                                            if (numAgencia == contaPoupanca.getnumAgencia() && numConta == contaPoupanca.getnumConta()) {
                                                dados.sacar((tranferencia * taxaTranferencia));
                                                dados.transferir(tranferencia, contaPoupanca);
                                                contaPoupanca.setRendimento((contaPoupanca.getSaldo() * taxaRendimento));
                                                System.out.println("\nSALDO DA CONTA: " + dados.getSaldo());
                                                System.out.println("\nRENDIMENT0: " + dados.getRendimento());
                                            }

                                            else {
                                                System.out.println("\nCONTA NÃO ENCONTRADA!");
                                            }
                                        }
                                    }

                                    System.out.println("\n\t\t[ENCERRRAR OPERAÇÕES]");
    
                                    System.out.println("\nOPÇÕES:");
                                    System.out.println("\n[1] SIM [2] NÃO");
    
                                    System.out.print("\nDIGITE: ");
                                    resposta = scanner.nextInt();
    
                                    if (resposta == 1) {
                                        break;
                                    }

                                }

                                System.out.println("\n\t\t[SAIR DA CONTA]");
                                
                                System.out.println("\nOPÇÕES:");
                                System.out.println("\n[1] SIM [2] NÃO");

                                System.out.print("\nDIGITE: ");
                                resposta = scanner.nextInt();

                                if (resposta == 1) {
                                    break;
                                }

                            }

                        }

                    }

                }

                System.out.println();
            }

            else if (option1 == 3) {
                System.out.println("\nSISTEMA FINALIZADO\n");
                break;
            }
        }

        scanner.close();
    }
}
