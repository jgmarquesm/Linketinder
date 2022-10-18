-- Verficando Matches dos candidatos

-- Candidato 1
SELECT
	v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	c.id = 1
AND 
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Candidato 2
SELECT
	v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	c.id = 2
AND 
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Candidato 3
SELECT
	v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	c.id = 3
AND 
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Candidato 4
SELECT
	v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	c.id = 4
AND 
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Candidato 5
SELECT
	v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	c.id = 5
AND 
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Todos os Matches
SELECT
	c.nome AS Nome, c.sobrenome AS Sobrenome, v.nome AS Vaga, e.nome AS empresa
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE id_empresa = e.id)
AND
	e.id = v.id_empresa
AND
	v.id
IN 
	(SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id)
ORDER BY
 	c.id;

-- Verficando Matches das Empresas

-- Empresa 1
SELECT
	v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	e.id = 1
AND 
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;
	
-- Empresa 2
SELECT
	v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	e.id = 2
AND 
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;

-- Empresa 3
SELECT
	v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	e.id = 3
AND 
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;

-- Empresa 4
SELECT
	v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	e.id = 4
AND 
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;

-- Empresa 5
SELECT
	v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE 
	e.id = 5
AND 
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;

-- Todos os Matches
SELECT
	e.nome AS Empresa, v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato"
FROM
	vagas AS v, empresas AS e, candidatos AS c
WHERE
	e.id = v.id_empresa
AND
	c.id 
IN
	(SELECT id_candidato FROM vagascurtidas WHERE v.id = id_vaga)
AND
	c.id
IN
	(SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa)
ORDER BY
	e.id;
