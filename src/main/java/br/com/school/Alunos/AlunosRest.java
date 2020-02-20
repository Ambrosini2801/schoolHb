package br.com.school.Alunos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/alunos")
public class AlunosRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunosRest.class);
    private final AlunosService alunosService;

    @Autowired
    public AlunosRest(AlunosService alunosService) {
        this.alunosService = alunosService;

    }

    @PostMapping
    public AlunosDTO save(@RequestBody AlunosDTO alunosDTO) {
        LOGGER.info("Receber a solicitação da categoria");
        LOGGER.debug("Payload: {}", alunosDTO);
        return this.alunosService.save(alunosDTO);
    }

    @GetMapping("/{id}")
    public Alunos find(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo find by ID.. id: [{}]", id);
        return this.alunosService.findById(id);
    }

    @PutMapping("/{id}")
    public AlunosDTO update(@PathVariable("id") Long id, @RequestBody AlunosDTO alunosDTO) {
        LOGGER.info("Recebendo Update para categoria de ID: {}", id);
        LOGGER.debug("Payload: {}", alunosDTO);
        return this.alunosService.update(alunosDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para Categoria de ID: {}", id);
        this.alunosService.delete(id);
    }

    @GetMapping
    public List<Alunos> find() {
        LOGGER.info("Recebendo find by ID.. id: [{}]");
        return this.alunosService.findAll();
    }

}
