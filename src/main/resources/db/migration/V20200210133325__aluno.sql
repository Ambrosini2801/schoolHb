create table alunos
(

id BIGINT           IDENTITY    (1,1)   PRIMARY KEY  NOT NULL,
nome_alunos         VARCHAR     (200)                NOT NULL,
data_nascimento     DATE                             NOT NULL

);