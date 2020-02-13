package br.com.school.Notas;

import br.com.school.Alunos.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotasRepository extends JpaRepository<Notas, Long> {
    List<Notas> findByAlunos(Alunos alunos);
}