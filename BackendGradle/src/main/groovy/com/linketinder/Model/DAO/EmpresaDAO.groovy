package com.linketinder.Model.DAO

import groovy.sql.Sql
import java.sql.SQLException

class EmpresaDAO extends ClassDAO {

    static String verificaMatch(int id_candidato, id_empresa){
        try {
            Sql verifica = conexaoDB.conectar()
            String matches
            verifica.query("""SELECT v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato" 
FROM vagas AS v, empresas AS e, candidatos AS c WHERE c.id = $id_candidato AND e.id = $id_empresa AND e.id = v.id_empresa AND c.id IN (SELECT id_candidato 
FROM vagascurtidas WHERE v.id = id_vaga) AND c.id IN (SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa) 
ORDER BY e.id""") {
                matches = "| ${'Vaga'.center(20)} | ${'Candidato'.center(40)} |"
                while (it.next()) {
                    String nomeCandidato = it.getString('Nome Candidato')
                    String sobrenomeCandidato = it.getString('Sobrenome Candidato')
                    String nomeVaga = it.getString('Vaga')
                    matches += "\n| ${nomeVaga.center(20)} | ${(nomeCandidato + ' ' +  sobrenomeCandidato).center(40)} |"
                }
            }
            conexaoDB.desconectar(verifica)
            matches
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }
}