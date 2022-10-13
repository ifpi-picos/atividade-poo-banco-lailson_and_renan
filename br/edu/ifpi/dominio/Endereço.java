package br.edu.ifpi.dominio;

public class Endereço {
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String uf;
 
    public Endereço(String logradouro, int numero, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public void getEnderecoCompleto() {
        System.out.println();
        System.out.println("Rua: " + getLogradouro());
        System.out.println("Número: " + getNumero());
        System.out.println("Bairro: " + getBairro());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Unidade Federativa: " + getUf());
        System.out.println();
    }
}
