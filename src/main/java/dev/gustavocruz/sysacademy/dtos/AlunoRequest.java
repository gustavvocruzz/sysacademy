package dev.gustavocruz.sysacademy.dtos;

import dev.gustavocruz.sysacademy.domain.Aluno;

import java.time.LocalDate;

public record AlunoRequest(
        String nome,
        LocalDate dataNascimento,
        String genero,
        String telefone,
        String celular,
        String email,
        String observacao,
        String endereco,
        String complemento,
        String bairro,
        String cidade,
        String estado,
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
