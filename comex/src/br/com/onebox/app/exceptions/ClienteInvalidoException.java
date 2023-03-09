package br.com.onebox.app.exceptions;

public class ClienteInvalidoException extends Exception{
    public ClienteInvalidoException(String mensagem){
        super(mensagem);
    }
}
