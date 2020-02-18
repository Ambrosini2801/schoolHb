package br.com.school.Disciplinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:51650")
@RequestMapping("/disciplinas")
public class DisciplinasRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinasRest.class);
    private final DisciplinasService disciplinasService;

    @Autowired
    public DisciplinasRest(DisciplinasService disciplinasService) {
        this.disciplinasService = disciplinasService;
    }

    @PostMapping
    public DisciplinasDTO save(@RequestBody DisciplinasDTO disciplinasDTO) {
        LOGGER.info("Recebendo solicitação de persistência de disciplinas...");
        LOGGER.debug("Payload: {}", disciplinasDTO);
        return this.disciplinasService.save(disciplinasDTO);
    }

    @GetMapping("/{id}")
    public Disciplinas find(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo find by ID... id: [{}]", id);
        return this.disciplinasService.findById(id);
    }

    @PutMapping("/{id}")
    public DisciplinasDTO udpate(@PathVariable("id") Long id, @RequestBody DisciplinasDTO disciplinasDTO) {
        LOGGER.info("Recebendo Update para disciplina de ID: {}", id);
        LOGGER.debug("Payload: {}", disciplinasDTO);
        return this.disciplinasService.update(disciplinasDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo delete para a disciplina de ID: {}", id);

    }
}