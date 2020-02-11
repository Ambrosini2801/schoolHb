create table notas(

    id BIGINT       IDENTITY    (1,1)   PRIMARY KEY NOT NULL,
    primeira_nota   DECIMAL     (8,2)   NOT NULL,
    segunda_nota    DECIMAL     (8,2)   NOT NULL,
    terceira_nota   DECIMAL     (8,2)   NOT NULL,
    id_alunos BIGINT FOREIGN KEY REFERENCES alunos(id),
    id_disciplina BIGINT FOREIGN KEY REFERENCES disciplinas(id)

 );