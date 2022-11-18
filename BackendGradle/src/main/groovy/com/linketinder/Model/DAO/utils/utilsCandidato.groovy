package com.linketinder.Model.DAO.utils

import com.linketinder.Model.Conexoes.ConexaoDB
import groovy.sql.Sql
import java.sql.SQLException

class utilsCandidato {

    static ArrayList listarCandidatos(ConexaoDB conexaoDB) {
        try {
            Sql read = conexaoDB.conectar()
            ArrayList<String> lista_habilidades = new ArrayList<>()
            ArrayList candidatos = new ArrayList<>()
            read.eachRow("SELECT c.id, c.nivel_formacao FROM candidatos AS c ORDER BY c.id") { row ->
                read.query("""SELECT h.habilidade FROM habilidadescandidato AS hc, habilidades as h WHERE hc.id_candidato = ${row.getInt('id')} AND hc.id_habilidade = h.id""") {
                    while (it.next()) { lista_habilidades.add(it.getString('habilidade')) }
                }
                def candidato = ["id": row.getString("id"), "formacao": row.getString("nivel_formacao"), "habilidades": lista_habilidades]
                candidatos.add(candidato)
                lista_habilidades = []
            }
            conexaoDB.desconectar(read)
            return candidatos
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
