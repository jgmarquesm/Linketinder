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
portifolio, id_formacao, id_senioridade) 
VALUES ('Candidato', 'Padrao', '11111111111', '11111111111', 'Sou isso e aquilo...',
'linkedin.com/in/candpadrao', 'portifoliocandpadrao.com', 'Ens. Superior');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, id_formacao, id_senioridade)
VALUES ('Candidato', '2', '22222222222', '22222222222', 'Sou isso e aquilo...',
'linkedin.com/in/cand2', 'portifoliocand2.com', 'MBA/Especialização');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, id_formacao, id_senioridade)
VALUES ('Candidato', '3', '33333333333', '33333333333', 'Sou isso e aquilo...',
'linkedin.com/in/cand3', 'portifoliocand3.com', 'Ens. Superior');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, id_formacao, id_senioridade)
VALUES ('Candidato', '4', '44444444444', '44444444444', 'Sou isso e aquilo...',
'linkedin.com/in/cand4', 'portifoliocand4.com', 'Mestrado');

INSERT INTO candidatos (nome, sobrenome, cpf, telefone, resumo, linkedin,
portifolio, id_formacao, id_senioridade)
VALUES ('Candidato', '5', '55555555555', '55555555555', 'Sou isso e aquilo...',
'linkedin.com/in/cand5', 'portifoliocand5.com', 'Técnico');
