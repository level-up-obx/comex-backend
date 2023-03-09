package br.com.onebox.app.domain;

public class Categoria {
	   
	    private int id = 0;
	    private String nome;
	    private Boolean status;
	    
	    public Categoria(int id, String nome, Boolean status)throws CategoriaInvalidaException
	    {
	        this.id = ++id;
	        setNome(nome);
	        this.status = status;
        }

	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) throws CategoriaInvalidaException {
			if(nome == null || nome.trim().isEmpty()) {
				 throw new CategoriaInvalidaException("O nome da categoria nao pode ser vazia ou nula.");
			}else {
			this.nome = nome;
			}
		}

		public Boolean getStatus() {
			return status;
		}

		public void setStatus(Boolean status) {
			this.status = status;
		}
		
		@Override
		public String toString() {
	        return nome + " (" + id + " - " + (status ? "ATIVA" : "INATIVA") + ")";
		}

		
}
