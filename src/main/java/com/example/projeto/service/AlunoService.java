package com.example.projeto.service;

import com.example.projeto.model.Aluno;
import com.example.projeto.model.Curso;
import com.example.projeto.repository.AlunoRepository;
import com.example.projeto.dto.AlunoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoService cursoService;

    // 🔹 Salvar um novo aluno
    public Aluno salvar(Aluno aluno) {
        if (aluno.getCurso() == null || aluno.getCurso().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O aluno deve estar vinculado a um curso.");
        }
        if (alunoRepository.existsByEmail(aluno.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "E-mail já cadastrado.");
        }

        Curso cursoExistente = cursoService.buscarPorId(aluno.getCurso().getId());
        aluno.setCurso(cursoExistente);

        return alunoRepository.save(aluno);
    }

    // 🔹 Listar todos os alunos (entidades)
    public List<Aluno> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        // Inicializar curso para evitar LazyInitializationException
        alunos.forEach(a -> {
            if (a.getCurso() != null) a.getCurso().getNome();
        });
        return alunos;
    }

    // 🔹 Buscar aluno por ID (entidade)
    public Aluno buscarPorId(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Aluno não encontrado com o ID: " + id));
        if (aluno.getCurso() != null) aluno.getCurso().getNome();
        return aluno;
    }

    // 🔹 Atualizar aluno existente
    public Aluno atualizar(Long id, Aluno detalhesAluno) {
        Aluno alunoExistente = buscarPorId(id);

        alunoExistente.setNome(detalhesAluno.getNome());
        alunoExistente.setEmail(detalhesAluno.getEmail());
        alunoExistente.setDataNascimento(detalhesAluno.getDataNascimento());

        if (detalhesAluno.getCurso() != null && detalhesAluno.getCurso().getId() != null) {
            Curso novoCurso = cursoService.buscarPorId(detalhesAluno.getCurso().getId());
            alunoExistente.setCurso(novoCurso);
        }

        return alunoRepository.save(alunoExistente);
    }

    // 🔹 Deletar aluno
    public void deletar(Long id) {
        Aluno aluno = buscarPorId(id);
        alunoRepository.delete(aluno);
    }

    // 🔹 Converter Aluno para AlunoDTO
    public AlunoDTO toDTO(Aluno aluno) {
        if (aluno == null) return null;

        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setEmail(aluno.getEmail());
        dto.setDataNascimento(aluno.getDataNascimento());

        if (aluno.getCurso() != null) {
        dto.setCursoId(aluno.getCurso().getId());  // adiciona o ID do curso
        dto.setNomeCurso(aluno.getCurso().getNome()); // mantém o nome do curso
    }

        return dto;
    }

    // 🔹 Listar todos os alunos como DTO
    public List<AlunoDTO> listarTodosDTO() {
        return listarTodos()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
