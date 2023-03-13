package br.com.onebox.app.exceptions;

public class PrecoInvalidoException extends RuntimeException{

    public PrecoInvalidoException(String mensagem){
        super(mensagem);
    }
}
