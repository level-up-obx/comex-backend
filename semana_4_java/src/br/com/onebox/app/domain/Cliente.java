package br.com.onebox.app.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "primeiroNome_clientes", nullable = false)
    private String primeiroNome;

    @Column(name = "sobrenome_clientes", nullable = false)
    private String sobrenome;

    @Column(name = "cpf_clientes", nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(name = "telefone_clientes", nullable = false)
    private String telefone;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Pedido> pedidos;

    @Embedded
    public Endereco endereco;

    public Cliente(int id,
                   String primeiroNome,
                   String sobrenome,
                   String cpf,
                   String telefone
                   ) {
        this.id = ++id;
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;


    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String mostraNomeCompleto() {
        return "NOME COMPLETO: " + primeiroNome + " " + sobrenome;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "\n" + "Id:" + id +
                "\n" + " PrimeiroNome='" + primeiroNome + '\'' +
                "\n" + " Sobrenome:'" + sobrenome + '\'' +
                "\n" + " Cpf:'" + cpf + '\'' +
                "\n" + " Telefone:'" + telefone + '\'' +
                "\n" + " Endereço:" + endereco.toString();
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public TipoDescontoPedidoEnum getTipoDescontoPedido() {
        if (this.getPedidos().size() >= 5) {
            return TipoDescontoPedidoEnum.FIDELIDADE;
        } else {
            return TipoDescontoPedidoEnum.NENHUM;
        }
    }

}
