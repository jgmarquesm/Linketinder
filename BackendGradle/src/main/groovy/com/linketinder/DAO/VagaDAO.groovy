package com.linketinder.DAO

import groovy.sql.Sql

import javax.swing.JOptionPane
import java.sql.SQLException

class VagaDAO{

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }

    private static void desconectar(connection) { connection.close() }

    static void create(def t) {
        try {
            Sql create = conectar()
            ArrayList params = [t.nome, t.descricao, t.senioridade, t.cidade, t.id_empresa]
            create.executeInsert('INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa) VALUES (?, ?, ?, ?, ?)', params)
            println "Vaga inserida com sucesso!"
            desconectar(create)
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }

    static def read(def ... args) {
        switch (args[0]){
            case 1 -> readAll()
            case 2 -> {
                try {
                    readAllMine((args[1] as int))
                } catch (ClassCastException e){
                    e.cause
                    e.printStackTrace()
                }
            }
        }
    }

    static void readAll() {
        try {
            Sql read = conectar();
            ArrayList<String> lista_habilidades = new ArrayList<>()
            read.query("""SELECT v.id, v.nome, v.descricao, v.senioridade, v.cidade FROM vagas AS v""") { resultSet ->
                while (resultSet.next()) {
                    int id = resultSet.getInt('id')
                    String nome = resultSet.getString('nome')
                    String descricao = resultSet.getString('descricao')
                    String senioridade = resultSet.getString('senioridade')
                    String cidade = resultSet.getString('cidade')
                    read.query("""SELECT h.habilidade FROM habilidadesvaga AS hv, habilidades as h WHERE hv.id_vaga = ${id} AND hv.id_habilidade = h.id""") {
                        resultSet2 ->
                            while (resultSet2.next()) {
                                lista_habilidades.add(resultSet2.getString('habilidade'))
                            }
                    }
                    printf('Nome: %s, Descrição: %s, Senioridade: %s, Cidade: %s, Habilidades: %s%n------------------------%n', nome, descricao, senioridade, cidade, lista_habilidades.join(","))
                    lista_habilidades = []
                }
            }
            desconectar(read)
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }

    static void readAllMine(int ID) {
        try {
            Sql read = conectar();
            ArrayList<String> lista_habilidades = new ArrayList<>()
            read.query("""SELECT v.id, v.nome, v.descricao, v.senioridade, v.cidade FROM vagas AS v WHERE v.id_empresa = $ID""") { resultSet ->
                while (resultSet.next()) {
                    int id = resultSet.getInt('id')
                    String nome = resultSet.getString('nome')
                    String descricao = resultSet.getString('descricao')
                    String senioridade = resultSet.getString('senioridade')
                    String cidade = resultSet.getString('cidade')
                    read.query("""SELECT h.habilidade FROM habilidadesvaga AS hv, habilidades as h WHERE hv.id_vaga = ${id} AND hv.id_habilidade = h.id""") {
                        resultSet2 ->
                            while (resultSet2.next()) {
                                lista_habilidades.add(resultSet2.getString('habilidade'))
                            }
                    }
                    printf('Nome: %s, Descrição: %s, Senioridade: %s, Cidade: %s, Habilidades: %s%n------------------------%n', nome, descricao, senioridade, cidade, lista_habilidades.join(","))
                    lista_habilidades = []
                }
            }
            desconectar(read)
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }

    static void update(String campo, String valor, int id) {
        try {
            Sql update = conectar()
            update.executeUpdate "UPDATE vagas SET $campo = $valor WHERE id= $id"
            desconectar(update)
            String msg = JOptionPane.showMessageDialog(null, "Vaga atualizada com sucesso!")
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }

    static void delete(int id) {
        try {
            Sql delete = conectar()
            delete.execute "DELETE FROM habilidadesvaga AS hc WHERE hc.id_vaga = $id"
            delete.execute "DELETE FROM vagas WHERE id = $id"
            delete.close()
            String msg = JOptionPane.showMessageDialog(null, "Vaga excluída com sucesso!")
        } catch(SQLException e) {
            e.cause
            e.printStackTrace()
            throw e
        }
    }
}
