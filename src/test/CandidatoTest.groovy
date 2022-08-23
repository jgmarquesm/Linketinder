package test

import main.Candidato
import spock.lang.Specification

class CandidatoTest extends Specification {

    def nome = "teste"
    def email = "teste@gmail.com"
    def cpf = "00000000000"
    def idade = 20
    def estado = "Goias"
    def cep = "00000000"
    def descricao = "descrição teste"
    ArrayList<String> competencias = new ArrayList<>()
    Candidato candidato = new Candidato(nome: nome, email: email, cpf: cpf,
            idade: idade, estado: estado, cep: cep, descricao: descricao)

    def "Teste adicação de competencias" (){

        given:
            competencias.add("Java")
        when:
            candidato.addCompetencia(competencias)
        then:
            candidato.getCompetencias().contains("Java")

    }

    def "Teste sem adição de competencia" (){

        given:
            null
        when:
            candidato.addCompetencia()
        then:
            candidato.getCompetencias().isEmpty()
    }

    def "Teste Candidato toString" (){

        given:
            competencias.add("Java")
            competencias.add("Groovy")
            competencias.add("Spock")
        when:
            candidato.addCompetencia(competencias)
            String resultadoEsperado = """
nome: teste
email: teste@gmail.com
CPF: 00000000000
Idade: 20
Estado: Goias
Cep: 00000000
Descrição: descrição teste
Competencias: [Java, Groovy, Spock]
           """
        then:
            candidato.toString().equals(resultadoEsperado)
    }

    def "Testando Candidato toString sem competencias" (){

        given:
            null
        when:
            String resultadoEsperado = """
nome: teste
email: teste@gmail.com
CPF: 00000000000
Idade: 20
Estado: Goias
Cep: 00000000
Descrição: descrição teste
Competencias: []
           """
        then:
            resultadoEsperado == candidato.toString()
    }
}