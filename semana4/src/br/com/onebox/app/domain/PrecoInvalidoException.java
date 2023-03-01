package br.com.onebox.app.domain;

public class PrecoInvalidoException extends RuntimeException{

	public PrecoInvalidoException(String msg)
	{
		super(msg);
	}
}
