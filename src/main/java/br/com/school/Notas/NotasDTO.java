package br.com.school.Notas;

import br.com.school.Alunos.Alunos;
import br.com.school.Disciplinas.Disciplinas;

import javax.validation.constraints.NotNull;

public class NotasDTO {

    private Long id;
    @NotNull(message = "O id das notas não deve ser nulla!")
    private double primeiraNota;
    @NotNull (message = "A primeira nota não deve ser nula, insira uma nota!")
    private double segundaNota;
    @NotNull (message = "A segunda nota não deve ser nula, insira uma nota!")
    private double terceiraNota;
    @NotNull (message = "A média não deve ser nula, insura uma média!")
    private double media;
    private Long alunos;
    private Long disciplinas;

    public NotasDTO() {

    }

    public NotasDTO(Long id, double primeiraNota, double segundaNota,  double terceiraNota, double media, Long alunos, Long disciplinas) {
        this.id = id;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
        this.terceiraNota = terceiraNota;
        this.media = media;
        this.alunos = alunos;
        this.disciplinas = disciplinas;
    }


    public static NotasDTO of(Notas notas) {
        return new NotasDTO(
                notas.getId(),
                notas.getPrimeiraNota(),
                notas.getSegundaNota(),
                notas.getTerceiraNota(),
                notas.getMedia(),
                notas.getAlunos().getId(),
                notas.getDisciplinas().getId()
        );

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
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

    public Long getAlunos() {
        return alunos;
    }

    public void setAlunos(Long alunos) {
        this.alunos = alunos;
    }

    public Long getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Long disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "NotasDTO{" +
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
