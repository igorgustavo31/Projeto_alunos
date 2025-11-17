package com.example.projeto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "alunos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome é obrigatório.")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres.")
    private String nome;

    @NotBlank(message = "E-mail é obrigatório.")
    @Email(message = "Formato de e-mail inválido.")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Data de nascimento é obrigatória.")
    private LocalDate dataNascimento;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curso_id")
    private Curso curso;


}
