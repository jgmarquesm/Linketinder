import { Vaga } from './vagas';
import { Empresa } from './empresa';
import { Candidato } from './candidato';
import extrairDados from './plotarGrafico';

// Arrays
var vagas: Array<Vaga> = new Array(); 
var empresas: Array<Empresa> = new Array();
export var candidatos: Array<Candidato> = new Array();

// Mocks

// Candidatos
var candidatoPadrao1 = new Candidato("Candidato Padrão", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao1)
localStorage.setItem("CandidatoStd", candidatoPadrao1.toString())

var candidatoPadrao2 = new Candidato("Candidato 2", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao2)

var candidatoPadrao3 = new Candidato("Candidato 3", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao3)

var candidatoPadrao4 = new Candidato("Candidato 4", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao4)

var candidatoPadrao5 = new Candidato("Candidato 5", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao5)

// Empresas
var empresaPadrao1 = new Empresa("Empresa Padrão", "00000000000000", "00000000000", "00000000", "Somos a empresa bla0, bla0, bla0...", "Tech", 1)
empresas.push(empresaPadrao1)
localStorage.setItem("EmpresaStd", empresaPadrao1.toString())

var empresaPadrao2 = new Empresa("Empresa 2", "11111111111111", "11111111111", "11111111", "Somos a empresa bla1, bla1, bla1...", "TI", 2)
empresas.push(empresaPadrao2)

var empresaPadrao3 = new Empresa("Empresa 3", "22222222222222", "22222222222", "22222222", "Somos a empresa bla2, bla2, bla2...", "Educação", 3)
empresas.push(empresaPadrao3)

var empresaPadrao4 = new Empresa("Empresa 4", "33333333333333", "33333333333", "33333333", "Somos a empresa bla3, bla3, bla3...", "Vendas", 4)
empresas.push(empresaPadrao4)

var empresaPadrao5 = new Empresa("Empresa 5", "44444444444444", "44444444444", "44444444", "Somos a empresa bla4, bla4, bla4...", "Contabilidade", 5)
empresas.push(empresaPadrao5)

// Vagas
var vagaPadrao1 = new Vaga("Vaga 1", "", "", "","")
vagas.push(vagaPadrao1)

var vagaPadrao2 = new Vaga("Vaga 2", "", "", "","")
vagas.push(vagaPadrao2)

var vagaPadrao3 = new Vaga("Vaga 3", "", "", "","")
vagas.push(vagaPadrao3)

var vagaPadrao4 = new Vaga("Vaga 4", "", "", "","")
vagas.push(vagaPadrao4)

var vagaPadrao5 = new Vaga("Vaga 5", "", "", "","")
vagas.push(vagaPadrao5)


// Listagem na page da empresa
var listarVagas = document.getElementById("lista-vagas") as HTMLElement;


// Botões

// Redirecionar página
const botaoEmpresas = document.getElementById("botao-empresa") as HTMLInputElement;
const botaoCandidatos = document.getElementById("botao-candidato") as HTMLInputElement;

// Abrir modais de cadastro
const botaoCadEmpresas = document.getElementById("cadastro-empresa") as HTMLInputElement;
const botaoCadCandidatos = document.getElementById("cadastro-candidato") as HTMLInputElement;
const botaoCadVaga = document.getElementById("nova-vaga") as HTMLInputElement;
const botaoCadSkill = document.getElementById("nova-skill") as HTMLInputElement;

// Confirmação de cadastro
const botaoConfirmarCadEmpresa = document.getElementById("cad-emp") as HTMLInputElement;
const botaoConfirmarCadCandidato = document.getElementById("cad-cand") as HTMLInputElement;
const botaoConfirmarCadVaga = document.getElementById("cad-vaga") as HTMLInputElement;
const botaoConfirmarCadSkill = document.getElementById("cad-skill") as HTMLInputElement;


// Redirecionando

if (botaoEmpresas){
    botaoEmpresas.onclick = function(): void {
        window.location.href="pageEmpresas.html";
    }
}

if (botaoCandidatos){
    botaoCandidatos.onclick = function(): void {
        window.location.href="pageCandidatos.html";
    }
}

// Abrindo Modais

// Cadastro Empresa
if (botaoCadEmpresas){
    botaoCadEmpresas.onclick = function() {
        $("#modal-cadastro-empresa").modal("show");
    }
}

// Cadastro Candidato
if (botaoCadCandidatos){
    botaoCadCandidatos.onclick = function() {
        $("#modal-cadastro-candidato").modal("show");
    }
}

// Cadastro Vaga
if (botaoCadVaga){
    botaoCadVaga.onclick = function() {
        $("#modal-cadastro-vaga").modal("show");
    }
}

// Cadastro nova Skill
if (botaoCadSkill){
    botaoCadSkill.onclick = function() {
        $("#modal-cadastro-skill").modal("show");
    }
}

// Confirmando Cadastro

