package dev.gustavocruz.sysacademy.dtos;

import dev.gustavocruz.sysacademy.domain.Aluno;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AlunoRequest(
        @NotBlank(message = "O nome é um valor obrigatório")
        @Size(max = 150, message = "O nome deve possuir no máximo 150 caracteres")
        String nome,

        @Past(message = "A data de nascimento deve estar no passado")
        LocalDate dataNascimento,

        @Size(max= 1,message = "O gênero deve possuir apenas 1 caractere( 'M' ou 'F' )")
        String genero,

        @Size(max= 30,message = "O telefone deve possuir no máximo 30 caracteres")
        String telefone,

        @Size(max= 30,message = "O celular deve possuir no máximo 30 caracteres")
        String celular,

        @Email(message = "E-mail inválido")
        @Size(max= 150,message = "O e-mail deve possuir no máximo 150 caracteres")
        String email,

        String observacao,

        @Size(max= 150,message = "O endereço deve possuir no máximo 150 caracteres")
        String endereco,

        @Size(max= 150,message = "O complemento deve possuir no máximo 150 caracteres")
        String complemento,

        @Size(max= 100,message = "O bairro deve possuir no máximo 100 caracteres")
        String bairro,

        @Size(max= 100,message = "A cidade deve possuir no máximo 100 caracteres")
        String cidade,

        @Size(max= 2,message = "O estado deve possuir no máximo 2 caracteres, Exemplo: SP, RJ, MT etc.")
        String estado,

        @Size(max= 25,message = "O cep deve possuir no máximo 25 caracteres")

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
