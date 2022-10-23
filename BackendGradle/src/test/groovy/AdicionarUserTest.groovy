import com.linketinder.utils.App
import com.linketinder.usuarios.Candidato
import com.linketinder.usuarios.Empresa
import com.linketinder.utils.Cadastro

import spock.lang.Specification

class AdicionarUserTest extends Specification {

    def "Teste Cadastro de um novo Candidato"() {

        given:
            Candidato candidato = new Candidato(nome: "Candidato", sobrenome: "Adicionado", cpf: "11111111111",
                telefone: "11111111111", resumo: "Sou o novo Candidato adicionado", linkedin: "Linkedin Candidato adicionado",
                portifolio: "Portifolio Candidato adicionado", formacao: "Candidato adicionado")
        when:
            Cadastro.novoCandidato()
        then:
            CadastroMock.novoCandidato().getListaDeCandidatos.size() == old(CadastroMock.novoCandidato().getListaDeCandidatos.size())+1
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
