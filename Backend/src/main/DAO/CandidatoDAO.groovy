package main.DAO
import groovy.sql.Sql
import main.Candidato

import javax.swing.JOptionPane


class CandidatoDAO {

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }

    private static void desconectar(connection) { connection.close() }

    static void create(Candidato c) {
        Sql create = conectar()
        List<String> params = [c.nome, c.sobrenome, c.cpf, c.telefone, c.resumo, c.linkedin, c.portifolio, c.formacao]
        create.executeInsert('INSERT INTO candidatos (nome, sobrenome,  cpf, telefone, resumo, linkedin, portifolio, nivel_formacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)', params)
        desconectar(create)
    }

    static int readCPF(String cpf){
        int id
        Sql readCPF = conectar()
        readCPF.query("SELECT c.id FROM candidatos AS c WHERE c.cpf = $cpf"){
            while(it.next()){
                id = it.getInt('id')
            }
        }
        desconectar(readCPF)
        id
    }

    static void readAll() {
        Sql read = conectar();
        ArrayList<String> lista_habilidades = new ArrayList<>()
        read.query('SELECT c.id, c.nivel_formacao FROM candidatos AS c ORDER BY c.id') { resultSet ->
            while (resultSet.next()) {
                def id = resultSet.getString('id')
                def nivel_formacao = resultSet.getString('nivel_formacao')

                read.query("""SELECT h.habilidade FROM habilidadescandidato AS hc, habilidades as h WHERE hc.id_candidato = ${id as int} AND hc.id_habilidade = h.id"""){
                    resultSet2 -> while(resultSet2.next()){
                        lista_habilidades.add(resultSet2.getString('habilidade'))
                    }
                }
                printf('Id: %s, Formação: %s, Habilidades: %s%n------------------------%n', id, nivel_formacao, lista_habilidades.join(", "))
                lista_habilidades = []
            }
        }
        desconectar(read)
    }

    static void update(String campo, String valor, int id) {
        Sql update = conectar()
        update.executeUpdate "UPDATE candidatos SET " +  """${campo}""" + " = " + """'${valor}'""" + " WHERE id = " + """${id}"""
        desconectar(update)
        String msg = JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.")
    }

    static void delete(int id) {
        Sql delete = conectar()
        delete.execute "DELETE FROM habilidadescandidato AS hc WHERE hc.id_candidato = $id"
        delete.execute "DELETE FROM candidatos WHERE id = $id"
        delete.close()
        String msg = JOptionPane.showMessageDialog(null, "Candidato excluído com sucesso.")
    }
}