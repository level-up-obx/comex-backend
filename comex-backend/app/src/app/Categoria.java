package app;

public class Categoria {

	Long id;
	String nome;
	String status = "ATIVA";
	
	
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
	
	public String getStatus() {
		return this.status;
	}
	
	public String setStatus(String status) {
		return this.status = status;
	}
	
}
