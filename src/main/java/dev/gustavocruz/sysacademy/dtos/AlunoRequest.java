package dev.gustavocruz.sysacademy.dtos;

import dev.gustavocruz.sysacademy.domain.Aluno;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Dados para criar ou atualizar um aluno")
public record AlunoRequest(
        @NotBlank(message = "O nome é um valor obrigatório")
        @Size(max = 150, message = "O nome deve possuir no máximo 150 caracteres")
        @Schema(description = "Nome completo do aluno", example = "João da Silva", maxLength = 150)
        String nome,

        @Past(message = "A data de nascimento deve estar no passado")
        @Schema(description = "Data de nascimento do aluno", example = "2000-05-15")
        LocalDate dataNascimento,

        @Size(max = 1, message = "O gênero deve possuir apenas 1 caractere( 'M' ou 'F' )")
        @Schema(description = "Gênero do aluno (M ou F)", example = "M", maxLength = 1)
        String genero,

        @Size(max = 30, message = "O telefone deve possuir no máximo 30 caracteres")
        @Schema(description = "Telefone residencial", example = "(11) 3456-7890", maxLength = 30)
        String telefone,

        @Size(max = 30, message = "O celular deve possuir no máximo 30 caracteres")
        @Schema(description = "Número de celular", example = "(11) 98765-4321", maxLength = 30)
        String celular,

        @Email(message = "E-mail inválido")
        @Size(max = 150, message = "O e-mail deve possuir no máximo 150 caracteres")
        @Schema(description = "Endereço de e-mail", example = "joao@example.com", maxLength = 150)
        String email,

        @Schema(description = "Observações adicionais sobre o aluno")
        String observacao,

        @Size(max = 150, message = "O endereço deve possuir no máximo 150 caracteres")
        @Schema(description = "Endereço residencial", example = "Rua Principal, 123", maxLength = 150)
        String endereco,

        @Size(max = 150, message = "O complemento deve possuir no máximo 150 caracteres")
        @Schema(description = "Complemento do endereço", example = "Apto 42", maxLength = 150)
        String complemento,

        @Size(max = 100, message = "O bairro deve possuir no máximo 100 caracteres")
        @Schema(description = "Bairro", example = "Centro", maxLength = 100)
        String bairro,

        @Size(max = 100, message = "A cidade deve possuir no máximo 100 caracteres")
        @Schema(description = "Cidade", example = "São Paulo", maxLength = 100)
        String cidade,

        @Size(max = 2, message = "O estado deve possuir no máximo 2 caracteres, Exemplo: SP, RJ, MT etc.")
        @Schema(description = "Unidade Federativa (UF)", example = "SP", maxLength = 2)
        String estado,

        @Size(max = 25, message = "O cep deve possuir no máximo 25 caracteres")
        @Schema(description = "Código de Endereçamento Postal", example = "01310-100", maxLength = 25)
        String cep) {

    public Aluno toEntity() {
        Aluno aluno = new Aluno();
        preencher(aluno);
        return aluno;
    }

    public void preencher(Aluno aluno) {
        aluno.setNome(nome);
        aluno.setDataNascimento(dataNascimento);
        aluno.setGenero(genero);
        aluno.setTelefone(telefone);
        aluno.setCelular(celular);
        aluno.setEmail(email);
        aluno.setObservacao(observacao);
        aluno.setEndereco(endereco);
        aluno.setComplemento(complemento);
        aluno.setBairro(bairro);
        aluno.setCidade(cidade);
        aluno.setEstado(estado);
        aluno.setCep(cep);
    }
}
