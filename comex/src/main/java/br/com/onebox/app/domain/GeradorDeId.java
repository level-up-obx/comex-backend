package br.com.onebox.app.domain;

public class GeradorDeId {
    private static GeradorDeId instancia = new GeradorDeId();
    private Long proximoId = 1L;

    public static Long proximoId(){
        return instancia.proximoId++;
    }
}
