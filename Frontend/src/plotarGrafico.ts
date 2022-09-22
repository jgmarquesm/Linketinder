import * as Plotly from 'plotly.js';
import { candidatos } from './main';


 export default function extrairDados(){

    var listaDeSkillsUnicas: Array<string> = new Array();
	var qtdCandidatosComCadaSkill: Array<string> = new Array();
    
	for (let cand of candidatos){

        for (let hab of cand.habilidades()){

            if (! (hab in listaDeSkillsUnicas)){

                listaDeSkillsUnicas.push(hab);
            }
        }
        
	}
    console.log(listaDeSkillsUnicas);

        // essa função irá extrair o dados para a plotagem do gráfico e os salvará no localStorage 
        // de modo que aplicação consiga consumir esses dados usando uma tag script no body do HTML

        // Após implementar essa extração dos dados, devo implementar a lógica do add nova habilidade 
        // localizada na página do candidato

}