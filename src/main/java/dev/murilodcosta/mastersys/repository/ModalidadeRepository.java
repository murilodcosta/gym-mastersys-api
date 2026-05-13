package dev.murilodcosta.mastersys.repository;

import dev.murilodcosta.mastersys.domain.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
}
