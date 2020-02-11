package br.com.school.Disciplinas;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplinas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "disciplinas", nullable = false, length = 30)
    private String disciplinas;


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
        return "Disciplinas{" +
                "id=" + id +
                ", disciplinas='" + disciplinas + '\'' +
                '}';
    }
}
