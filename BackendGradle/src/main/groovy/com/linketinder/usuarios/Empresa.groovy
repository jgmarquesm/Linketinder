package com.linketinder.usuarios

import com.linketinder.DAO.EmpresaDAO
import com.linketinder.DAO.VagaDAO
import com.linketinder.interfaces.DAO
import com.linketinder.interfaces.UsuarioEmpresa

class Empresa implements UsuarioEmpresa{

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
    void criar(EmpresaDAO empresaDAO) {
        try {
            empresaDAO.create(this)
        } catch (ClassCastException e) {
            e.cause
            e.printStackTrace()
        }
    }

    static void listarMinhasVagas(VagaDAO vagaDAO, int id) {
        vagaDAO.read(2, id)
    }
}
