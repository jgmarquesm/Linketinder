package com.linketinder.AlgumaCoisa

import spock.lang.Specification

class CandidatoTest extends Specification {
    def "verificando toString"() {
        given:
            Candidato candidato = new Candidato(nome: "Candidato", sobrenome: "Teste", cpf: "00000000000",
                    telefone: "00000000000", resumo: "blablabla", linkedin: "Linkedin Teste", portifolio: "Portifolio Teste",
                    formacao: "Formação Teste")
        when:
            String candidatoToString = candidato.toString()
            String resultadoEsperado = """
Nome: Candidato
Sobrenome: Teste
CPF: 00000000000
Telefone: 00000000000
Resumo: blablabla
Linkedin: Linkedin Teste
Portifólio: Portifolio Teste
Formação: Formação Teste
           """
        then:
        candidatoToString == resultadoEsperado
    }

    def "verificando parametros passados para serem usados colunas"() {
        given:
            Candidato candidato = new Candidato(nome: "Candidato", sobrenome: "Teste", cpf: "00000000000",
                    telefone: "00000000000", resumo: "blablabla", linkedin: "Linkedin Teste", portifolio: "Portifolio Teste",
                    formacao: "Formação Teste")
        when:
            List<String> colunas = candidato.getColunas()
            List<String> resultadoEsperado = ["Candidato", "Teste", "00000000000", "00000000000", "blablabla", "Linkedin Teste", "Portifolio Teste", "Formação Teste"]
        then:
            colunas == resultadoEsperado
    }

    def "Verificando o Statement responsável por criar um candidato no banco de dados"(){
        given:
            Candidato candidato = new Candidato(nome: "Candidato", sobrenome: "Teste", cpf: "00000000000",
                    telefone: "00000000000", resumo: "blablabla", linkedin: "Linkedin Teste", portifolio: "Portifolio Teste",
                    formacao: "Formação Teste")
        when:
            String statement = candidato.getSqlCreateStatement()
            String resultadoEsperado = 'INSERT INTO candidatos (nome, sobrenome,  cpf, telefone, resumo, linkedin, portifolio, nivel_formacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)'
        then:
            statement == resultadoEsperado
    }
}
