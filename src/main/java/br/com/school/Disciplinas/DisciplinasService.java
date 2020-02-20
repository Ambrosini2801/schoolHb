package br.com.school.Disciplinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinasService.class);
    private final IDisciplinasRepository iDisciplinasRepository;

    public DisciplinasService(IDisciplinasRepository iDisciplinasRepository) {
        this.iDisciplinasRepository = iDisciplinasRepository;
    }

    public DisciplinasDTO save(DisciplinasDTO disciplinasDTO) {
        LOGGER.info("Salvando disciplina!");
        LOGGER.debug("Disciplina: {}", disciplinasDTO);

        Disciplinas disciplinas = new Disciplinas();
        disciplinas.setId(disciplinasDTO.getId());
        disciplinas.setDisciplinas(disciplinasDTO.getDisciplinas());

        disciplinas = this.iDisciplinasRepository.save(disciplinas);

        return DisciplinasDTO.of(disciplinas);
    }

    public Disciplinas findById(Long id) {
        Optional<Disciplinas> disciplinasOptional = this.iDisciplinasRepository.findById(id);

        if (disciplinasOptional.isPresent()) {
            return disciplinasOptional.get();
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public DisciplinasDTO update(DisciplinasDTO disciplinasDTO, Long id) {
        Optional<Disciplinas> disciplinasOptional = this.iDisciplinasRepository.findById(id);

        if (disciplinasOptional.isPresent()) {
            Disciplinas disciplinas = disciplinasOptional.get();

            LOGGER.info("Atualizando disciplinas... id: [{}]", disciplinas.getId());
            LOGGER.debug("Payload: {}", disciplinasDTO);
            LOGGER.debug("Usuário Existente: {}", disciplinas);

            disciplinas.setId(disciplinasDTO.getId());
            disciplinas.setDisciplinas(disciplinasDTO.getDisciplinas());

            disciplinas = this.iDisciplinasRepository.save(disciplinas);

            return DisciplinasDTO.of(disciplinas);
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para usuário de ID: [{}]", id);

        this.iDisciplinasRepository.deleteById(id);
    }

    public List<Disciplinas> findAll() {
        return this.iDisciplinasRepository.findAll();
    }
}