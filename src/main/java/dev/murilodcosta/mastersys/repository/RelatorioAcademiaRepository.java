package dev.murilodcosta.mastersys.repository;

import dev.murilodcosta.mastersys.domain.FaturaMatricula;
import dev.murilodcosta.mastersys.projection.AlunosPorCidadeProjection;
import dev.murilodcosta.mastersys.projection.FaturamentoMensalProjection;
import dev.murilodcosta.mastersys.projection.FaturasEmAbertoProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface RelatorioAcademiaRepository extends Repository<FaturaMatricula, Long> {

    @Query(
            value = """
                    SELECT TO_CHAR(data_vencimento, 'YYYY-MM') AS mes,
                           SUM(valor) AS total
                    FROM faturas_matriculas
                    WHERE status = 'PAGA'
                    GROUP BY TO_CHAR(data_vencimento, 'YYYY-MM')
                    ORDER BY mes
                    """,
            nativeQuery = true
    )
    List<FaturamentoMensalProjection> faturamentoMensal();

    @Query(
            value = """
                    SELECT cidade,
                           count(*) as quantidade
                    FROM alunos
                    GROUP BY cidade
                    ORDER BY quantidade desc
                    """,
            nativeQuery = true
    )
    List<AlunosPorCidadeProjection> alunosPorCidade();

    @Query(
            value = """
                    SELECT m.id AS matriculaId,
                           a.nome AS alunoNome,
                            fm.data_vencimento as dataVencimento,
                            fm.valor
                    FROM faturas_matriculas fm
                    JOIN matriculas m ON fm.matricula_id = m.id
                    JOIN alunos a ON m.aluno_id = a.id
                    WHERE fm.status = 'ABERTA'
                    ORDER BY fm.data_vencimento
                    """,
            nativeQuery = true
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();
}
