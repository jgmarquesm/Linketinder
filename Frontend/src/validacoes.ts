const divs = document.getElementById("form-group") as HTMLElement;

// Input Candidato
const inputCandNome = document.querySelector('#cad-cand-nome') as HTMLInputElement;
const inputCandCPF = document.querySelector('#cad-cand-cpf') as HTMLInputElement;
const inputCandFone = document.querySelector('#cad-cand-fone') as HTMLInputElement;
const inputCandFormacao = document.querySelector('#cad-cand-formacao') as HTMLInputElement;
const inputCandLinkedin = document.querySelector('#cad-cand-linkedin') as HTMLInputElement;
const inputCandPortifolio = document.querySelector('#cad-cand-port') as HTMLInputElement;
const inputCandSkills = document.querySelector('#cad-cand-skills') as HTMLInputElement;
const inputCandXPEmp = document.querySelector('#cad-cand-last-xp-em') as HTMLInputElement;
const inputCandXPCargo = document.querySelector('#cad-cand-last-xp-cargo') as HTMLInputElement;
const inputCandXPTempo = document.querySelector('#cad-cand-last-xp-tempo') as HTMLInputElement;
const inputCandLevel = document.querySelector('#cad-cand-level') as HTMLInputElement;
const inputCandResumo = document.querySelector('#cad-cand-resumo') as HTMLInputElement;
const candSubmitButton = document.querySelector('#cad-cand') as HTMLInputElement;

// Input Empresa
// const inputEmpNome = document.querySelector('#') as HTMLInputElement;
// const inputEmpCNPJ = document.querySelector('#') as HTMLInputElement;
// const inputEmpFone = document.querySelector('#') as HTMLInputElement;
// const inputEmpCEP = document.querySelector('#') as HTMLInputElement;
// const inputEmpResumo = document.querySelector('#') as HTMLInputElement;
// const inputEmpRamo = document.querySelector('#') as HTMLInputElement;
// const inputEmpQtdFunc = document.querySelector('#') as HTMLInputElement;
// const candEmpButton = document.querySelector('#cad-emp') as HTMLInputElement;

// // Input Vaga
// const inputVagaNome = document.querySelector('#') as HTMLInputElement;
// const inputVagaDep = document.querySelector('#') as HTMLInputElement;
// const inputVagaSkills = document.querySelector('#') as HTMLInputElement;
// const inputVagaDesc = document.querySelector('#') as HTMLInputElement;
// const inputVagaLevel = document.querySelector('#') as HTMLInputElement;
// const candVagaButton = document.querySelector('#cad-vaga') as HTMLInputElement;

// // Input Skill
// const inputSkillNew = document.querySelector('#');
// const candSkillButton = document.querySelector('#cad-skill')as HTMLInputElement;

// Regex
const regexNomeResumo_e_Historia: RegExp = /(?=^.{2,60}$)^(?:[^_\\][A-ù]\s?)+$/;
const regexCPF: RegExp = /(?:\d{3}\.?){3}-?\d{2}/;
const regexCNPJ: RegExp = /\d{2}\.?(?:\d{3}\.?){2}\/?\d{4}-?\d{2}/;
const regexFone: RegExp = /(?:\(?\d{2,3}\)?\s?\d\s?)?\d{4,9}.?\d{4}?/;
const regexFormacao: RegExp = /fund|med|tec|sup|posgrad|mest|doc|posdoc/;
const regexLinkedin: RegExp = /(https?\:\/\/)?(www\.)?linkedin.com\/in\/[\w]+\//;
const regexPortifolio: RegExp = /(?:https?\:\/\/)?(?:www\.)?\w+\.\w{2,}(?:\.\w{2,})*(?:\/[\w]+)*(?:\/)?/;
const regexSkillsXP_e_Ramo: RegExp = /(\w*,?\s?)*/;
const regex_XpTempo_e_qtdFunc: RegExp = /[^-](?<= )(\d{2,3})/;
const regexSenioridade: RegExp = /est|trn|jr|pl|sr|esp/;
const regexCEP: RegExp = /\d{2}\.?\d{3}\-?\d{3}/;

export default function validarDadosDoCandidato(){

    const nome = (e: any) => {
        const input = e.currentTarget;
        if (!(regexNomeResumo_e_Historia.test(inputCandNome.value))){
            candSubmitButton.setAttribute("disabled", "disabled");
            setErrorFor(divs);
        } else {
            candSubmitButton.removeAttribute("disabled");
            setSuccessFor(divs);
        }
    }
    // const cpf = regexCPF.test(inputCandCPF.value);
    // const fone = regexFone.test(inputCandFone.value);
    // const formacao = regexFormacao.test(inputCandFormacao.value);
    // const linkedin = regexLinkedin.test(inputCandLinkedin.value);
    // const portifolio = regexPortifolio.test(inputCandPortifolio.value);
    // const skills = regexSkillsXP_e_Ramo.test(inputCandSkills.value);
    // const xpEmp = regexSkillsXP_e_Ramo.test(inputCandXPEmp.value);
    // const xpCargo = regexSkillsXP_e_Ramo.test(inputCandXPCargo.value)
    // const xpTempo = regex_XpTempo_e_qtdFunc.test(inputCandXPTempo.value)
    // const senioridade = regexSenioridade.test(inputCandLevel.value)
    // const resumo = regexNomeResumo_e_Historia.test(inputCandResumo.value)

    // if (!(nome && cpf && fone && formacao && linkedin && portifolio && skills && xpEmp && xpCargo && xpTempo &&senioridade && resumo)){
    //     candSubmitButton.setAttribute("disabled", "disabled");
    //     setErrorFor(divs);
    // } else {
    //     candSubmitButton.removeAttribute("disabled");
    //     setSuccessFor(divs);
    // }
}

inputCandNome.addEventListener('input', validarDadosDoCandidato);

//falta qtdFunc e ramo
export function validarDadosEmpresa(){

    const validaNome = (nome: string) => {regexNomeResumo_e_Historia.test(nome)}
    const validaCNPJ = (cnpj: string) => {regexCNPJ.test(cnpj)}
    const validaFone = (fone: string) => {regexFone.test(fone)}
    const validaResumo = (resumo: string) => {regexNomeResumo_e_Historia.test(resumo)}
    const validaCEP = (cep: string) => {regexCEP.test(cep)}
}

export function validarVaga(){

}

export function validarSkill(){

}

function setErrorFor(input: Element) {
    const formGroup = input.parentElement;
    if (formGroup){
        formGroup.className = 'form-group error'
    }
}

function setSuccessFor(input: Element) {
    const formGroup = input.parentElement;
    if (formGroup){
        formGroup.className = 'form-group success'
    }
}
