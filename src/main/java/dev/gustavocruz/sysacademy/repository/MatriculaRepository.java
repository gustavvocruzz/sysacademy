package dev.gustavocruz.sysacademy.repository;

import dev.gustavocruz.sysacademy.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
