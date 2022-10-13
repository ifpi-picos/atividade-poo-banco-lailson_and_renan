package br.edu.ifpi.dominio;
import java.time.LocalDate;

public class Cliente {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private Endereço endereço;

    public Cliente(String nome, String cpf, LocalDate dataNascimento, Endereço endereço) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereço = endereço;
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

    public Endereço getEndereço() {
        return endereço;
    }
}
