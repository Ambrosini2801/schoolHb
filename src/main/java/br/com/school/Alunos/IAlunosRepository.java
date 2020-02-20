package br.com.school.Alunos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlunosRepository extends JpaRepository<Alunos, Long> {
    List<Alunos> findAll();

}
