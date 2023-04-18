package br.com.onebox.app.exception;

public class NomeInvalidoException extends RuntimeException{

    public NomeInvalidoException(String mensagem){
        super(mensagem);
    }
}
