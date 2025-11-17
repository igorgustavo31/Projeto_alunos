package com.example.projeto.service;

import com.example.projeto.model.Curso;
import com.example.projeto.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public List<Curso> listarTodos() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Curso não encontrado com ID: " + id));
    }

    public Curso atualizar(Long id, Curso cursoDetalhes) {
        Curso cursoExistente = buscarPorId(id);
        cursoExistente.setNome(cursoDetalhes.getNome());
        cursoExistente.setCargaHoraria(cursoDetalhes.getCargaHoraria());
        return cursoRepository.save(cursoExistente);
    }

    public void deletar(Long id) {
        Curso curso = buscarPorId(id);
        cursoRepository.delete(curso);
    }
}
