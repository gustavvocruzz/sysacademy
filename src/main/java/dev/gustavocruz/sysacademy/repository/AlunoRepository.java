package dev.gustavocruz.sysacademy.repository;

import dev.gustavocruz.sysacademy.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
