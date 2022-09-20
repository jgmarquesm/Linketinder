import { Vaga } from './vagas';
import { Empresa } from './empresa';
import { Candidato } from './candidato';
// import plotar from './plotarGrafico';

// Arrays
var vagas: Array<Vaga> = new Array(); 
var empresas: Array<Empresa> = new Array();
export var candidatos: Array<Candidato> = new Array();

// Mocks: Candidatos, Empresas e Vagas Padrões
var candidatoPadrao1 = new Candidato("Candidato 1", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao1)
localStorage.setItem("CandidatoStd", candidatoPadrao1.toString())

var candidatoPadrao2 = new Candidato("Candidato 2", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao2)
localStorage.setItem(`cand-${candidatos.length.toString()}`, candidatoPadrao2.toString())

var candidatoPadrao3 = new Candidato("Candidato 3", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao3)
localStorage.setItem(`cand-${candidatos.length.toString()}`, candidatoPadrao3.toString())

var candidatoPadrao4 = new Candidato("Candidato 4", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao4)
localStorage.setItem(`cand-${candidatos.length.toString()}`, candidatoPadrao4.toString())

var candidatoPadrao5 = new Candidato("Candidato 5", "", "", "", "", "", "", "", "", "", "", "")
candidatos.push(candidatoPadrao5)
localStorage.setItem(`cand-${candidatos.length.toString()}`, candidatoPadrao5.toString())

var empresaPadrao1 = new Empresa("", "", "", "", "", "", 1)
empresas.push(empresaPadrao1)
localStorage.setItem("EmpresaStd", empresaPadrao1.toString())

var empresaPadrao2 = new Empresa("", "", "", "", "", "", 2)
empresas.push(empresaPadrao2)
localStorage.setItem(`emp-${empresas.length.toString()}`, empresaPadrao2.toString())

var empresaPadrao3 = new Empresa("", "", "", "", "", "", 3)
empresas.push(empresaPadrao3)
localStorage.setItem(`emp-${empresas.length.toString()}`, empresaPadrao3.toString())

var empresaPadrao4 = new Empresa("", "", "", "", "", "", 4)
empresas.push(empresaPadrao4)
localStorage.setItem(`emp-${empresas.length.toString()}`, empresaPadrao4.toString())

var empresaPadrao5 = new Empresa("", "", "", "", "", "", 5)
empresas.push(empresaPadrao5)
localStorage.setItem(`emp-${empresas.length.toString()}`, empresaPadrao5.toString())

var vagaPadrao1 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao1)
localStorage.setItem(`vaga-${vagas.length.toString()}`, vagaPadrao1.toString())

var vagaPadrao2 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao2)
localStorage.setItem(`vaga-${vagas.length.toString()}`, vagaPadrao2.toString())

var vagaPadrao3 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao3)
localStorage.setItem(`vaga-${vagas.length.toString()}`, vagaPadrao3.toString())

var vagaPadrao4 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao4)
localStorage.setItem(`vaga-${vagas.length.toString()}`, vagaPadrao4.toString())

var vagaPadrao5 = new Vaga("", "", "", "","")
vagas.push(vagaPadrao5)
localStorage.setItem(`vaga-${vagas.length.toString()}`, vagaPadrao5.toString())

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

        const img: any = document.querySelector('input[type=file]') as Element;
        const imgPath = img.files[0];
        const reader = new FileReader();

        // reader.addEventListener("load", function () {
        //     const result = reader.result?.toString();

        //     if (result){
        //         return localStorage.setItem(`avatarCandidato${candidato.nomeCandidato}`, result)
        //     }
            
        // }, false);

        // if (imgPath) {
        //     reader.readAsDataURL(imgPath);
        // }
        
        localStorage.setItem(candidatos.length.toString(), candidato.toString());
        
        sessionStorage.setItem("novo", "novo")
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

// var plot = plotar()