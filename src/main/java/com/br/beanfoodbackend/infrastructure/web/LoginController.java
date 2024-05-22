package com.br.beanfoodbackend.infrastructure.web;

import com.br.beanfoodbackend.application.ports.in.LoginUseCase;
import com.br.beanfoodbackend.domain.dto.ClienteDTO;
import com.br.beanfoodbackend.domain.dto.ContatoDTO;
import com.br.beanfoodbackend.domain.dto.EnderecoDTO;
import com.br.beanfoodbackend.domain.dto.LoginDTO;
import com.br.beanfoodbackend.domain.model.Cliente;
import com.br.beanfoodbackend.domain.model.Contato;
import com.br.beanfoodbackend.domain.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    private final LoginUseCase loginUseCase;

    @Autowired
    public LoginController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Cliente cliente = loginUseCase.login(loginDTO.getEmail(), loginDTO.getSenha());

        if (Objects.nonNull(cliente)) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.badRequest().body("Email inválido ou senha inválida");
        }
    }

     @PostMapping("/registrar")
     public ResponseEntity<String> register(@RequestBody ClienteDTO cliente) {

         Cliente registered = loginUseCase.registrar(convertToEntity(cliente));

         if (registered != null) {
             return ResponseEntity.ok("Registrado com sucesso");
         } else {
             return ResponseEntity.badRequest().body("Erro ao registrar cliente");
         }
    }

    private Cliente convertToEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(clienteDTO.getSenha());
        cliente.setNome(clienteDTO.getNome());
        cliente.setSobrenome(clienteDTO.getSobrenome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setSexo(clienteDTO.getSexo());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setEnderecos(clienteDTO.getEnderecos().stream().map(this::convertToEndereco).toList());
        cliente.setContatos(clienteDTO.getContatos().stream().map(this::convertToContato).toList());
        return cliente;
    }

    private Endereco convertToEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoDTO.getCep());
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setComplemento(enderecoDTO.getCompleto());
        return endereco;
    }

    private Contato convertToContato(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        contato.setTelefone(contatoDTO.getTelefone());
        contato.setCelular(contatoDTO.getCelular());
        return contato;
    }
}
