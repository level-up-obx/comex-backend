public class Estoque extends Produto{

    int capacidade = 1000;
    int ocupacao;
    double montante = getQuantidadeEstoque() * getPrecoUnitario();

    public double RegistraEntrada(Produto decr){
        int decrementa = decr.getQuantidadeEstoque(){
            return capacidade - decrementa;
        }
    }
    public double RegistraEntrada(Produto acres){
        int incrementa = acres.getQuantidadeEstoque(){
            return capacidade + incrementa;
        }
    }

    


    public boolean getCapacidade() {
        return capacidade <= 1000;
    }

    public int getOcupacao() {
        return ocupacao = (int) getQuantidadeEstoque();
    }

    public double getMontante() {
        return montante ;
    }


}
