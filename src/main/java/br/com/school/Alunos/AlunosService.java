package br.com.school.Alunos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunosService.class);
    private static final URI SAMPLE_CSV_FILE_PATH = null;
    private final IAlunosRepository iAlunosRepository;

    @Autowired
    public AlunosService(IAlunosRepository iAlunosRepository) {
        this.iAlunosRepository = iAlunosRepository;
    }

    public AlunosDTO save(AlunosDTO alunosDTO) {
        LOGGER.info("Salvando alunos");
        LOGGER.debug("Alunos: {}", alunosDTO);

        Alunos alunos = new Alunos();
        alunos.setId(alunosDTO.getId());
        alunos.setNomeAluno(alunosDTO.getNomeAluno());
        alunos.setDataNascimento(alunosDTO.getDataNascimento());

        alunos = this.iAlunosRepository.save(alunos);
        return alunosDTO.of(alunos);
    }


    public Alunos findById(Long id) {
        Optional<Alunos> alunosOptional = this.iAlunosRepository.findById(id);
        if (alunosOptional.isPresent()) {
            return alunosOptional.get();
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public AlunosDTO update(AlunosDTO alunosDTO, Long id) {
        Optional<Alunos> alunosOptional = this.iAlunosRepository.findById(id);
        if (alunosOptional.isPresent()) {
            Alunos alunos = alunosOptional.get();

            alunos.setId(alunos.getId());
            alunos.setNomeAluno(alunos.getNomeAluno());
            alunos.setDataNascimento(alunos.getDataNascimento());

            LOGGER.info("Atualizando o aluno... id: [{}]", alunos.getId());
            LOGGER.debug("Payload: {}", alunosDTO);
            LOGGER.debug("Aluno existente: {}", alunos);

            alunos = this.iAlunosRepository.save(alunos);

            return AlunosDTO.of(alunos);
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para usuário de ID: [{}]", id);

        this.iAlunosRepository.deleteById(id);
    }

    public List<Alunos> findAll() {
        return this.iAlunosRepository.findAll();
    }
}