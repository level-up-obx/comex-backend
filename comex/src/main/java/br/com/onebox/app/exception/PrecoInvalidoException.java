package br.com.onebox.app.exception;

public class PrecoInvalidoException extends RuntimeException{

    public PrecoInvalidoException(String mensagem){
        super(mensagem);
    }
}
