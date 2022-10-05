CREATE TABLE habilidades (
  id SERIAL PRIMARY KEY,
  habilidade VARCHAR(20) NOT NULL
);

CREATE TABLE departamentos (
  id SERIAL PRIMARY KEY,
  departamento VARCHAR(30) NOT NULL
);

CREATE TABLE candidatos (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(30) NOT NULL,
  sobrenome VARCHAR(30) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  telefone VARCHAR(16) NOT NULL,
  resumo VARCHAR(200) NOT NULL,
  linkedin VARCHAR(60) NOT NULL,
  portifolio VARCHAR(60),
  nivel_formacao VARCHAR(20) NOT NULL
);

CREATE TABLE ultimaXp (
  id SERIAL PRIMARY KEY,
  id_candidato INT  REFERENCES candidatos(id) NOT NULL,
  empresa VARCHAR(30),
  cargo VARCHAR(30),
  tempo INT,
  senioridade VARCHAR(20) NOT NULL
);

CREATE TABLE empresas (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(60) NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  telefone VARCHAR(16) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  resumo VARCHAR(200) NOT NULL,
  ramo VARCHAR(20) NOT NULL,
  quantidade_funcionario INT NOT NULL
);

CREATE TABLE vagas (
  id SERIAL PRIMARY KEY,
  nome VARCHAR(30) NOT NULL,
  descricao VARCHAR(80) NOT NULL,
  senioridade VARCHAR(20) NOT NULL,
  cidade VARCHAR(80) NOT NULL,
  id_empresa INT REFERENCES empresas(id) NOT NULL,
  id_departamento INT REFERENCES departamentos(id) NOT NULL
);

CREATE TABLE habilidadesCandidato (
  id SERIAL PRIMARY KEY,
  id_habilidade INT REFERENCES habilidades(id) NOT NULL,
  id_candidato INT REFERENCES candidatos(id) NOT NULL
);

CREATE TABLE habilidadesVaga (
  id SERIAL PRIMARY KEY,
  id_habilidade INT REFERENCES habilidades(id) NOT NULL,
  id_vaga INT REFERENCES vagas(id) NOT NULL
);

CREATE TABLE vagasCurtidas (
  id SERIAL PRIMARY KEY,
  id_vaga INT REFERENCES vagas(id) NOT NULL,
  id_candidato INT REFERENCES candidatos(id) NOT NULL
);

CREATE TABLE candidatosCurtidos (
  id SERIAL PRIMARY KEY,
  id_empresa INT REFERENCES empresas(id) NOT NULL,
  id_candidato INT REFERENCES candidatos(id) NOT NULL
);
