import javax.sound.midi.Soundbank;

public class TestaProduto {

    public static void main(String[] args) {

        Produto produto1 = new Produto("Notebook Sansung", "Tela 15''", 3523.0, 1, "INFORMATICA");

        System.out.println(produto1);


        Produto produto2 = new Produto("Clean Arquiteture", "Arquitetura Básica", 102.9, 2, "LIVROS");
        System.out.println(produto2);

        Produto produto3 = new Produto("Monitor Dell", "Tela HD 27'' ", 1889.00, 1, "INFORMÁTICA");
        System.out.println(produto3);

    }

}
