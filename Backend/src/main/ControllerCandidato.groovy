package main
import groovy.sql.Sql


class ControllerCandidato {

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    static def Sql conectar() { def sql = Sql.newInstance url, user, password, driver }

    static def void desconectar(connection) { connection.close() }

    static void create() {
        Sql create = conectar()
        List<String> params = ['CANDIDATO', 'TESTE', '00000000000', '00000000', 'blah blah blah', 'linkedin', 'portifolio', 'mest']
        create.executeInsert('INSERT INTO candidatos (nome, sobrenome,  cpf, telefone, resumo, linkedin, portifolio, nivel_formacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)', params)
        println("Candidato inserido com sucesso!")
        desconectar(create)
    }

    static void read() {
        Sql read = conectar();
        read.query('SELECT nome, sobrenome FROM candidatos') { resultSet ->
            while (resultSet.next()) {
                def nome = resultSet.getString('nome')
                def sobrenome = resultSet.getString('sobrenome')
                printf('%s %s%n--------------%n', nome, sobrenome)
            }
        }
        desconectar(read)
    }

    static void update() {
        Sql update = conectar()
        update.executeUpdate "UPDATE candidatos SET sobrenome = 'Testando' WHERE sobrenome = 'TESTE'";
        desconectar(update)
        println('Candidato atualizado com sucesso!')
    }

    static void delete() {
        Sql delete = conectar()
        delete.execute "DELETE FROM candidatos WHERE sobrenome =  'Testando'"
        delete.close()
    }
}

// Feito: CRUD simples do candidato