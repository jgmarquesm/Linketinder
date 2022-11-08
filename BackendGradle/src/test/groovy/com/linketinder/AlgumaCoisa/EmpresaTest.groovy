package com.linketinder.AlgumaCoisa

import spock.lang.Specification

class EmpresaTest extends Specification {
    def "test toString"() {
        given:
            Empresa empresa = new Empresa(nome: "Empresa Teste", cnpj: "00000000000000", telefone: "0000000000",
                cep: "00000000", resumo: "blablabla", ramo: "Teste", qtdFunc: "00")
        when:
            String empresaToString = empresa.toString()
            String resultadoEsperado = """
nome: Empresa Teste
CNPJ: 00000000000000
Telefone: 0000000000
Cep: 00000000
Descrição: blablabla
Atuação: Teste
Quantidade de funcionário: 00
               """
        then:
            empresaToString == resultadoEsperado
    }

    def "verificando parametros passados para serem usados colunas"() {
        given:
            Empresa empresa = new Empresa(nome: "Empresa Teste", cnpj: "00000000000000", telefone: "0000000000",
                    cep: "00000000", resumo: "blablabla", ramo: "Teste", qtdFunc: "00")
        when:
            List<?> colunas = empresa.getColunas()
            List<?> resultadoEsperado = ["Empresa Teste", "00000000000000", "0000000000", "00000000", "blablabla", "Teste", 00]
        then:
            colunas == resultadoEsperado
    }

    def "Verificando o Statement responsável por criar uma empresa no banco de dados"(){
        given:
            Empresa empresa = new Empresa(nome: "Empresa Teste", cnpj: "00000000000000", telefone: "0000000000",
                    cep: "00000000", resumo: "blablabla", ramo: "Teste", qtdFunc: "00")
        when:
            String statement = empresa.getSqlCreateStatement()
            String resultadoEsperado = 'INSERT INTO empresas (nome, cnpj, telefone, cep, resumo, ramo, quantidade_funcionario) VALUES (?, ?, ?, ?, ?, ?, ?)'
        then:
            statement == resultadoEsperado
    }
}
