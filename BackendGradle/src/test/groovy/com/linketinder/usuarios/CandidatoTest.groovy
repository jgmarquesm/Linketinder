package com.linketinder.usuarios

import spock.lang.Specification

class CandidatoTest extends Specification {
    def "test toString"() {
        given:
            Candidato candidatoMock = new Candidato(nome: "Candidato", sobrenome: "Teste", cpf: "00000000000",
                    telefone: "00000000000", resumo: "blablabla", linkedin: "Linkedin Teste", portifolio: "Portifolio Teste",
                    formacao: "Formação Teste")
        when:
            String candidatoToString = candidatoMock.toString()
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
}
