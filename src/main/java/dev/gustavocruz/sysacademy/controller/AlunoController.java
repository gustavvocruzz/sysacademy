package dev.gustavocruz.sysacademy.controller;

import dev.gustavocruz.sysacademy.dtos.AlunoFiltroRequest;
import dev.gustavocruz.sysacademy.dtos.AlunoRequest;
import dev.gustavocruz.sysacademy.dtos.AlunoResponse;
import dev.gustavocruz.sysacademy.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
@Tag(name = "Alunos", description = "Endpoints para gerenciamento de alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar novo aluno", description = "Cria um novo aluno no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluno cadastrado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest request) {
        return service.cadastrar(request);
    }

    @GetMapping
    @Operation(summary = "Listar alunos", description = "Retorna uma lista paginada de alunos com filtros opcionais")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoResponse.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros de paginação inválidos")
    })
    public Page<AlunoResponse> listar(
            AlunoFiltroRequest filtro,
            Pageable pageable) {
        return service.listar(filtro, pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar aluno por ID", description = "Retorna os dados de um aluno específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public AlunoResponse buscarPorId(
            @PathVariable
            @Parameter(description = "ID do aluno", required = true)
            Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlunoResponse.class))),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public AlunoResponse atualizar(
            @PathVariable
            @Parameter(description = "ID do aluno", required = true)
            Long id,
            @RequestBody @Valid AlunoRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar aluno", description = "Remove um aluno do sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aluno deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public void deletar(
            @PathVariable
            @Parameter(description = "ID do aluno", required = true)
            Long id) {
        service.excluir(id);
    }
}
