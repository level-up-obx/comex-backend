public class TestaCliente {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1L, "João", "Orlando", "333.333.333-33",
                "+5511958023432", "Rua Getúlio Vargas,", "190,",
                "Sem complemento,", "Tancredo Neves,", "São Paulo,", "São Paulo." + "\n");
        Cliente cliente2 = new Cliente(2L, "Gustavo", "Ferreira", "222.222.222-22",
                "+5511957022431", "Rua Fernão Dias,", "180,",
                "Apartamento 23, bloco 8,", "Ayrton Senna,", "São Paulo,", "São Paulo." + "\n");
        Cliente cliente3 = new Cliente(3L, "Fernando", "Junior", "444.444.444-43",
                "+5511942013432", "Rua 7 de Agosto,", "170,",
                "Sem complemento,", "Liberdade,", "São Paulo,", "São Paulo." + "\n");

        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println(cliente3);
    }

}
