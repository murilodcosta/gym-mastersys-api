package dev.murilodcosta.mastersys.service;

import dev.murilodcosta.mastersys.domain.Aluno;
import dev.murilodcosta.mastersys.dto.AlunoRequest;
import dev.murilodcosta.mastersys.dto.AlunoResponse;
import dev.murilodcosta.mastersys.exception.RegraNegocioException;
import dev.murilodcosta.mastersys.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    public final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public AlunoResponse cadastrar(AlunoRequest alunoRequest) {
        if (alunoRequest.email() != null && alunoRepository.existsByEmail(alunoRequest.email())) {
            throw new RegraNegocioException("Já existe um aluno cadastrado com esse email");
        }
        var aluno = alunoRequest.toEntity();
        var alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    public Page<AlunoResponse> listar(Pageable pageable) {
        var alunos = alunoRepository.findAll(pageable);
        return alunos.map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorId(Long id) {
        var aluno = buscarAlunoPorId(id);
        return AlunoResponse.fromEntity(aluno);
    }

    public AlunoResponse atualizar(Long id, AlunoRequest alunoRequest) {
        var aluno = buscarAlunoPorId(id);
        alunoRequest.preencher(aluno);
        var alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    public void excluir(Long id) {
        var aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }

    private Aluno buscarAlunoPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Aluno não encontrado"));
    }


}
