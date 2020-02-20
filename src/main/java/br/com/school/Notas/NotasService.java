package br.com.school.Notas;

import br.com.school.Alunos.AlunosService;
import br.com.school.Disciplinas.DisciplinasService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NotasService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotasService.class);
    private static final URI SAMPLE_CSV_FILE_PATH = null;
    private final INotasRepository iNotasRepository;
    private AlunosService alunosService;
    private DisciplinasService disciplinasService;

    @Autowired
    public NotasService(INotasRepository iNotasRepository, AlunosService alunosService, DisciplinasService disciplinasService) {
        this.iNotasRepository = iNotasRepository;
        this.alunosService = alunosService;
        this.disciplinasService = disciplinasService;
    }

    public NotasDTO save(NotasDTO notasDTO) {
        LOGGER.info("Salvando notas!");
        LOGGER.debug("Notas: {}", notasDTO);

        Notas notas = new Notas();
        notas.setAlunos(alunosService.findById(notasDTO.getAlunos()));
        notas.setDisciplinas(disciplinasService.findById(notasDTO.getDisciplinas()));

        notas.setId(notasDTO.getId());
        notas.setPrimeiraNota(notasDTO.getPrimeiraNota());
        notas.setSegundaNota(notasDTO.getSegundaNota());
        notas.setTerceiraNota(notasDTO.getTerceiraNota());
        notas.setMedia((notas.getPrimeiraNota()+ notas.getSegundaNota()+ notas.getTerceiraNota())/3);

        notas = this.iNotasRepository.save(notas);
        return notasDTO.of(notas);

    }

    public NotasDTO findById(Long id) {
        Optional<Notas> notasOptional = this.iNotasRepository.findById(id);
        if (notasOptional.isPresent()) {
            return NotasDTO.of(notasOptional.get());
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public NotasDTO update(NotasDTO notasDTO, Long id) {
        Optional<Notas> notasOptional = this.iNotasRepository.findById(id);
        if (notasOptional.isPresent()) {
            Notas notas = notasOptional.get();

            notas.setAlunos(alunosService.findById(notasDTO.getAlunos()));
            notas.setDisciplinas(disciplinasService.findById(notasDTO.getDisciplinas()));
            notas.setPrimeiraNota(notas.getPrimeiraNota());
            notas.setSegundaNota(notas.getSegundaNota());
            notas.setTerceiraNota(notas.getTerceiraNota());
            notas.setMedia((notas.getPrimeiraNota()+ notas.getSegundaNota()+ notas.getTerceiraNota())/3);

            LOGGER.info("Atualizando nota... id: [{}]", notas.getId());
            LOGGER.debug("Payload: {}", notasDTO);

            notas = this.iNotasRepository.save(notas);
            return NotasDTO.of(notas);
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para nota de ID: [{}]", id);
        this.iNotasRepository.deleteById(id);
    }

    public String jasperExport(String format, Long id) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\vanessa.silva\\Desktop";
        List<Notas> boletim = iNotasRepository.findByAlunos(alunosService.findById(id));
        //Carregar arquivo e compilá-lo
        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(boletim);
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\boletim.html");
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\boletim.pdf");
        }
        return "Relatório gerado na pasta : " + path;
    }


}