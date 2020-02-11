package br.com.school.Disciplinas;

import javax.validation.constraints.NotNull;

public class DisciplinasDTO {

    private Long id;
    @NotNull(message = "")
    private String disciplinas;
    @NotNull(message = "")

    public DisciplinasDTO() {

    }

    public DisciplinasDTO(Long id, String disciplinas) {
        this.id = id;
        this.disciplinas = disciplinas;
    }

    public static DisciplinasDTO of(Disciplinas disciplinas) {
        return new DisciplinasDTO(
                disciplinas.getId(),
                disciplinas.getDisciplinas()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "DisciplinasDTO{" +
                "id=" + id +
                ", disciplinas='" + disciplinas + '\'' +
                '}';
    }
}
