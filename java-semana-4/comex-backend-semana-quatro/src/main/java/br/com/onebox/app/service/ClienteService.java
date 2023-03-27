package br.com.onebox.app.service;

import br.com.onebox.app.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ClienteService {
    private static final String REGEX_CPF = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$";
    private static final Pattern PATTERN_CPF = Pattern.compile(REGEX_CPF);

    private void validarCpf(String cpf) throws Exception {
       try{
           if(cpf == null || cpf.isBlank()) {
               throw new Exception("CPF não informado");
           }
           Matcher matcher = PATTERN_CPF.matcher(cpf);
           if(!matcher.matches()){
               throw new Exception("CPF inválido.");
           }
       } catch(Exception clienteCpfException){
           System.out.println("O erro ocorrido foi: " + clienteCpfException.getMessage());
           throw clienteCpfException;
       }

    }
    public void cadastrar(Cliente novoCliente) throws Exception {
        try {
            validarCpf(novoCliente.getCpf());
//            Aqui vai a lógica de validar a categoria e salvar no banco a categoria cadastrada,
//            caso algo aconteça, cai direto no catch
        } catch(Exception clienteException){
            System.out.println("O erro ocorrido foi: " + clienteException.getMessage());
            throw clienteException;
        }
    }
    public Cliente get(String cpf) throws Exception {
        try {
            validarCpf(cpf);
//          Aqui vai a lógica de busca dos dados do cliente.
        } catch (Exception clienteException){
            System.out.println("O erro ocorrido foi: " + clienteException.getMessage());
        }
        return null;
    }
}
