package com.linketinder.Domain

import com.linketinder.Model.DAO.CandidatoDAO
import com.linketinder.Model.DAO.HabilidadesDAO

class Candidato implements User{
    static String nome
    static String sobrenome
    static String cpf
    static String telefone
    static String resumo
    static String linkedin
    static String portifolio
    static String formacao

    @Override
    void criar() {CandidatoDAO.create(getColunas(), getSqlCreateStatement())}

    static ArrayList listar() {CandidatoDAO.read("candidato")}

    static void listarHabilidades(int id) {HabilidadesDAO.habilidadesCandidato(id)}

    @Override
    List<String> getColunas() {
        [nome, sobrenome, cpf, telefone, resumo, linkedin, portifolio, formacao]
    }

    @Override
    String getSqlCreateStatement() {
        "INSERT INTO candidatos (nome, sobrenome,  cpf, telefone, resumo, linkedin, portifolio, nivel_formacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
    }
}
