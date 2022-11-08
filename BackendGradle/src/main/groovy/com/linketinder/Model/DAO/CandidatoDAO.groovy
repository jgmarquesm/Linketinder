package com.linketinder.Model.DAO


import groovy.sql.Sql
import java.sql.SQLException

class CandidatoDAO extends ClassDAO implements MatchDAO{

    @Override
    String verificaMatch(int id_candidato, int id_vaga){
        try {
            Sql verifica = conexaoDB.conectar()
            String matches
            verifica.query("""SELECT v.nome AS Vaga, e.nome AS Empresa FROM vagas AS v, empresas AS e, candidatos AS
 c WHERE v.id = $id_vaga AND WHERE c.id = $id_candidato AND c.id IN (SELECT id_candidato FROM candidatoscurtidos WHERE 
id_empresa = e.id) AND e.id = v.id_empresa AND v.id IN SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id) 
ORDER BY c.id""") {
                matches = "| ${'Vaga'.center(20)} | ${'Empresa'.center(25)} |"
                while (it.next()) {
                    String nomeVaga = it.getString('Vaga')
                    String nomeEmpresa = it.getString('Empresa')
                    matches += "\n| ${nomeVaga.center(20)} | ${nomeEmpresa.center(25)} |"
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