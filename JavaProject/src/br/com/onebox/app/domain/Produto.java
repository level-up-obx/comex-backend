package br.com.onebox.app.domain;

import br.com.onebox.app.interfaces.ValidacaoPrecoUnitarioException;

public class Produto implements ValidacaoPrecoUnitarioException {

    static int id;
    private String nome;
    private String descricao;
    private double precoUnitario;
    private int quantidadeEstoque;
    private String categotia;




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

    public double getPrecoUnitario()  {

        double imposto = 0.40;


        return (double) (imposto * precoUnitario);
    }

    public void setPrecoUnitario(double precoUnitario) throws Exception {
        erroPreco();
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

       public double getValorEstoque() {

        return (double) (quantidadeEstoque * precoUnitario);
    }

    public void setQuantidadeEstoque(int quantidadeEstoque)  {
        this.quantidadeEstoque = quantidadeEstoque;

    }

    public String getCategotia() {
        return categotia;

    }

    public void setCategotia(String categotia)  {
        this.categotia = categotia;

    }

    public int getprodutoid() {
        return id;
    }

    public Produto(int id, String nome, String descricao, double precoUnitario, int quantidadeEstoque, String categotia ) throws Exception {

        this.id = id;
        this.nome = nome ;
        erroPreco();
        this.descricao = descricao;
        erroPreco();
        this.precoUnitario = precoUnitario;
        erroPreco();
        this.quantidadeEstoque = quantidadeEstoque;
        erroPreco();
        this.categotia = categotia;
        erroPreco();

    }

    @Override
    public String toString() {
                 return                 "id=" + id +", nome ='" + nome + '\'' +
                    ", descricao ='" + descricao + '\'' +
                    ", precoUnitario =" + precoUnitario +
                    ", quantidadeEstoque =" + quantidadeEstoque +
                    ", categotia ='" + categotia + '\'' +"\n"+ "Valor total em estoque = " + getQuantidadeEstoque() +"\n" +"Valor do imposto = "
                    +getPrecoUnitario() ;

    }


    @Override
    public void erroPreco() throws Exception {
        if(this.precoUnitario == 0)  throw new Exception("Não pode ser 0");
        if(this.quantidadeEstoque == 0)  new Exception("Não pode ser nulo");
        if(this.descricao == null)  new Exception("Não pode ser nulo");
        if(this.categotia == null)  new Exception("Não pode ser nulo");
    }
}


