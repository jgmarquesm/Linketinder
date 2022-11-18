package com.linketinder.Domain

import com.linketinder.Model.DAO.VagaDAO

class Vaga {

    static String nome
    static String descricao
    static String senioridade
    static String cidade
    static Integer id_empresa

    static void criar(){VagaDAO.create(getParametros(), getSqlCreateStatement())}

    static ArrayList listar(){VagaDAO.read("vaga")}

    static List<Object> getParametros() {
        [nome, descricao, senioridade, cidade, id_empresa]
    }

    static String getSqlCreateStatement() {
        'INSERT INTO vagas (nome, descricao, senioridade, cidade, id_empresa) VALUES (?, ?, ?, ?, ?)'
    }
}
