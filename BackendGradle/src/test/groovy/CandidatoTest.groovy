package test

import com.linketinder.usuarios.Candidato
import spock.lang.Specification

class CandidatoTest extends Specification {

    def "Teste Candidato toString" (){

        given:
            Candidato candidato = new Candidato(nome: "Candidato", sobrenome: "Teste", cpf: "00000000000",
                telefone: "00000000000", resumo: "blablabla", linkedin: "Linkedin Teste", portifolio: "Portifolio Teste",
                formacao: "Formação Teste")
        when:
            candidato.toString()
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
            candidato.toString().equals(resultadoEsperado)
    }
}