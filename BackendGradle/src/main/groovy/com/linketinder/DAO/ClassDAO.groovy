package com.linketinder.DAO

import groovy.sql.Sql
import javax.swing.JOptionPane
import java.sql.SQLException

abstract class ClassDAO {

    static Sql conectar() {
        String url = 'jdbc:postgresql://localhost:5432/Linketinder'
        String user = 'jgmarquesm'
        String password = 'postgres'
        String driver = 'org.postgresql.Driver'
        Sql sql = Sql.newInstance url, user, password, driver
        sql
    }
    static void desconectar(connection) {connection.close()}

    static void create(List<Object> colunas, String userSqlCreateStatement){
        try {
            Sql create = conectar()
            create.execute(userSqlCreateStatement, colunas)
            desconectar(create)
            JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso.")
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void read(String classe){
        if (classe == "candidato") {
            listarCandidatos()
        } else if (classe == "vaga") {
            listarVagas()
        } else {
            throw new Exception("Não foi possível listar.")
        }
    }

    static void read(int id_empresa){ listarMinhasVagas(id_empresa) }

    static int read(String tabela, String documento, String NumeroDoDocumento){
        buscarIdPeloDocumento(tabela, documento, NumeroDoDocumento)
    }


    static void update(String tabela, String campo, String valor, int id) {
        try {
            Sql update = conectar()
            update.execute("UPDATE " + tabela + " SET " + campo + " = '${valor}'" + " WHERE id = " + id)
            desconectar(update)
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.")
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void delete(String tabela, int id) {
        try {
            Sql delete = conectar()
            delete.execute("DELETE FROM " + tabela + " WHERE id = " + id )
            desconectar(delete)
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso.")
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void listarCandidatos() {
        try {
            Sql read = conectar()
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
            desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void listarVagas() {
        try {
            Sql read = conectar()
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
            desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static int buscarIdPeloDocumento(String tabela, String documento, String NumeroDoDocumento) {
        int id
        try {
            Sql buscarDoc = conectar()
            buscarDoc.query('SELECT id FROM ' + tabela + " WHERE " + documento + " =  '${NumeroDoDocumento}'") {
                while (it.next()) { id = it.getInt('id') }
            }
            desconectar(buscarDoc)
            id
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

    static void listarMinhasVagas(int ID) {
        try {
            Sql read = conectar()
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
            desconectar(read)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
