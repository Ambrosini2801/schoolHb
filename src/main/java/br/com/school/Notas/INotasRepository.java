package br.com.school.Notas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface INotasRepository extends JpaRepository<Notas, Long> {

}