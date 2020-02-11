package br.com.school.Alunos;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "alunos")
public class Alunos {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_alunos", nullable = false, length = 200)
    private String nomeAluno;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

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
        return "Alunos{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
