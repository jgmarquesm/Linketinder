package com.linketinder.Model.DAO.utils

import com.linketinder.Model.Conexoes.ConexaoDB
import groovy.sql.Sql
import java.sql.SQLException

class utilsCandidato {

    static void listarCandidatos(ConexaoDB conexaoDB) {
        try {
            Sql read = conexaoDB.conectar()
            ArrayList<String> lista_habilidades = new ArrayList<>()
            print ("___________________________________________________________________________________________________________________________________________\n" +
                    "|${'ID'.center(10)}|${'Formação'.center(25)}|${'Habilidades'.center(100)}|" +
                    "\n|__________|_________________________|____________________________________________________________________________________________________|\n")
            read.eachRow('SELECT c.id, c.nivel_formacao FROM candidatos AS c ORDER BY c.id') { row ->
                read.query("""SELECT h.habilidade FROM habilidadescandidato AS hc, habilidades as h WHERE hc.id_candidato = ${row.getInt('id')} AND hc.id_habilidade = h.id""") {
                    while (it.next()) { lista_habilidades.add(it.getString('habilidade')) }
                }
                String habilidades = lista_habilidades.join(", ")
                print("|${row.getString("id").center(10)}|${row.getString("nivel_formacao").center(25)}|${habilidades.center(100)}|" +
                        "\n|__________|_________________________|____________________________________________________________________________________________________|\n")
                lista_habilidades = []
            }
            conexaoDB.desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
