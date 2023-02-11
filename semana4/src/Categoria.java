
public class Categoria {
	   
	    private int id;
	    private String nome;
	    private Boolean status;
	    
	    public Categoria(int id, String nome, Boolean status) 
	    {
	        this.id = id;
	        this.nome = nome;
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

		public void setNome(String nome) {
			this.nome = nome;
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
