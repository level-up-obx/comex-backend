package br.com.onebox.app.test;

import br.com.onebox.app.domain.Cliente;

public class TestaCliente {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1L, "Marcelo", "Almeida", "455.655.288-62", "(11) 9 9999-1111", "Rua Coroados", "599","","Centro", "São Paulo", "SP");
        Cliente cliente2 = new Cliente(2L, "João", "Santos", "715.133.124-12", "(11) 9 9889-2511", "Rua 17C", "S/N"," Bl 18 Lt 41","Centro", "Goiânia", "GO");
        Cliente cliente3 = new Cliente(3L, "Daniela", "Goncalves", "124.715.238-88", "(11) 9 8741-4754", "Rua Tenente Negrão", "140","","Itaim Bibi", "São Paulo", "SP");

        System.out.println(cliente1.toStringComEnderecoConcatenado());
        System.out.println(cliente2.toStringComEnderecoConcatenado());
        System.out.println(cliente3.toStringComEnderecoConcatenado());
    }
}
