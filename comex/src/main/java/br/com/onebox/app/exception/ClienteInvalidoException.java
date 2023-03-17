package br.com.onebox.app.exception;

public class ClienteInvalidoException extends Exception{
    public ClienteInvalidoException(String mensagem){
        super(mensagem);
    }
}
