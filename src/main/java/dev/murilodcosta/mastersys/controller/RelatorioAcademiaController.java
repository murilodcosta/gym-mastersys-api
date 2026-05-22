package dev.murilodcosta.mastersys.controller;

import dev.murilodcosta.mastersys.doc.RelatorioAcademiaControllerDoc;
import dev.murilodcosta.mastersys.projection.AlunosPorCidadeProjection;
import dev.murilodcosta.mastersys.projection.FaturamentoMensalProjection;
import dev.murilodcosta.mastersys.projection.FaturasEmAbertoProjection;
import dev.murilodcosta.mastersys.repository.RelatorioAcademiaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioAcademiaController implements RelatorioAcademiaControllerDoc {

    private final RelatorioAcademiaRepository relatorioAcademiaRepository;

    public RelatorioAcademiaController(RelatorioAcademiaRepository relatorioAcademiaRepository) {
        this.relatorioAcademiaRepository = relatorioAcademiaRepository;
    }

    // =========================================================================================
    //  FATURAMENTO MENSAL
    // =========================================================================================
    @GetMapping("/faturamento-mensal")
    public List<FaturamentoMensalProjection> faturamentoMensal() {
        return relatorioAcademiaRepository.faturamentoMensal();
    }

    // =========================================================================================
    //  ALUNOS POR CIDADE
    // =========================================================================================
    @GetMapping("/alunos-por-cidade")
    public List<AlunosPorCidadeProjection> alunosPorCidade() {
        return relatorioAcademiaRepository.alunosPorCidade();
    }

    // =========================================================================================
    //  FATURAS EM ABERTO
    // =========================================================================================
    @GetMapping("/faturas-em-aberto")
    public List<FaturasEmAbertoProjection> faturasEmAberto() {
        return relatorioAcademiaRepository.faturasEmAberto();
    }
}
