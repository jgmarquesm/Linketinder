-- habilidades
INSERT INTO habilidades (habilidade) VALUES ('Skill1');
INSERT INTO habilidades (habilidade) VALUES ('Skill2');
INSERT INTO habilidades (habilidade) VALUES ('Skill3');
INSERT INTO habilidades (habilidade) VALUES ('Skill4');
INSERT INTO habilidades (habilidade) VALUES ('Skill5');
INSERT INTO habilidades (habilidade) VALUES ('Skill6');
INSERT INTO habilidades (habilidade) VALUES ('Skill7');
INSERT INTO habilidades (habilidade) VALUES ('Skill8');
INSERT INTO habilidades (habilidade) VALUES ('Skill9');
INSERT INTO habilidades (habilidade) VALUES ('Skill10');

-- Departamentos
INSERT INTO departamentos (departamento) VALUES ('TI');
INSERT INTO departamentos (departamento) VALUES ('Contabilidade');
INSERT INTO departamentos (departamento) VALUES ('Recursos Humanos');
INSERT INTO departamentos (departamento) VALUES ('Vendas');
INSERT INTO departamentos (departamento) VALUES ('Suporte');

-- Candidatos
INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, nivel_formacao)
VALUES ('Candidato', 'Padrao', '11111111111', '11111111111', 'Sou isso e aquilo...',
'linkedin.com/in/candpadrao', 'portifoliocandpadrao.com', 'Ens. Superior');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, nivel_formacao)
VALUES ('Candidato', '2', '22222222222', '22222222222', 'Sou isso e aquilo...',
'linkedin.com/in/cand2', 'portifoliocand2.com', 'MBA/Especialização');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, nivel_formacao)
VALUES ('Candidato', '3', '33333333333', '33333333333', 'Sou isso e aquilo...',
'linkedin.com/in/cand3', 'portifoliocand3.com', 'Ens. Superior');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, nivel_formacao)
VALUES ('Candidato', '4', '44444444444', '44444444444', 'Sou isso e aquilo...',
'linkedin.com/in/cand4', 'portifoliocand4.com', 'Mestrado');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, nivel_formacao)
VALUES ('Candidato', '5', '55555555555', '55555555555', 'Sou isso e aquilo...',
'linkedin.com/in/cand5', 'portifoliocand5.com', 'Técnico');

-- Ultima XP
INSERT INTO ultimaXp (id_candidato, empresa, cargo, tempo, senioridade)
VALUES (1, 'Empresa taltal1', 'QA', 28, 'Pleno');

INSERT INTO ultimaXp (id_candidato, empresa, cargo, tempo, senioridade)
VALUES (2, 'Empresa taltal2', 'dev full stack', 62, 'Senior');

INSERT INTO ultimaXp (id_candidato, empresa, cargo, tempo, senioridade)
VALUES (4, 'Empresa taltal4', 'dev back end', 34, 'Pleno');

INSERT INTO ultimaXp (id_candidato, empresa, cargo, tempo, senioridade)
VALUES (5, 'Empresa taltal5', 'dev front end', 4, 'Estagiário');

-- Empresas
INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario)
VALUES ('Empresa Padrão', '11111111111111', '11111111111', '11111111', 'Somos a Empresa Padrão...', 'Tecnologia', 50);

INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario)
VALUES ('Empresa 2', '22222222222222', '22222222222', '22222222', 'Somos a Empresa 2...', 'Venda de Hardwares', 12);

INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario)
VALUES ('Empresa 3', '33333333333333', '33333333333', '33333333', 'Somos a Empresa 3...', 'Tecnologia', 23);

INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario)
VALUES ('Empresa 4', '44444444444444', '44444444444', '44444444', 'Somos a Empresa 4...', 'Financeiro', 15);

INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario)
VALUES ('Empresa 5', '55555555555555', '55555555555', '55555555', 'Somos a Empresa 5...', 'Fintech', 300);

-- Vagas

INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa, id_departamento)
VALUES ('Vaga 1', 'Descrição Vaga 1', 'Senior', 'Home Office', 1, 1);
INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa, id_departamento)
VALUES ('Vaga 2', 'Descrição Vaga 2', 'Júnior', 'Goiânia', 2, 1);
INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa, id_departamento)
VALUES ('Vaga 3', 'Descrição Vaga 3', 'Estagiário', 'São Paulo', 3, 1);
INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa, id_departamento)
VALUES ('Vaga 4', 'Descrição Vaga 4', 'Pleno', 'Home Office', 4, 1);
INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa, id_departamento)
VALUES ('Vaga 5', 'Descrição Vaga 5', 'Especialista', 'Home Office', 5, 1);

-- Habilidade dos Candidatos

-- Candidato 1
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (2, 1);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (3, 1);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (5, 1);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (6, 1);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (9, 1);
-- Candidato 2
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (1, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (2, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (3, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (4, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (5, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (6, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (7, 2);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (8, 2);
-- Candidato 3
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (1, 3);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (3, 3);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (4, 3);
-- Candidato 4
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (5, 4);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (6, 4);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (7, 4);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (8, 4);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (9, 4);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (10, 4);
-- Candidato 5
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (1, 5);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (2, 5);
INSERT INTO habilidadesCandidato (id_habilidade, id_candidato) VALUES (3, 5);

-- Habilidade das Vagas

-- Vaga 1
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (1, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (3, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (4, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (5, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (7, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (8, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (9, 1);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (10, 1);
-- Vaga 2
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (1, 2);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (2, 2);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (3, 2);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (4, 2);
-- Vaga 3
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (1, 3);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (3, 3);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (4, 3);
-- Vaga 4
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (5, 4);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (6, 4);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (7, 4);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (8, 4);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (9, 4);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (10, 4);
-- Vaga 5
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (1, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (2, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (3, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (4, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (5, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (6, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (7, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (8, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (9, 5);
INSERT INTO habilidadesVaga (id_habilidade, id_vaga) VALUES (10, 5);


-- Vagas Curtidas

-- Candidato 1
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (1, 1);
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (4, 1);
-- Candidato 2
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (1, 2);
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (5, 2);
-- Candidato 3
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (2, 3);
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (3, 3);
-- Candidato 4
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (1, 4);
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (4, 4);
-- Candidato 5
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (2, 5);
INSERT INTO vagasCurtidas (id_vaga, id_candidato) VALUES (3, 5);

-- Candidatos Curtidos

-- Empresa 1
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (1, 2);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (1, 4);
-- Empresa 2
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (2, 1);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (2, 3);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (2, 4);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (2, 5);
-- Empresa 3
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (3, 1);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (3, 3);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (3, 4);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (3, 5);
-- Empresa 4
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (4, 1);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (4, 3);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (4, 4);
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (4, 5);
-- Empresa 5
INSERT INTO candidatosCurtidos (id_empresa, id_candidato) VALUES (5, 2);
