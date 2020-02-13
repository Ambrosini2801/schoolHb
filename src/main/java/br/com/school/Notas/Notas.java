package br.com.school.Notas;

import br.com.school.Alunos.Alunos;
import br.com.school.Disciplinas.Disciplinas;

import javax.persistence.*;

@Entity
@Table(name = "notas")
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "primeira_nota", nullable = false, length = 4)
    private double primeiraNota;
    @Column(name = "segunda_nota", nullable = false, length = 4)
    private double segundaNota;
    @Column(name = "terceira_nota", nullable = false, length = 4)
    private double terceiraNota;
    @Column(name = "media", nullable = false)
    private double media;


    @ManyToOne
    @JoinColumn(name = "id_alunos", referencedColumnName = "id")
    private Alunos alunos;
    @ManyToOne
    @JoinColumn(name = "id_disciplina", referencedColumnName = "id")
    private Disciplinas disciplinas;

    public Notas() {

    }

    public Long getId() {
        return id;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(double primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(double segundaNota) {
        this.segundaNota = segundaNota;
    }

    public double getTerceiraNota() {
        return terceiraNota;
    }

    public void setTerceiraNota(double terceiraNota) {
        this.terceiraNota = terceiraNota;
    }

    public Alunos getAlunos() {
        return alunos;
    }

    public void setAlunos(Alunos alunos) {
        this.alunos = alunos;
    }

    public Disciplinas getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplinas disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", primeiraNota=" + primeiraNota +
                ", segundaNota=" + segundaNota +
                ", terceiraNota=" + terceiraNota +
                ", media=" + media +
                ", alunos=" + alunos +
                ", disciplinas=" + disciplinas +
                '}';
    }
}