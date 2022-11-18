package com.linketinder.Model.DAO

import com.linketinder.Model.Conexoes.BDSuportados
import com.linketinder.Model.Conexoes.ConexaoDB
import com.linketinder.Model.Conexoes.ConexaoDBFactory
import groovy.sql.Sql
import javax.swing.JOptionPane
import java.sql.SQLException
import static com.linketinder.Model.DAO.utils.utilsCandidato.listarCandidatos
import static com.linketinder.Model.DAO.utils.utilsVaga.listarVagas

abstract class ClassDAO {

    static BDSuportados db = BDSuportados.POSTGRESQL
    static ConexaoDB conexaoDB = ConexaoDBFactory.conectar(db)

    static void create(List<Object> colunas, String userSqlCreateStatement){
        Sql create = conexaoDB.conectar()
        create.connection.autoCommit = false
        try {
            create.execute(userSqlCreateStatement, colunas)
            create.commit()
            conexaoDB.desconectar(create)
            JOptionPane.showMessageDialog(null, "Cadastro criado com sucesso.")
        } catch(SQLException e) {
            create.rollback()
            e.printStackTrace()
            throw e
        }
    }

    static ArrayList read(String classe){
        if (classe == "candidato") {
            listarCandidatos(conexaoDB)
        } else if (classe == "vaga") {
            listarVagas(conexaoDB)
        } else {
            throw new Exception("Não foi possível listar.")
        }
    }

    static int read(String tabela, String documento, String NumeroDoDocumento){
        buscarIdPeloDocumento(tabela, documento, NumeroDoDocumento)
    }


    static void update(String tabela, String campo, String valor, int id) {
        Sql update = conexaoDB.conectar()
        update.connection.autoCommit = false
        try {
            update.execute("UPDATE " + tabela + " SET " + campo + " = '${valor}'" + " WHERE id = " + id)
            update.commit()
            conexaoDB.desconectar(update)
            JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.")
        } catch(SQLException e) {
            update.rollback()
            e.printStackTrace()
            throw e
        }
    }

    static void delete(String tabela, int id) {
        Sql delete = conexaoDB.conectar()
        delete.connection.autoCommit = false
        try {
            delete.execute("DELETE FROM " + tabela + " WHERE id = " + id )
            delete.commit()
            conexaoDB.desconectar(delete)
            JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso.")
        } catch(SQLException e) {
            delete.rollback()
            e.printStackTrace()
            throw e
        }
    }

    private static int buscarIdPeloDocumento(String tabela, String documento, String NumeroDoDocumento) {
        int id = 0
        try {
            Sql buscarDoc = conexaoDB.conectar()
            buscarDoc.query('SELECT id FROM ' + tabela + " WHERE " + documento + " =  '${NumeroDoDocumento}'") {
                while (it.next()) { id = it.getInt('id') }
            }
            conexaoDB.desconectar(buscarDoc)
            id
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
