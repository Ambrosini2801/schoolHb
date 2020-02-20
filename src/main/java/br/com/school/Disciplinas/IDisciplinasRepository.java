package br.com.school.Disciplinas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDisciplinasRepository extends JpaRepository<Disciplinas, Long> {
    List<Disciplinas> findAll();

}
