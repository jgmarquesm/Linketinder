package com.linketinder.usuarios

import com.linketinder.DAO.EmpresaDAO
import com.linketinder.DAO.VagaDAO

class Empresa implements User{
    String nome
    String cnpj
    String telefone
    String cep
    String resumo
    String ramo
    String qtdFunc

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
