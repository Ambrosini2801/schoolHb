package br.com.school.Notas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotasRest.class);
    private final NotasService NotasService;

    @Autowired
    public NotasRest(NotasService notasService) {
        this.NotasService = notasService;
    }

    @PostMapping
    public NotasDTO save(@RequestBody NotasDTO notasDTO) {
        LOGGER.info("Receber a solicitação da categoria");
        LOGGER.debug("Payload: {}", notasDTO);
        return this.NotasService.save(notasDTO);
    }

    @GetMapping("/{id}")
    public NotasDTO find(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo find by ID.. id: [{}]", id);
        return this.NotasService.findById(id);
    }

    @PutMapping("/{id}")
    public NotasDTO update(@PathVariable("id") Long id, @RequestBody NotasDTO notasDTO) {
        LOGGER.info("Recebendo Update para categoria de ID: {}", id);
        LOGGER.debug("Payload: {}", notasDTO);
        return this.NotasService.update(notasDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo Delete para Categoria de ID: {}", id);
        this.NotasService.delete(id);
    }
}