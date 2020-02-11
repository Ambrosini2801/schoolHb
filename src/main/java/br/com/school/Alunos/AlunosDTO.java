package br.com.school.Alunos;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AlunosDTO {

    private Long id;
    @NotNull (message = "")
    private String nomeAluno;
    @NotNull (message = "")
    private LocalDate dataNascimento;

    public AlunosDTO() {

    }

    public AlunosDTO(Long id, String nomeAluno, LocalDate dataNascimento) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.dataNascimento = dataNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "AlunosDTO{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public static AlunosDTO of(Alunos alunos) {
        return new AlunosDTO(
                alunos.getId(),
                alunos.getNomeAluno(),
                alunos.getDataNascimento()
        );

    }
}