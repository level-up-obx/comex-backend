package app;

public class Categoria {

	private Long id;
	private String nome;
	private Boolean status = Boolean.TRUE;
	
	public Categoria(Long id,
					String nome) {
		setId(id);
		setNome(nome);
	}
	
	
	public Long getId() {
		return this.id;
	}
	
	public Long setId(Long id) {
		return this.id = id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String setNome(String nome) {
		return this.nome = nome;
	}
	
	public Boolean getStatus() {
		return this.status;
	}
	
	public Boolean setStatus(Boolean bol) {
		return this.status = bol;
	}
	
}
