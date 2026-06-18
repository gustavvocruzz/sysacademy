package dev.gustavocruz.sysacademy.domain.service;

import dev.gustavocruz.sysacademy.domain.Aluno;
import dev.gustavocruz.sysacademy.domain.dtos.AlunoRequest;
import dev.gustavocruz.sysacademy.domain.dtos.AlunoResponse;
import dev.gustavocruz.sysacademy.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public AlunoResponse cadastrar(AlunoRequest request) {
        if (request.email() != null && repository.existsByEmail(request.email())) {
            throw new RuntimeException("Já existe um aluno cadastro com esse email!");
        }
        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = repository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);

    }

    public Page<AlunoResponse> listar(Pageable pageable) {
        return repository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        return AlunoResponse.fromEntity(aluno);

    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest){
        Aluno aluno= repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        alunoRequest.preencher(aluno);
        Aluno alunoAtualizado = repository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id){
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        repository.delete(aluno);
    }
}
