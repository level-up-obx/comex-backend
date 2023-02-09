public class Produto {
    private Long id;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private Integer quantidadeEmEstoque;
    private Categoria categoria;

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //Métodos adicionais
    public String calculaValorTotalEmEstoque() {
        double valorTotalEmEstoque = this.quantidadeEmEstoque * this.precoUnitario;
        return "O valor total em estoque é: " + valorTotalEmEstoque;
    }

    public String calculaImposto() {
        double imposto = this.precoUnitario * .4;
        return "O valor do imposto é: " + Math.round(imposto * 100.0) / 100.0;
    }


    //Método toString
    @Override
    public String toString() {
        return  "id = " + id +
                ", nome = '" + nome + '\'' +
                ", descricao = '" + descricao + '\'' +
                ", precoUnitario = " + precoUnitario +
                ", quantidadeEmEstoque = " + quantidadeEmEstoque;
    }

    public String toStringSemDescricao() {
        return  "id: " + id +
                ", nome: '" + nome + '\'' +
                ", precoUnitario: " + precoUnitario +
                ", quantidadeEmEstoque: " + quantidadeEmEstoque;
    }

    //Construtor com parâmetros
    public Produto(Long id, String nome, String descricao, double precoUnitario, Integer quantidadeEmEstoque, Categoria categoria) {
        this.id = GeradorDeId.proximoId();
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.categoria = categoria;
    }

    //Construtor vazio
    public Produto(){
        this.id = GeradorDeId.proximoId();
    }
}
