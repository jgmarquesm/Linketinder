package com.linketinder.DAO

import com.linketinder.interfaces.DAO
import groovy.sql.Sql
import javax.swing.JOptionPane


class CandidatoDAO implements DAO{

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }

    private static void desconectar(connection) { connection.close() }

    @Override
    void create(def t) {
        Sql create = conectar()
        List<String> params = [t.nome, t.sobrenome, t.cpf, t.telefone, t.resumo, t.linkedin, t.portifolio, t.formacao]
        create.executeInsert('INSERT INTO candidatos (nome, sobrenome,  cpf, telefone, resumo, linkedin, portifolio, nivel_formacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)', params)
        desconectar(create)
    }

    @Override
    void read(def ... args) {
        switch (args[0]){
            case 1 -> readAll()
            case 2 -> {
                try {
                    readCPF((args[1] as String))
                } catch (ClassCastException e){
                    e.cause
                    e.printStackTrace()
                }
            }
        }
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

    @Override
    void update(String campo, String valor, int id) {
        Sql update = conectar()
        update.executeUpdate "UPDATE candidatos SET " +  """${campo}""" + " = " + """'${valor}'""" + " WHERE id = " + """${id}"""
        desconectar(update)
        String msg = JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso.")
    }

    @Override
    void delete(int id) {
        Sql delete = conectar()
        delete.execute "DELETE FROM habilidadescandidato AS hc WHERE hc.id_candidato = $id"
        delete.execute "DELETE FROM candidatos WHERE id = $id"
        desconectar(delete)
        String msg = JOptionPane.showMessageDialog(null, "Candidato excluído com sucesso.")
    }

    static String verificaMatch(int id_candidato, id_vaga){
        Sql verifica = conectar()
        String matches
        verifica.query("""SELECT v.nome AS Vaga, e.nome AS Empresa FROM vagas AS v, empresas AS e, candidatos AS
 c WHERE v.id = $id_vaga AND WHERE c.id = $id_candidato AND c.id IN (SELECT id_candidato FROM candidatoscurtidos WHERE 
id_empresa = e.id) AND e.id = v.id_empresa AND v.id IN SELECT id_vaga FROM vagascurtidas WHERE id_candidato = c.id) 
ORDER BY c.id"""){
            matches = "| Nome Candidato | Vaga | Empresa |"
            while (it.next()){
                String nomeVaga = it.getString('Vaga')
                String nomeEmpresa = it.getString('Empresa')
                matches += "| $nomeVaga | $nomeEmpresa |"
            }
        }
        desconectar(verifica)
        matches
    }
}