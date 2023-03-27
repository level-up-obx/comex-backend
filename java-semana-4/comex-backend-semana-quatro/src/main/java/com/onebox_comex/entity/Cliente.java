package com.onebox_comex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String primeiroNome;
    @Column(nullable = false, length = 50)
    private String sobrenome;
    @Column(nullable = false, length = 11)
    private String cpf;
    @Column(nullable = false, length = 15)
    private String telefone;
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedido;
    @Embedded
    private Endereco endereco;

}
