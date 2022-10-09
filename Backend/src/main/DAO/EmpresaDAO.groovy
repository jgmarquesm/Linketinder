package main.DAO
import groovy.sql.Sql
import main.Empresa

import javax.swing.JOptionPane


class EmpresaDAO {

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }

    private static void desconectar(connection) { connection.close() }

    static void create(Empresa e) {
        Sql create = conectar()
        List<String> params = [e.nome, e.cnpj, e.telefone, e.cep, e.resumo, e.ramo, e.qtdFunc]
        create.executeInsert('INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)', params)
        desconectar(create)
    }

    static int readCNPJ(String cnpj){
        int id
        Sql readCNPJ = conectar()
        readCNPJ.query("SELECT e.id FROM empresas AS e WHERE e.cnpj = $cnpj"){
            while(it.next()){
                id = it.getInt('id')
            }
        }
        desconectar(readCNPJ)
        id
    }

    static void update(String campo, String valor, int id) {
        Sql update = conectar()
        update.executeUpdate "UPDATE empresas SET "  +  """${campo}""" + " = " + """'${valor}'""" + " WHERE id = " + """${id}"""
        desconectar(update)
        String msg = JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.")
    }

    static void delete(int id) {
        Sql delete = conectar()
        delete.execute "DELETE FROM empresas WHERE id = $id"
        delete.close()
        String msg = JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso.")
    }
}