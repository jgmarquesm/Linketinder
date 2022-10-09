-- Query: Habilidades Exigidas em cada vaga
SELECT 
	v.nome, s.habilidade AS habilidade
FROM 
	vagas AS v, habilidadesVaga AS sk, habilidades AS s
WHERE
	sk.id_vaga = v.id AND sk.id_habilidade = s.id;
	
-- Query: Candidatos curtidos pela empresa x (nesse caso, Empresa Padrão)
SELECT
	c.nome, c.sobrenome, v.nome
FROM
	candidatos AS c, vagas AS v, candidatosCurtidos AS cc, empresas AS e
WHERE
	c.id = cc.id_candidato AND e.id = cc.id_empresa AND e.id = v.id_empresa 
	AND e.id = 1;
	
-- Query: Quantidade de curtidas de cada vaga em ordem decrescente:
SELECT
	v.nome, COUNT(vc.id_candidato) AS QtdDeCurtidas
FROM
	vagas AS v, vagasCurtidas AS vc
WHERE
	v.id = vc.id_vaga
GROUP BY
	v.nome
ORDER BY
	COUNT(vc.id_candidato)
DESC;
