package dev.gustavocruz.sysacademy.dtos;


import dev.gustavocruz.sysacademy.domain.Aluno;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "Resposta com os dados do aluno")
public record AlunoResponse(
        @Schema(description = "ID único do aluno", example = "1")
        Long id,

        @Schema(description = "Nome completo do aluno", example = "João da Silva")
        String nome,

        @Schema(description = "Data de nascimento do aluno", example = "2000-05-15")
        LocalDate dataNascimento,

        @Schema(description = "Gênero do aluno", example = "M")
        String genero,

        @Schema(description = "Número de celular", example = "(11) 98765-4321")
        String celular,

        @Schema(description = "Endereço de e-mail", example = "joao@example.com")
        String email,

        @Schema(description = "Cidade do aluno", example = "São Paulo")
        String cidade,

        @Schema(description = "Unidade Federativa (UF)", example = "SP")
        String estado,

        @Schema(description = "Data e hora do cadastro", example = "2024-01-15T10:30:00")
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
