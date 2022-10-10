package com.linketinder

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
}
