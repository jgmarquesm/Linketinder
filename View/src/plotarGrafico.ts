import { candidatos } from './main';


export default function extrairDados(){

    var listaDeSkillsUnicas: Array<string> = new Array();
    var qtdCandidatosComCadaSkill: Array<number> = new Array();

    for (let cand of candidatos){
        for (let hab of cand.habilidades()){
            qtdCandidatosComCadaSkill[listaDeSkillsUnicas.indexOf(hab)] = 0;
            if (!listaDeSkillsUnicas.includes(hab)){
                listaDeSkillsUnicas.push(hab);
            }
        }
    }

    for (let cand of candidatos){
        for (let hab of listaDeSkillsUnicas){
            if(cand.habilidades().includes(hab)){
            qtdCandidatosComCadaSkill[listaDeSkillsUnicas.indexOf(hab)] += 1;
            }
        }
    }

    var x = listaDeSkillsUnicas;
    var y = qtdCandidatosComCadaSkill.slice(0, )

    localStorage.setItem("x", x.toString());
    localStorage.setItem("y", y.toString());
}
