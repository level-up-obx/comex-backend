package br.com.onebox.app.api.categoria;

import br.com.onebox.app.domain.Categoria;

import java.util.ArrayList;
import java.util.List;

    public class CategoriaDto {

        private Long id;
        private String nome;
        private Boolean status;

        public CategoriaDto(String nome) {
            this.nome = nome;
        }

        public CategoriaDto(Categoria categoria) {
            if (categoria == null) return;
            this.nome = categoria.getNome();
            this.id = categoria.getId();
            this.status = categoria.getStatus();
        }

        public CategoriaDto(String nome, Long id, Boolean status) {
            this.nome = nome;
            this.id = id;
            this.status = status;
        }

        public static Categoria converter(CategoriaDto categoriaDto) {
            return new Categoria(categoriaDto.getId(), categoriaDto.getNome(), categoriaDto.getStatus());
        }

        public Categoria converter() {
            return new Categoria(id, nome, status);
        }

        public static CategoriaDto converter(Categoria obj) {
            return new CategoriaDto(obj.getNome(), obj.getId(), obj.getStatus());
        }

        public static List<CategoriaDto> converter(List<Categoria> categorias) {
            List<CategoriaDto> categoriasDto = new ArrayList<>();
            categorias.forEach(c -> {
                categoriasDto.add(new CategoriaDto(c.getNome(), c.getId(), c.getStatus()));
            });

            return categoriasDto;
        }

        public String getNome() {
            return this.nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }
    }