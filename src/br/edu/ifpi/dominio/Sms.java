package br.edu.ifpi.dominio;

public class Sms implements Notificacao {
    public void enviarNotificacao(String operecao, double valor) {
        
    }

    @Override
    public String toString() {
        return "SMS";
    }
}
