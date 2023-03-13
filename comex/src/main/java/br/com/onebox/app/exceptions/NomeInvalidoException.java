package br.com.onebox.app.exceptions;

public class NomeInvalidoException extends RuntimeException{

    public NomeInvalidoException(String mensagem){
        super(mensagem);
    }
}
