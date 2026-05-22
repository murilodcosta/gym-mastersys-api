package dev.murilodcosta.mastersys.controller;

import dev.murilodcosta.mastersys.dto.AlunoFiltroRequest;
import dev.murilodcosta.mastersys.dto.AlunoRequest;
import dev.murilodcosta.mastersys.dto.AlunoResponse;
import dev.murilodcosta.mastersys.service.AlunoService;
import dev.murilodcosta.mastersys.doc.AlunoControllerDoc;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController implements AlunoControllerDoc {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // =========================================================================================
    //  CADASTRAR ALUNO
    // =========================================================================================
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.cadastrar(alunoRequest);
    }

    // =========================================================================================
    //  LISTAR ALUNOS
    // =========================================================================================
    @GetMapping
    public Page<AlunoResponse> listar(AlunoFiltroRequest filtro, Pageable pageable) {
        return alunoService.listar(filtro, pageable);
    }

    // =========================================================================================
    //  BUSCAR POR ID
    // =========================================================================================
    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    // =========================================================================================
    //  ATUALIZAR ALUNO
    // =========================================================================================
    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody @Valid AlunoRequest alunoRequest) {
        return alunoService.atualizar(id, alunoRequest);
    }

    // =========================================================================================
    //  EXCLUIR ALUNO
    // =========================================================================================
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        alunoService.excluir(id);
    }
}
