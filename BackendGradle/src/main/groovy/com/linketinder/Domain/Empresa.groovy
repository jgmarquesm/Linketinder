package com.linketinder.Domain

import com.linketinder.Model.DAO.EmpresaDAO
import com.linketinder.Model.DAO.VagaDAO

class Empresa implements User{
    static String nome
    static String cnpj
    static String telefone
    static String cep
    static String resumo
    static String ramo
    static String qtdFunc

    @Override
    String toString() {
        return """
nome: $nome
CNPJ: $cnpj
Telefone: $telefone
Cep: $cep
Descrição: $resumo
Atuação: $ramo
Quantidade de funcionário: $qtdFunc
               """
    }

    @Override
    void criar() { EmpresaDAO.create(getColunas(), getSqlCreateStatement())}

    static void listarMinhasVagas(int id) {
        VagaDAO.read(id)
    }

    @Override
    List<?> getColunas() {
        [nome, cnpj, telefone, cep, resumo, ramo, (qtdFunc as Integer)]
    }

    @Override
    String getSqlCreateStatement() {
        'INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)'
    }
}
