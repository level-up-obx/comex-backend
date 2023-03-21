package br.com.comex.entidades;
import br.com.comex.exceptions.CampoObrigatorioException;

public class Categoria {

	private Long id;
	private String nome;
	private Boolean status = Boolean.TRUE;

	public Categoria(Long id,
					String nome) throws CampoObrigatorioException{
		setId(id);
		setNome(nome);
	}


	public Long getId() {
		return this.id;
	}

	private Long setId(Long id) {
		return this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	private String setNome(String nome) throws CampoObrigatorioException{
		if( nome == null || nome.isEmpty()) {
			throw new CampoObrigatorioException("Categoria precisa ter um nome");
//			throw new CampoObrigatorioRuntimeException("Categoria precisa ter um nome");
		}
		return this.nome = nome;
	}

	public Boolean getStatus() {
		return this.status;
	}

	public Boolean setStatus(Boolean bol) {
		return this.status = bol;
	}

}
