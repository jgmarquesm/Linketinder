package test

import com.linketinder.Empresa
import spock.lang.Specification

class EmpresaTest extends Specification {

    def nome = "teste"
    def emailcorporativo = "teste@gmail.com"
    def cnpj = "00000000000000"
    def pais = "Brasil"
    def estado = "Goias"
    def cep = "00000000"
    def descricao = "descrição teste"
    ArrayList<String> competencias = new ArrayList<>()
    Empresa empresa = new Empresa(nome: nome, emailCorporativo: emailcorporativo, cnpj: cnpj,
            pais: pais, estado: estado, cep: cep, descricao: descricao, competencias: competencias)

    def "test adicionando competencia desejada" () {

        given:
            competencias.add("Python")
        when:
            empresa.addCompetencia(competencias)
        then:
            empresa.getCompetencias().contains("Python")

    }

    def "test sem adição de competencia desejada" () {
        given:
            null
        when:
        empresa.addCompetencia()
        then:
        empresa.getCompetencias().isEmpty()
    }

    def "test Empresa toString" () {
        given:
            competencias.add("Pyhton")
        when:
            empresa.addCompetencia(competencias)
            String resultadoEsperado = """
nome: teste
email: teste@gmail.com
CNPJ: 00000000000000
País: Brasil
Estado: Goias
Cep: 00000000
Descrição: descrição teste
Competencias desejadas: [Python]"""
        then:
            empresa.toString().equals(resultadoEsperado)
    }

    def "test Empresa toString sem competencias desejadas" () {
        given:
            null
        when:
        String resultadoEsperado = """
nome: teste
email: teste@gmail.com
CNPJ: 00000000000000
País: Brasil
Estado: Goias
Cep: 00000000
Descrição: descrição teste
Competencias desejadas: []
"""
        then:
            empresa.toString().equals(resultadoEsperado)
    }
}