// Empresa
if (botaoConfirmarCadEmpresa){

    botaoConfirmarCadEmpresa.onclick = function(): void {

        let nomeEmpresa = document.getElementById("cad-emp-nome") as HTMLInputElement;
        let cnpjEmpresa = document.getElementById("cad-emp-cnpj") as HTMLInputElement;
        let cepEmpresa = document.getElementById("cad-emp-cep") as HTMLInputElement;
        let foneEmpresa = document.getElementById("cad-emp-fone") as HTMLInputElement;
        let ramoEmpresa = document.getElementById("cad-emp-ramo") as HTMLInputElement;
        let qtsFuncsEmpresa = document.getElementById("cad-emp-qtd-func") as HTMLInputElement;
        let historiaEmpresa = document.getElementById("cad-emp-historia") as HTMLInputElement;

        let empresa: Empresa = new Empresa(nomeEmpresa.value, cnpjEmpresa.value, foneEmpresa.value, 
            cepEmpresa.value, historiaEmpresa.value, ramoEmpresa.value, parseFloat(qtsFuncsEmpresa.value))
        
        empresas.push(empresa);

        localStorage.setItem("emp-nova", empresa.toString());
        sessionStorage.setItem("nova", "nova")
        window.location.href="pageEmpresas.html";
    }
}

// Candidato
if (botaoConfirmarCadCandidato){

    botaoConfirmarCadCandidato.onclick = function(): void {

        let nomeCandidato = document.getElementById("cad-cand-nome") as HTMLInputElement;
        let cpfCandidato = document.getElementById("cad-cand-cpf") as HTMLInputElement;
        let foneCandidato = document.getElementById("cad-cand-fone") as HTMLInputElement;
        let formacaoCandidato = document.getElementById("cad-cand-formacao") as HTMLInputElement;
        let linkedinCandidato = document.getElementById("cad-cand-linkedin") as HTMLInputElement;
        let portifolioCandidato = document.getElementById("cad-cand-port") as HTMLInputElement;
        let skillCandidato = document.getElementById("cad-cand-skills") as HTMLInputElement;
        let xpCandidatoEmp = document.getElementById("cad-cand-last-xp-emp") as HTMLInputElement;
        let xpCandidatoCargo = document.getElementById("cad-cand-last-xp-cargo") as HTMLInputElement;
        let xpCandidatoTempo = document.getElementById("cad-cand-last-xp-tempo") as HTMLInputElement;
        let levelCandidato = document.getElementById("cad-cand-level") as HTMLInputElement;
        let resumoCandidato = document.getElementById("cad-cand-resumo") as HTMLInputElement;

        var candidato = new Candidato(nomeCandidato.value, cpfCandidato.value, foneCandidato.value, 
            formacaoCandidato.value, linkedinCandidato.value, portifolioCandidato.value, skillCandidato.value, 
            xpCandidatoEmp.value, xpCandidatoCargo.value, xpCandidatoTempo.value, levelCandidato.value,
            resumoCandidato.value)
        
        candidatos.push(candidato);
        
        localStorage.setItem("cand-novo", candidato.toString());
        sessionStorage.setItem("novo", "novo")
        window.location.href="pageCandidatos.html";
    }
}

// Vaga
if (botaoConfirmarCadVaga){

    botaoConfirmarCadVaga.onclick = function(): void {

        let nomeVaga = document.getElementById("cad-vaga-nome") as HTMLInputElement;
        let departamento = document.getElementById("cad-vaga-dep") as HTMLInputElement;
        let descricaoVaga = document.getElementById("cad-vaga-desc") as HTMLInputElement;
        let senioridadeVaga = document.getElementById("cad-vaga-xp") as HTMLInputElement;
        let skillsVaga = document.getElementById("cad-vaga-skill") as HTMLInputElement;

        let vaga = new Vaga(nomeVaga.value, departamento.value, descricaoVaga.value, 
            senioridadeVaga.value, skillsVaga.value);
        
        vagas.push(vaga);
        $("#modal-cadastro-vaga").modal("hide");
        
        listarVagas.innerHTML = ""

        for (let vaga of vagas){
            listarVagas.innerHTML += `
                <li>${vaga.nomeVaga}</li>
            `
        }
    }
}

if (botaoConfirmarCadSkill){

    botaoConfirmarCadSkill.onclick = function(): void {
        $("#modal-cadastro-skill").modal("hide");
    }
}

// Listando Candidatos e Vagas

// Candidatos

var listaCandidatos = document.getElementById("tabela-candidatos") as HTMLElement;
if (listaCandidatos){

    listaCandidatos.innerHTML = "";

    for (let cand of candidatos){
        
        listaCandidatos.innerHTML += `
        <tr>
            <td>${cand.formacao}</td>
            <td>${cand.skill}</td>
            <td><button class="btn btn-sm btn-danger botao-curtir" id="like-cand-${candidatos.indexOf(cand)}">&#9825;</button></td>
        </tr>
        `
    }
}

// Vagas

var listaVagas = document.getElementById("tabela-vagas") as HTMLElement;

if (listaVagas){

    listaVagas.innerHTML = "";

    for (let vaga of vagas){
        console.log(vaga.nomeVaga, vaga.descricao, vaga.senioridade, vaga.requiredSkills)
        listaVagas.innerHTML += `
        <tr>
            <td>${vaga.nomeVaga}</td>
            <td>${vaga.descricao}</td>
            <td>${vaga.senioridade}</td>
            <td>${vaga.requiredSkills}</td>
            <td><button class="btn btn-sm btn-danger botao-curtir" id="like-vaga-${vagas.indexOf(vaga)}">&#9825;</button></td>
        </tr>
        `
    }
}


// Extraindo dados para o gráfico

// extrairDados()