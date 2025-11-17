package com.example.projeto.controller;

import com.example.projeto.model.Aluno;
import com.example.projeto.dto.AlunoDTO;
import com.example.projeto.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    // 🔹 Criar novo aluno
    @PostMapping
    public ResponseEntity<AlunoDTO> criarAluno(@Valid @RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(201).body(alunoService.toDTO(novoAluno));
    }

    // 🔹 Listar todos os alunos como DTO
    @GetMapping
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        List<AlunoDTO> alunosDTO = alunoService.listarTodosDTO();
        return ResponseEntity.ok(alunosDTO);
    }

    // 🔹 Buscar aluno por ID
    @GetMapping("/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok(alunoService.toDTO(aluno));
    }

    // 🔹 Atualizar aluno
    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> atualizarAluno(
            @PathVariable Long id,
            @Valid @RequestBody Aluno alunoDetalhes
    ) {
        Aluno alunoAtualizado = alunoService.atualizar(id, alunoDetalhes);
        return ResponseEntity.ok(alunoService.toDTO(alunoAtualizado));
    }

    // 🔹 Deletar aluno
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
