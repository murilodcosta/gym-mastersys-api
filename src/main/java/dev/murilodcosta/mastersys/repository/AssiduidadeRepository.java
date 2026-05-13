package dev.murilodcosta.mastersys.repository;

import dev.murilodcosta.mastersys.domain.Assiduidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssiduidadeRepository extends JpaRepository<Assiduidade, Long> {
}
