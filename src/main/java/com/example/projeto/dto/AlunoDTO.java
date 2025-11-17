package com.example.projeto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Long cursoId;    // ID do curso
    private String nomeCurso; // só o nome do curso, sem expor toda a entidade

}
