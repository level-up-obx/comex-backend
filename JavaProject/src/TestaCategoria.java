import javax.swing.plaf.synth.SynthOptionPaneUI;

public class TestaCategoria {

    public static void main(String[] args) {
        Categoria categoria1 = new Categoria();
        categoria1.categoriaid(1);
        System.out.print(categoria1.id + " - " );

        Categoria categoria2 = new Categoria();
        categoria2.nome = "INFORMÁTICA";
        System.out.print(categoria2.nome + " - ");

        Categoria categoria3 = new Categoria();
        categoria3.ATIVA(true);
        if (categoria3.status == false)
        System.out.println("ATIVO");


        Categoria categoria4 = new Categoria();
        categoria1.categoriaid(1);
        System.out.print(categoria1.id + " - " );

        Categoria categoria5 = new Categoria();
        categoria5.nome = "MÓVEIS";
        System.out.print(categoria5.nome + " - ");

        Categoria categoria6 = new Categoria();
        boolean inativo = categoria6.ATIVA(true);
        if(categoria6.status == false){
            System.out.println("INATIVO");
        }

        Categoria categoria7 = new Categoria();
        categoria1.categoriaid(1);
        System.out.print(categoria1.id + " - " );

        Categoria categoria8 = new Categoria();
        categoria8.nome = "MÓVEIS";
        System.out.print(categoria8.nome + " - ");

        Categoria categoria9 = new Categoria();
        categoria9.ATIVA(false);

        if(categoria9.status == false){
            System.out.println("ATIVO");
        }








    }

}

