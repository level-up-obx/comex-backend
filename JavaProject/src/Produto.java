public class Produto {

    int id;
    String nome;
    String descricao;
    double precoUnitario ;
    int quantidadeEstoque ;
    String categotia;



    public void produtoid(int meuid){
        this.id = this.id + meuid++;

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

       return (double) (imposto * precoUnitario);
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public double getQuantidadeEstoque() {

        return (double) (quantidadeEstoque * precoUnitario) ;
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
