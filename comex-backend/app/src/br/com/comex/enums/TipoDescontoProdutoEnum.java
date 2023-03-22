package br.com.comex.enums;

public enum TipoDescontoProdutoEnum {

	
	QUANTIDADE("QUANTIDADE"),
	PROMOCAO("PROMOCAO"),
	NENHUM("NENHUM");
	
	private String descricao;
	
	TipoDescontoProdutoEnum(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
