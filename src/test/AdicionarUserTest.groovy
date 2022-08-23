package test

import main.App
import main.Candidato
import main.Empresa
import spock.lang.Specification

class AdicionarUserTest extends Specification {

    def "Teste Cadastro de um novo Candidato"() {

        def nome = "teste"
        def email = "teste@gmail.com"
        def cpf = "00000000000"
        def idade = 20
        def estado = "Goias"
        def cep = "00000000"
        def descricao = "descrição teste"
        ArrayList<String> competencias = new ArrayList<>()

        given:
            Candidato candidato = new Candidato(nome: nome, email: email, cpf: cpf,
                idade: idade, estado: estado, cep: cep, descricao: descricao)
        when:
            App.getCandidatos().add(candidato)
        then:
            App.getCandidatos().size() == old(App.getCandidatos().size())+1
    }


    def "Teste Cadastro de uma nova Empresa"() {

        def nome = "teste"
        def emailcorporativo = "teste@gmail.com"
        def cnpj = "00000000000000"
        def pais = "Brasil"
        def estado = "Goias"
        def cep = "00000000"
        def descricao = "descrição teste"
        ArrayList<String> competencias = new ArrayList<>()

        given:
            Empresa empresa = new Empresa(nome: nome, emailCorporativo: emailcorporativo, cnpj: cnpj,
                pais: pais, estado: estado, cep: cep, descricao: descricao, competencias: competencias)
        when:
            App.getEmpresas().add(empresa)
        then:
            App.getEmpresas().size() == old(App.getEmpresas().size()) + 1
    }
}
