package onebox_comex.entity;

import onebox_comex.enums.StatusCategoriaEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Size(min = 2, message = "O nome da categoria deve ter pelo menos 2 caracteres")
    private String nome;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusCategoriaEnum status = StatusCategoriaEnum.ATIVA;
    @OneToMany(mappedBy = "categoria")
    private Produto produto;
    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria(String nome, StatusCategoriaEnum status) {
        this.nome = nome;
        this.status = status;
    }

}