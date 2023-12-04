CREATE TABLE aluno(
    numero_matricula INT PRIMARY KEY,
    nome_aluno VARCHAR(100),
    email_aluno VARCHAR(100),
    senha_aluno VARCHAR(100),
);

CREATE TABLE professor(
    id_professor SERIAL PRIMARY KEY,
    nome_professor VARCHAR(100),
    email_professor VARCHAR(100),
    senha_professor VARCHAR(100),
);

CREATE TABLE turma(
    id_turma SERIAL PRIMARY KEY,
    horario VARCHAR(10),
    local_turma VARCHAR(50),
    fk_id_professor INT,
    fk_id_disciplina INT,
    FOREIGN KEY (fk_id_professor) REFERENCES professor (id_professor),
    FOREIGN KEY (fk_id_disciplina) REFERENCES disciplina (id_disciplina)
);

CREATE TABLE disciplina(
    id_disciplina SERIAL PRIMARY KEY,
    nome_disciplina VARCHAR(100),
    carga_horaria INT
);

CREATE TABLE matricula(
    id_matricula SERIAL PRIMARY KEY,
    fk_id_aluno INT,
    fk_id_turma INT,
    FOREIGN KEY (fk_id_aluno) REFERENCES aluno (numero_matricula),
    FOREIGN KEY (fk_id_turma) REFERENCES turma (id_turma)
);

CREATE TABLE avaliacao(
    id_avaliacao SERIAL PRIMARY KEY,
    fk_id_aluno INT,
    fk_id_turma INT,
    nota_1 DOUBLE PRECISION,
    nota_2 DOUBLE PRECISION,
    nota_3 DOUBLE PRECISION,
    nota_recuperacao DOUBLE PRECISION,
    FOREIGN KEY (fk_id_aluno) REFERENCES aluno (numero_matricula),
    FOREIGN KEY (fk_id_turma) REFERENCES turma (id_turma)
);

CREATE TABLE presenca(
    id_presenca SERIAL PRIMARY KEY,
    fk_id_aluno INT,
    fk_id_turma INT,
    data_presenca DATE,
    presente BOOLEAN,
    FOREIGN KEY (fk_id_aluno) REFERENCES aluno (numero_matricula),
    FOREIGN KEY (fk_id_turma) REFERENCES turma (id_turma)
);

CREATE TABLE menu_semanal(
    
);



