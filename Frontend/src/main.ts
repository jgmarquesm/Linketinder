import { Vaga } from './vagas';
import { Empresa } from './empresa';
import { Candidato } from './candidato';

// Arrays
var vagas: Array<Vaga> = new Array(); 
var empresas: Array<Empresa> = new Array();
var candidatos: Array<Candidato> = new Array();

// Candidatos, Empresas e Vagas Padrões
var candidatoPadrao1 = new Candidato("Candidato 1", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao1)
var candidatoPadrao2 = new Candidato("Candidato 2", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao2)
var candidatoPadrao3 = new Candidato("Candidato 3", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao3)
var candidatoPadrao4 = new Candidato("Candidato 4", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao4)
var candidatoPadrao5 = new Candidato("Candidato 5", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao5)

var empresaPadrao1 = new Empresa("", "", "", "", "", "", 1)
empresas.push(empresaPadrao1)
var empresaPadrao2 = new Empresa("", "", "", "", "", "", 2)
empresas.push(empresaPadrao2)
var empresaPadrao3 = new Empresa("", "", "", "", "", "", 3)
empresas.push(empresaPadrao3)
var empresaPadrao4 = new Empresa("", "", "", "", "", "", 4)
empresas.push(empresaPadrao4)
var empresaPadrao5 = new Empresa("", "", "", "", "", "", 5)
empresas.push(empresaPadrao5)

var vagaPadrao1 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao1)
var vagaPadrao2 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao2)
var vagaPadrao3 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao3)
var vagaPadrao4 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao4)
var vagaPadrao5 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao5)

// Listagem
var listarVagas = document.getElementById("lista-vagas") as HTMLElement;
var nomeCandidato = document.getElementById("nome") as HTMLElement;
var listarSkills = document.getElementById("lista-skills") as HTMLElement;
var sobreMimCand = document.getElementById("texto-about") as HTMLElement;

// Botões

// Redirecionar página
const botaoEmpresas = document.getElementById("botao-empresa") as HTMLInputElement;
const botaoCandidatos = document.getElementById("botao-candidato") as HTMLInputElement;

// Abrir modais de cadastro
const botaoCadEmpresas = document.getElementById("cadastro-empresa") as HTMLInputElement;
const botaoCadCandidatos = document.getElementById("cadastro-candidato") as HTMLInputElement;
const botaoCadVaga = document.getElementById("nova-vaga") as HTMLInputElement;

// Confirmação de cadastro
const botaoConfirmarCadEmpresa = document.getElementById("cad-emp") as HTMLInputElement;
const botaoConfirmarCadCandidato = document.getElementById("cad-cand") as HTMLInputElement;
const botaoConfirmarCadVaga = document.getElementById("cad-vaga") as HTMLInputElement;

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
        localStorage.setItem(candidatos.length.toString(), candidato.toString())
        window.location.href="pageCandidatos.html";
    }
}

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

