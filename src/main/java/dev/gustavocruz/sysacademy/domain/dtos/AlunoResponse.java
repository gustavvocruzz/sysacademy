package dev.gustavocruz.sysacademy.domain.dtos;


import dev.gustavocruz.sysacademy.domain.Aluno;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        String genero,
        String celular,
        String email,
        String cidade,
        String estado,
        LocalDateTime dataCadastro
) {

    public static AlunoResponse fromEntity(Aluno aluno){
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento(),
                aluno.getGenero(),
                aluno.getCelular(),
                aluno.getEmail(),
                aluno.getCidade(),
                aluno.getEstado(),
                aluno.getDataCadastro()
        );
    }
}
