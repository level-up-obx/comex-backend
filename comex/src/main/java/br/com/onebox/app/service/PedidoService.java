package br.com.onebox.app.service;

import br.com.onebox.app.api.pedido.PedidoDto;
import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDto> getAll() {

        List<Pedido> pedidos = new ArrayList<>();
        pedidoRepository.findAll().forEach(pedidos::add);

        return PedidoDto.converter(pedidos);
    }

    public PedidoDto get(Long id) {
        Optional<Pedido> obj = pedidoRepository.findById(id);
        Pedido pedido = obj.orElse(new Pedido());

        return new PedidoDto(pedido);
    }

    public void cadastrar(Pedido obj) {
        pedidoRepository.save(obj);
    }

    public Optional<Integer> getQuantidadeDePedidos(Optional<List<Pedido>> pedidos) {
        return Optional.of(pedidos.get().size());
    }
}
