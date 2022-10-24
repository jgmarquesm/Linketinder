package com.linketinder.usuarios

import com.linketinder.DAO.EmpresaDAO
import com.linketinder.DAO.VagaDAO

class Empresa {
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

    void criar(EmpresaDAO empresaDAO) {empresaDAO.create(this)}

    static void listarMinhasVagas(VagaDAO vagaDAO, int id) {
        vagaDAO.read(2, id)
    }
}
