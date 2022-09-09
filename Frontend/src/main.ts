import 'bootstrap/dist/css/bootstrap.css';
import { Modal } from 'bootstrap';
import { Vaga } from './vagas';
import './empresa';
import './candidato';

var vagas: Array<Vaga> = new Array();

const elementCadEmpresas = document.getElementById("modal-cadastro-empresa") as HTMLElement;
const modalCadEmpresas = new Modal(elementCadEmpresas);

const elementCadCandidatos = document.getElementById("modal-cadastro-candidato") as HTMLElement;
const modalCadCandidatos = new Modal(elementCadCandidatos);

const botaoEmpresas: HTMLElement | null = document.getElementById("botao-empresa");
const botaoCadEmpresas: HTMLElement | null = document.getElementById("cadastro-empresa");

const botaoCandidatos: HTMLElement | null = document.getElementById("botao-candidato");
const botaoCadCandidatos: HTMLElement | null = document.getElementById("cadastro-candidato");

const botaoConfirmarCadEmpresa: HTMLElement | null = document.getElementById("cad-emp");
const botaoConfirmarCadCandidato: HTMLElement | null = document.getElementById("cad-cand");

if (botaoEmpresas){
    botaoEmpresas.onclick = function(): void {
        window.location.href="pageEmpresas.html";
    }
} else {
    alert("Erro inesperado!")
}

if (botaoCadEmpresas){
    botaoCadEmpresas.onclick = function() {
        console.log("modal-cad-empresas");
        modalCadEmpresas.show();
    }
} else {
    alert("Erro inesperado!")
}

if (botaoCandidatos){
    botaoCandidatos.onclick = function(): void {
        window.location.href="pageCandidatos.html";
    }
} else {
    alert("Erro inesperado!")
}

if (botaoCadCandidatos){
    botaoCadCandidatos.onclick = function() {
        console.log("modal-cad-candidatos");
        modalCadCandidatos.show();
    }
} else {
    alert("Erro inesperado!")
}

if (botaoConfirmarCadEmpresa){
    botaoConfirmarCadEmpresa.onclick = function(): void {
        window.location.href="pageEmpresas.html";
    }
} else {
    alert("Erro inesperado!")
}

if (botaoConfirmarCadCandidato){
    botaoConfirmarCadCandidato.onclick = function(): void {
        window.location.href="pageCandidatos.html";
    }
} else {
    alert("Erro inesperado!")
}
