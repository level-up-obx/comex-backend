package br.com.comex.entidades;

public class Cliente{

	private static Long idCliente = 1L;

	private Long id;
	private String primeiroNome;
	private String sobrenome;
	private String cpf;
	private String telefone;
	private String rua;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;


	public Cliente(String primeiroNome,
					String sobrenome,String cpf,
					String telefone,String rua,
					String numero,String complemento,
					String bairro,String cidade,
					String estado
			) {
		this.setPrimeiroNome(primeiroNome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
		this.setTelefone(telefone);
		this.setRua(rua);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setBairro(bairro);
		this.setCidade(cidade);
		this.setEstado(estado);

		this.setId(Cliente.idCliente++);

	}

	public String enderecoCompleto() {
		return this.getRua() + ", " + this.getNumero() + " - "
				+ this.getComplemento() + " " + this.getBairro() + " "
				+ this.getCidade() + "/" + this.getEstado() ;
	}



	public String nomeCompleto() {
		return this.getPrimeiroNome() + " " + this.getSobrenome();
	}


	public Long getId() {
		return id;
	}


	private void setId(Long id) {
		this.id = id;
	}


	public String getPrimeiroNome() {
		return primeiroNome;
	}


	private void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	private void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}


	public String getCpf() {
		return cpf;
	}


	private void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getRua() {
		return rua;
	}


	private void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	private void setNumero(String número) {
		this.numero = número;
	}


	public String getComplemento() {
		return complemento;
	}


	private void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	private void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	private void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	private void setEstado(String estado) {
		this.estado = estado;
	}


}
