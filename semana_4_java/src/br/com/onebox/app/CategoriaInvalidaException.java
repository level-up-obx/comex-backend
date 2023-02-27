package br.com.onebox.app;

public class CategoriaInvalidaException extends RuntimeException {
   public CategoriaInvalidaException(String msg) {
       super(msg);
   }
}
