CREATE TABLE alunos(
     id BIGSERIAL PRIMARY KEY,
     nome VARCHAR(255) NOT NULL,
     email VARCHAR(255),
     data_nascimento DATE,
     genero VARCHAR(1) check (genero IN ('M', 'F')),
     celular VARCHAR(30),
     telefone VARCHAR(30),
     observacao TEXT,
     endereco VARCHAR(255),
     numero VARCHAR(20),
     complemento VARCHAR(255),
     bairro VARCHAR(255),
     cidade VARCHAR(255),
     estado VARCHAR(2),
     cep VARCHAR(20),
     data_cadastro TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     data_atualizacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE modalidades(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    ativa BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE graduacoes(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE planos(
    id BIGSERIAL PRIMARY KEY,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(255) NOT NULL,
    valor_mensal NUMERIC(10, 2) NOT NULL CHECK ( valor_mensal >= 0),
    ativa BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (modalidade_id, nome)
);

CREATE TABLE matriculas(
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT NOT NULL REFERENCES alunos(id),
    data_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    data_encerramento DATE,
    dia_vencimento INTEGER NOT NULL CHECK (dia_vencimento between 1 and 31 ),
    valor_total NUMERIC(10, 2) NOT NULL CHECK ( valor_total >= 0),
    status VARCHAR(20) NOT NULL DEFAULT 'ATIVA' CHECK (status IN ('ATIVA', 'CANCELADA', 'EXPIRADA')),
    UNIQUE (aluno_id, data_matricula)
);

CREATE TABLE matricula_modalidades(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    graduacao_id BIGINT NOT NULL REFERENCES graduacoes(id),
    plano_id BIGINT NOT NULL REFERENCES planos(id),
    data_inicio DATE NOT NULL DEFAULT CURRENT_DATE,
    data_fim DATE,
    UNIQUE (matricula_id, modalidade_id)
);

CREATE TABLE fatura_matriculas(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    data_vencimento DATE NOT NULL,
    valor NUMERIC(10, 2) NOT NULL CHECK ( valor >= 0),
    data_pagamento TIMESTAMP,
    data_cancelamento DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ABERTA' CHECK (status IN ('ABERTA', 'PAGA', 'CANCELADA', 'VENCIDA')),
    UNIQUE (matricula_id, data_vencimento)
);

CREATE TABLE assiduidade(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    data_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_saida TIMESTAMP
);