import 'bootstrap/dist/css/bootstrap.css';
import { Modal } from 'bootstrap';

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
}

if (botaoCadEmpresas){
    botaoCadEmpresas.onclick = function() {
        console.log("modal-cad-empresas");
        modalCadEmpresas.show();
    }
}

if (botaoCandidatos){
    botaoCandidatos.onclick = function(): void {
        window.location.href="pageCandidatos.html";
    }
}

if (botaoCadCandidatos){
    botaoCadCandidatos.onclick = function() {
        console.log("modal-cad-candidatos");
        modalCadCandidatos.show();
    }
}

if (botaoConfirmarCadEmpresa){
    botaoConfirmarCadEmpresa.onclick = function(): void {
        window.location.href="pageEmpresas.html";
    }
}

if (botaoConfirmarCadCandidato){
    botaoConfirmarCadCandidato.onclick = function(): void {
        window.location.href="pageCandidatos.html";
    }
}

/* Gráfico

        var trace1 = {
            type: 'bar',
            x: ["Italy", "France", "Spain", "USA", "Argentina"],
            y: [55, 49, 44, 24, 15],
            marker: {
                color: '#ff5252',
                line: {
                    width: 2.5,
                    color: "#fff",
                }
            }
        }

        var data = [trace1]

        var layout = {
            title: "Participantes por Habilidade",
            paper_bgcolor: 'rgba(0,0,0,0)',
            plot_bgcolor: "rgba(0,0,0,0)",
            font: {
                size: 20,
                color: "#fff"
            }
        };

        var config = {
            responsive: true
        }

        Plotly.newPlot("myplot", data, layout, config);
*/