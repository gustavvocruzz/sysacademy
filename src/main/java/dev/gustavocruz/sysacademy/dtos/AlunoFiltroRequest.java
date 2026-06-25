package dev.gustavocruz.sysacademy.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Filtros para buscar alunos")
public record AlunoFiltroRequest(
        @Schema(description = "Filtro por nome do aluno (busca parcial)", example = "João")
        String nome,

        @Schema(description = "Filtro por e-mail do aluno (busca parcial)", example = "joao@example.com")
        String email,

        @Schema(description = "Filtro por celular do aluno (busca parcial)", example = "11987654321")
        String celular,

        @Schema(description = "Filtro por cidade do aluno", example = "São Paulo")
        String cidade,

        @Schema(description = "Filtro por estado (UF) do aluno", example = "SP")
        String estado
) {
}
