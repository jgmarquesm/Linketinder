package com.linketinder.DAO

import groovy.sql.Sql

import javax.swing.JOptionPane


class EmpresaDAO {

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }

    private static void desconectar(connection) { connection.close() }

    static void create(def t) {
        Sql create = conectar()
        List<String> params = [t.nome, t.cnpj, t.telefone, t.cep, t.resumo, t.ramo, (t.qtdFunc as Integer)]
        create.executeInsert('INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)', params)
        desconectar(create)
        []
    }

    static def read(def ... args) {
        readCNPJ((args[0] as String))
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
        desconectar(delete)
        String msg = JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso.")
        []
    }

    static String verificaMatch(int id_candidato, id_empresa){
        Sql verifica = conectar()
        String matches
        verifica.query("""SELECT v.nome AS Vaga, c.nome AS "Nome Candidato", c.sobrenome AS "Sobrenome Candidato" 
FROM vagas AS v, empresas AS e, candidatos AS c WHERE c.id = $id_candidato AND e.id = $id_empresa AND e.id = v.id_empresa AND c.id IN (SELECT id_candidato 
FROM vagascurtidas WHERE v.id = id_vaga) AND c.id IN (SELECT id_candidato FROM candidatoscurtidos WHERE v.id = id_empresa) 
ORDER BY e.id"""){
            matches = "| Vaga | Candidato |"
            while (it.next()){
                String nomeCandidato = it.getString('Nome Candidato')
                String sobrenomeCandidato = it.getString('Sobrenome Candidato')
                String nomeVaga = it.getString('Vaga')
                matches += "| $nomeVaga | $nomeCandidato $sobrenomeCandidato |"
            }
        }
        desconectar(verifica)
        matches
    }
}