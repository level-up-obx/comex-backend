package br.com.onebox.app.domain;

import br.com.onebox.app.tests.CategoriaValidacaoNomeException;

import javax.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private static int id;
    private String nome;
    boolean status = true;

    public Categoria(String nome, boolean status) throws CategoriaValidacaoNomeException {
        if (nome == null || nome.equals("")) {

            throw new CategoriaValidacaoNomeException();
        } else {
            this.nome = nome;
            this.status = status;
        }
    }

        public static int getId () {
            return id;
        }

        public static void setId ( int id){
            Categoria.id = id;
        }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome) throws CategoriaValidacaoNomeException {
            if (nome == null || nome.equals("")) {
                throw new CategoriaValidacaoNomeException();
            } else {
                this.nome = nome;
            }

        }


        public boolean isStatus () {
            return status;
        }

        public void setStatus ( boolean status){
            this.status = status;
        }

        @Override
        public String toString () {
            return "br.com.onebox.app.domain.Categoria{" +
                    "id=" + ++id +
                    ", nome='" + nome + '\'' +
                    ", status=" + status +
                    '}';
        }


        public int categoriaid () {

            id = ++id;
            return ++id;

        }

    }



