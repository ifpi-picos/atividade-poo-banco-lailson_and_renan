package br.edu.ifpi.dominio;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereco endereco;

    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereco endereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereço;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return "[" + this.getCpf() + ", " 
                   + this.getNome() + ", " 
                   + this.getDataNascimento() + ", " 
                   + this.getEndereco() + "]";
    }
}
