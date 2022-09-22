import { Candidato } from "./candidato";
import { Empresa } from "./empresa";
import { Vaga } from "./vagas";
import { candidatos, empresas, vagas } from "./main"

export default function iniciaMocks() {

    // Candidato(nomeCandidato, cpf, telefone, formacao, linkedin, portifolio, skill, xpEmpresa, xpCargo, xpTempo, level, resumo)
    var candidatoMock1 = new Candidato("Candidato Padrão", "00000000000", "62000000000", "mest", "https://linkedin.com/in/candpadrao", "candpdrao.com", "Skill1, Skill2, Skill3, Skill4, Skill5, Skill6", "emp0", "cargo0", "60", "sr", "Ola, eu sou o candidato padrao!")
    candidatos.push(candidatoMock1)
    localStorage.setItem("CandidatoStd", candidatoMock1.toString())

    var candidatoMock2 = new Candidato("Candidato Mock 2", "11111111111", "62111111111", "posgrad", "https://linkedin.com/in/candmock2", "candmock2.com", "Skill1, Skill3, Skill4, Skill5", "emp1", "cargo1", "36", "pl", "Ola, eu sou o candidato mock 2!")
    candidatos.push(candidatoMock2)

    var candidatoMock3 = new Candidato("Candidato Mock 3", "22222222222", "62222222222", "sup", "https://linkedin.com/in/candmock3", "candmock3.com", "Skill1, Skill2, Skill3, Skill6", "emp1", "cargo1", "38", "pl", "Ola, eu sou o candidato mock 3!")
    candidatos.push(candidatoMock3)

    var candidatoMock4 = new Candidato("Candidato Mock 4", "33333333333", "62333333333", "tec", "https://linkedin.com/in/candmock4", "candmock4.com", "Skill1, Skill5", "emp1", "cargo1", "13", "jr", "Ola, eu sou o candidato mock 4!")
    candidatos.push(candidatoMock4)

    var candidatoMock5 = new Candidato("Candidato Mock 5", "44444444444", "62444444444", "tec", "https://linkedin.com/in/candmock5", "candmock5.com", "Skill1, Skill2, Skill4", "emp1", "cargo1", "15", "jr", "Ola, eu sou o candidato mock 5!")
    candidatos.push(candidatoMock5)

    // Empresas(cnpj, telefone, cep, historia, ramo, qtdFucionarios)
    var empresaMock1 = new Empresa("Empresa Padrão", "00000000000000", "00000000000", "00000000", "Somos a empresa bla0, bla0, bla0...", "Tech", 1)
    empresas.push(empresaMock1)
    localStorage.setItem("EmpresaStd", empresaMock1.toString())

    var empresaMock2 = new Empresa("Empresa Mock 2", "11111111111111", "11111111111", "11111111", "Somos a empresa bla1, bla1, bla1...", "TI", 2)
    empresas.push(empresaMock2)

    var empresaMock3 = new Empresa("Empresa Mock 3", "22222222222222", "22222222222", "22222222", "Somos a empresa bla2, bla2, bla2...", "Educação", 3)
    empresas.push(empresaMock3)

    var empresaMock4 = new Empresa("Empresa Mock 4", "33333333333333", "33333333333", "33333333", "Somos a empresa bla3, bla3, bla3...", "Vendas", 4)
    empresas.push(empresaMock4)

    var empresaMock5 = new Empresa("Empresa Mock 5", "44444444444444", "44444444444", "44444444", "Somos a empresa bla4, bla4, bla4...", "Contabilidade", 5)
    empresas.push(empresaMock5)

    // Vagas(nomeDaVaga, departamento, requiredSkills, descricao, senioridade)
    var vagaMock1 = new Vaga("Vaga Mock 1", "dep1", "Skill1, Skill2, Skill5", "autuar como ...", "jr")
    vagas.push(vagaMock1)

    var vagaMock2 = new Vaga("Vaga Mock 2", "dep2", "Skill1, Skill2, Skill4, Skill5", "autuar como ...", "pl")
    vagas.push(vagaMock2)

    var vagaMock3 = new Vaga("Vaga Mock 3", "dep3","Skill1, Skill2, Skill3, Skill4, Skill5", "autuar como ...", "sr")
    vagas.push(vagaMock3)

    var vagaMock4 = new Vaga("Vaga Mock 4", "dep4", "Skill1, Skill2, Skill3, Skill4, Skill5, Skill6", "autuar como ...", "esp")
    vagas.push(vagaMock4)

    var vagaMock5 = new Vaga("Vaga Mock 5", "dep5", "Skill1", "autuar como ...", "est")
    vagas.push(vagaMock5)

}