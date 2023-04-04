package br.com.onebox.app.api.pedido;

import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.exception.ProdutoInvalidoException;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.PedidoRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import br.com.onebox.app.service.PedidoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    PedidoService pedidoService;

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriComponentsBuilder) throws ProdutoInvalidoException {
        Pedido pedido = form.toEntity(clienteRepository,produtoRepository);
        pedidoRepository.save(pedido);
        URI uri = uriComponentsBuilder.path("/api/pedidos/{id}").buildAndExpand(form.getClienteId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }
}
