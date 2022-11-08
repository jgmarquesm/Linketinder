package com.linketinder.Model.DAO.utils

import com.linketinder.Model.Conexoes.ConexaoDB
import groovy.sql.Sql

import java.sql.SQLException

class utilsVaga {

    static listarVagas(ConexaoDB conexaoDB) {
        try {
            Sql read = conexaoDB.conectar()
            ArrayList<String> lista_habilidades = new ArrayList<>()
            println ("|${'ID'.center(4)}|${'Nome'.center(20)}|${'Descrição'.center(50)}|" +
                    "${'Senioridade'.center(15)}|${'Cidade'.center(20)}| Habilidades")
            read.eachRow("""SELECT v.id, v.nome, v.descricao, v.senioridade, v.cidade FROM vagas AS v""") { row ->
                read.query("""SELECT h.habilidade FROM habilidadesvaga AS hv, habilidades as h WHERE hv.id_vaga = ${row.getInt('id')} AND hv.id_habilidade = h.id""") {
                    while (it.next()) { lista_habilidades.add(it.getString('habilidade')) }
                }
                String habilidades = lista_habilidades.join(", ")
                println("|${row.getString("id").center(4)}|${row.getString("nome").center(20)}|${row.getString("descricao").center(50)}" +
                        "|${row.getString("senioridade").center(15)}|${row.getString("cidade").center(20)}| $habilidades|")
                lista_habilidades = []
            }
            conexaoDB.desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void listarMinhasVagas(int ID, ConexaoDB conexaoDB) {
        try {
            Sql read = conexaoDB.conectar()
            ArrayList<String> lista_habilidades = new ArrayList<>()
            println("|${'ID'.center(4)}|${'Nome'.center(20)}|${'Descrição'.center(50)}|" +
                    "${'Senioridade'.center(15)}|${'Cidade'.center(20)}| Habilidades")
            read.eachRow("""SELECT v.id, v.nome, v.descricao, v.senioridade, v.cidade FROM vagas AS v WHERE v.id_empresa = $ID""") {row ->
                read.query("""SELECT h.habilidade FROM habilidadesvaga AS hv, habilidades as h WHERE hv.id_vaga = ${row.getInt('id')} AND hv.id_habilidade = h.id""") {
                    while (it.next()) { lista_habilidades.add(it.getString('habilidade')) }
                }
                String habilidades = lista_habilidades.join(", ")
                println("|${row.getString("id").center(4)}|${row.getString("nome").center(20)}|${row.getString("descricao").center(50)}" +
                        "|${row.getString("senioridade").center(15)}|${row.getString("cidade").center(20)}| $habilidades|")
                lista_habilidades = []
            }
            conexaoDB.desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
