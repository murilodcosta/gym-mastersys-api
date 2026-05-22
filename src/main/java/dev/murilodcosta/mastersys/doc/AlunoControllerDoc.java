package dev.murilodcosta.mastersys.doc;

import dev.murilodcosta.mastersys.dto.AlunoRequest;
import dev.murilodcosta.mastersys.dto.AlunoResponse;
import dev.murilodcosta.mastersys.dto.AlunoFiltroRequest;
import dev.murilodcosta.mastersys.exception.ErroResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "Alunos",
        description = "Operações para cadastro, consulta, atualização, exclusão e filtragem de alunos."
)
public interface AlunoControllerDoc {

    // =========================================================================================
    //  CADASTRAR ALUNO
    // =========================================================================================
    @Operation(
            summary = "Cadastrar um novo aluno",
            description = "Permite cadastrar um novo aluno no sistema. O corpo da requisição deve conter os dados do aluno a ser cadastrado.",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Aluno cadastrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    )
            }
    )
    AlunoResponse cadastrar(
            @RequestBody
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do aluno a ser cadastrado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = AlunoRequest.class),
                        examples = @ExampleObject(
                                name = "Exemplo de requisição para cadastro de aluno",
                                value = """
                                        {
                                            "nome": "Camila Pacanaro",
                                            "dataNascimento": "2004-01-11",
                                            "sexo": "F",
                                            "telefone": "4833334444",
                                            "celular": "48991645543",
                                            "email": "camila@gmail.com",
                                            "observacoes": "Aluno iniciante",
                                            "endereco": "Rua das Flores",
                                            "numero": "123",
                                            "complemento": "Apt. 202",
                                            "bairro": "Centro",
                                            "cidade": "Jundiai",
                                            "estado": "SP",
                                            "cep": "88899900010"
                                        }                                                 
                                        """
                        )
                    )
            )
            AlunoRequest alunoRequest
    );

    // =========================================================================================
    //  LISTAR ALUNOS
    // =========================================================================================
    @Operation(
            summary = "Listar alunos",
            description = "Permite listar os alunos cadastrados no sistema, com suporte a paginação e filtros.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de alunos retornada com sucesso"
                    )
            }
    )
    Page<AlunoResponse> listar(
            @Parameter(description = "Filtros para busca de alunos (nome, cidade, estado, etc.)")
            AlunoFiltroRequest filtro,

            @Parameter(description = "Parâmetros de paginação e ordenação (page, size, sort)")
            Pageable pageable
    );

    // =========================================================================================
    //  BUSCAR POR ID
    // =========================================================================================
    @Operation(
            summary = "Buscar aluno por ID",
            description = "Permite buscar os dados de um aluno específico pelo seu ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Aluno encontrado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    )
            }
    )
    AlunoResponse buscarPorId(
            @Parameter(description = "ID do aluno a ser buscado", example = "1", required = true)
            @PathVariable Long id
    );

    // =========================================================================================
    //  ATUALIZAR ALUNO
    // =========================================================================================
    @Operation(
            summary = "Atualizar um aluno",
            description = "Permite atualizar os dados de um aluno existente no sistema.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Aluno atualizado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Erro de validação ou regra de negócio",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    )
            }
    )
    AlunoResponse atualizar(
            @PathVariable Long id,
            @RequestBody
            @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do aluno a ser atualizado",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = AlunoRequest.class),
                            examples = @ExampleObject(
                                    name = "Exemplo de requisição para atualização de aluno",
                                    value = """
                                            {
                                                "nome": "Camila Pacanaro Silva",
                                                "dataNascimento": "2004-01-11",
                                                "sexo": "F",
                                                "telefone": "4833334444",
                                                "celular": "48991645543",
                                                "email": "camila.silva@gmail.com",
                                                "observacoes": "Aluno iniciante - atualizado",
                                                "endereco": "Rua das Flores",
                                                "numero": "123",
                                                "complemento": "Apt. 202",
                                                "bairro": "Centro",
                                                "cidade": "Jundiai",
                                                "estado": "SP",
                                                "cep": "88899900010"
                                            }
                                            """
                            )
                    )
            )
            AlunoRequest alunoRequest
    );

    // =========================================================================================
    //  EXCLUIR ALUNO
    // =========================================================================================
    @Operation(
            summary = "Excluir um aluno",
            description = "Permite remover um aluno do sistema pelo seu ID.",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Aluno excluído com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Aluno não encontrado",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Conflito: o aluno possui dependências e não pode ser excluído",
                            content = @Content(schema = @Schema(implementation = ErroResponse.class))
                    )
            }
    )
    void excluir(
            @Parameter(description = "ID do aluno a ser excluído", example = "1", required = true)
            @PathVariable Long id
    );

}
