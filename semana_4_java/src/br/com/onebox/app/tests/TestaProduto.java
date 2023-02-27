package br.com.onebox.app.tests;

import br.com.onebox.app.domain.Categoria;
import br.com.onebox.app.domain.Produto;

import java.math.BigDecimal;

    public class TestaProduto {
        public static void main(String[] args) {
            Categoria categoria1 = new Categoria(0, "INFORMÁTICA", Boolean.TRUE);
            Categoria categoria2 = new Categoria(1, "MÓVEIS", Boolean.FALSE);
            Categoria categoria3 = new Categoria(2, "LIVROS", Boolean.TRUE);


            Produto produto1 = new Produto(1, "Notebook Samsung", "Informática", new BigDecimal("3523.00"), 1, categoria1);
            Produto produto2 = new Produto(2, "Clean Architecture", "Livros", new BigDecimal("102.90"), 2, categoria2);
            Produto produto3 = new Produto(3, "Monitor Dell 27", "Informática", new BigDecimal("1889.00"), 3,categoria3 );

            System.out.println("--------- PRODUTO - 1 ----------");
            System.out.println("Nome: " + produto1.getNome());
            System.out.println("br.com.onebox.app.domain.Categoria: " + produto1.getCategoria());
            System.out.println("Preço Unitário: R$" + produto1.getPrecoUnitario());
            System.out.println("Quantidade em br.com.onebox.app.domain.Estoque: " + produto1.getQuantidadeEstoque());
            System.out.println("Valor Total em br.com.onebox.app.domain.Estoque: R$" + produto1.calculaValorTotalEstoque());
            System.out.println("Imposto: R$" + produto1.calculaImposto(produto1.getPrecoUnitario()));


           System.out.println("--------- br.com.onebox.app.domain.Produto - 2 CLEAN ARCHITECTURE ----------");
            System.out.println("Nome: " + produto2.getNome());
            System.out.println("br.com.onebox.app.domain.Categoria: " + produto2.getCategoria());
            System.out.println("Preço Unitário: R$" + produto2.getPrecoUnitario());
            System.out.println("Quantidade em br.com.onebox.app.domain.Estoque: " + produto2.getQuantidadeEstoque());
            System.out.println("Valor Total em br.com.onebox.app.domain.Estoque: R$" + produto2.calculaValorTotalEstoque());
            System.out.println("Imposto: R$" + produto2.calculaImposto(produto2.getPrecoUnitario()));


            System.out.println("--------- br.com.onebox.app.domain.Produto - 3 MONITOR DELL ----------");
            System.out.println("Nome: " + produto3.getNome());
            System.out.println("br.com.onebox.app.domain.Categoria: " + produto3.getCategoria());
            System.out.println("Preço Unitário: R$" + produto3.getPrecoUnitario());
            System.out.println("Quantidade em br.com.onebox.app.domain.Estoque: " + produto3.getQuantidadeEstoque());
            System.out.println("Valor Total em br.com.onebox.app.domain.Estoque: R$" + produto3.calculaValorTotalEstoque());
            System.out.println("Imposto: R$" + produto3.calculaImposto(produto3.getPrecoUnitario()));
        }
    }

