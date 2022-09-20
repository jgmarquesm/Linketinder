import * as Plotly from 'plotly.js';
import { candidatos } from './main';

// function skills(){
//     var listaSkills: Array<string> = new Array();
//     for (let cand of candidatos){
//         let skill: Array<string> = cand.skill.split(", ")
//         for (let hab of skill){
//             if (!(hab in listaSkills)){
//                 listaSkills.push(hab)
//             }
//         }
//     }
// }

// export default function plotar(){

//         var trace1 = {
//             type: 'bar',
//             x: ['Italy', 'France', 'Spain', 'USA', 'Argentina'],
//             y: [55, 49, 44, 24, 15],
//             marker: {
//                 color: '#ff5252',
//                 line: {
//                     width: 2.5,
//                     color: '#fff'
//                 }
//             }
//         }

//         var data: any = [trace1]

//         var layout = {
//             title: 'Participantes por Habilidade',
//             paper_bgcolor: 'rgba(0,0,0,0)',
//             plot_bgcolor: 'rgba(0,0,0,0)',
//             font: {
//                 size: 20,
//                 color: '#fff'
//             }
//         };

//         var config = {
//             responsive: true
//         }

//         Plotly.newPlot('myplot', data, layout, config);
        // console.log(skills)
// }