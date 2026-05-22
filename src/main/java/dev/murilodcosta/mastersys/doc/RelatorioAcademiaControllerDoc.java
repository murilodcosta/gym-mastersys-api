package dev.murilodcosta.mastersys.doc;

import dev.murilodcosta.mastersys.projection.AlunosPorCidadeProjection;
import dev.murilodcosta.mastersys.projection.FaturamentoMensalProjection;
import dev.murilodcosta.mastersys.projection.FaturasEmAbertoProjection;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "Relatórios",
        description = "Operações para geração de relatórios gerenciais e financeiros da academia."
)
public interface RelatorioAcademiaControllerDoc {

    // =========================================================================================
    //  FATURAMENTO MENSAL
    // =========================================================================================
    @Operation(
            summary = "Relatório de faturamento mensal",
            description = "Retorna o faturamento total da academia agrupado por mês e ano.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Relatório gerado com sucesso"
                    )
            }
    )
    List<FaturamentoMensalProjection> faturamentoMensal();

    // =========================================================================================
    //  ALUNOS POR CIDADE
    // =========================================================================================
    @Operation(
            summary = "Relatório de alunos por cidade",
            description = "Retorna a quantidade de alunos matriculados agrupados por cidade.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Relatório gerado com sucesso"
                    )
            }
    )
    List<AlunosPorCidadeProjection> alunosPorCidade();

    // =========================================================================================
    //  FATURAS EM ABERTO
    // =========================================================================================
    @Operation(
            summary = "Relatório de faturas em aberto",
            description = "Retorna uma lista contendo as faturas de matrículas que estão em aberto (pendentes).",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Relatório gerado com sucesso"
                    )
            }
    )
    List<FaturasEmAbertoProjection> faturasEmAberto();
}
