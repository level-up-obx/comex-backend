package br.com.onebox.app.exception;

public class ProdutoInvalidoException extends Exception{
    public ProdutoInvalidoException(String mensagem){
        super(mensagem);
    }
}
