package br.com.onebox.app.service;

import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.domain.Produto;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public void cadastrar(Produto novoproduto) throws ProdutoInvalidoException {
        try {
            if (novoproduto.equals(null) || novoproduto.getQuantidadeEmEstoque() <= 0) {
                throw new ProdutoInvalidoException("Produto inválido ou quantidade em estoque nula");
            }
            produtoRepository.save(novoproduto);
            System.out.println("Produto cadastrado com sucesso!");
        } catch (ProdutoInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    public ProdutoDto buscarPorId(Long id) {
        return new ProdutoDto(produtoRepository.findById(id));
    }
}
