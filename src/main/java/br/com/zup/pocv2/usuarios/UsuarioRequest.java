package br.com.zup.pocv2.usuarios;

import br.com.zup.poc.avro.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;

public class UsuarioRequest {

    @NotBlank
    @JsonProperty
    private String nome;

    @NotBlank
    @CPF
    @JsonProperty
    private String cpf;

    @NotBlank
    @JsonProperty
    private String endereco;

    public UsuarioRequest(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Usuario toModel() {
        return Usuario
                .newBuilder()
                .setNome(this.nome)
                .setCpf(this.cpf)
                .setEndereco(this.endereco)
                .build();
    }
}
