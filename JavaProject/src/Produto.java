public class Produto {

    int id;
    String nome;
    String descricao;
    double precoUnitario = 12.50;
    int quantidadeEstoque = 13;
    String categotia;

    public Produto(double precoUnitario, int quantidadeEstoque){
        double estoque = quantidadeEstoque * precoUnitario;
        this.precoUnitario = precoUnitario;
        this.quantidadeEstoque = quantidadeEstoque;

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

    public String getDescricao() {

        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnitario() {
        double imposto = 0.40;

       return imposto * this.precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {

        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCategotia() {
        return categotia;
    }

    public void setCategotia(String categotia) {
        this.categotia = categotia;
    }
}
