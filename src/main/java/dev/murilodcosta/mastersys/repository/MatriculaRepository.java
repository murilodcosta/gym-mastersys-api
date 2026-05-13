package dev.murilodcosta.mastersys.repository;

import dev.murilodcosta.mastersys.domain.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
