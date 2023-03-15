package br.com.onebox.app.exceptions;

public class ProdutoInvalidoException extends Exception{
    public ProdutoInvalidoException(String mensagem){
        super(mensagem);
    }
}
