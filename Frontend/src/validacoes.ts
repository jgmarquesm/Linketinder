// Input Candidato
const inputCandNome = document.querySelector('#cad-cand-nome') as HTMLInputElement;
const inputCandCPF = document.querySelector('#cad-cand-cpf') as HTMLInputElement;
const inputCandFone = document.querySelector('#cad-cand-fone') as HTMLInputElement;
const inputCandFormacao = document.querySelector('#cad-cand-formacao') as HTMLInputElement;
const inputCandLinkedin = document.querySelector('#cad-cand-linkedin') as HTMLInputElement;
const inputCandPortifolio = document.querySelector('#cad-cand-port') as HTMLInputElement;
const inputCandSkills = document.querySelector('#cad-cand-skills') as HTMLInputElement;
const inputCandLevel = document.querySelector('#cad-cand-level') as HTMLInputElement;
const inputCandXPEmp = document.querySelector('#cad-cand-last-xp-emp') as HTMLInputElement;
const inputCandXPCargo = document.querySelector('#cad-cand-last-xp-cargo') as HTMLInputElement;
const inputCandXPTempo = document.querySelector('#cad-cand-last-xp-tempo') as HTMLInputElement;
const inputCandResumo = document.querySelector('#cad-cand-resumo') as HTMLInputElement;
const candSubmitButton = document.querySelector('#cad-cand') as HTMLInputElement;

// Input Empresa
const inputEmpNome = document.querySelector('#cad-emp-nome') as HTMLInputElement;
const inputEmpCNPJ = document.querySelector('#cad-emp-cnpj') as HTMLInputElement;
const inputEmpFone = document.querySelector('#cad-emp-fone') as HTMLInputElement;
const inputEmpCEP = document.querySelector('#cad-emp-cep') as HTMLInputElement;
const inputEmpResumo = document.querySelector('#cad-emp-historia') as HTMLInputElement;
const inputEmpRamo = document.querySelector('#cad-emp-ramo') as HTMLInputElement;
const inputEmpQtdFunc = document.querySelector('#cad-emp-qtd-func') as HTMLInputElement;
const empSubmitButton = document.querySelector('#cad-emp') as HTMLInputElement;

// Input Vaga
const inputVagaNome = document.querySelector('#cad-vaga-nome') as HTMLInputElement;
const inputVagaDep = document.querySelector('#cad-vaga-dep') as HTMLInputElement;
const inputVagaSkills = document.querySelector('#cad-vaga-skill') as HTMLInputElement;
const inputVagaDesc = document.querySelector('#cad-vaga-desc') as HTMLInputElement;
const inputVagaLevel = document.querySelector('#cad-vaga-level') as HTMLInputElement;
const vagaSubmitButton = document.querySelector('#cad-vaga') as HTMLInputElement;

// Input Skill
const inputSkillNew = document.querySelector('#cad-skill-nome') as HTMLInputElement;
const skillSubmitButton = document.querySelector('#cad-skill')as HTMLInputElement;

// Regex
const regexNomeResumo_e_Historia: RegExp = /(?:[^_\\][A-ù]{1,60}\s?)+/;
const regexCPF: RegExp = /(?<=\b)(?:\d{3}\.?){3}-?\d{2}/;
const regexCNPJ: RegExp = /(?<=\b)\d{2}\.?(?:\d{3}\.?){2}\/?\d{4}-?\d{2}/;
const regexFone: RegExp = /(?<=\b)(?:\(?\d{2,3}\)?\s?\d\s?)?\d{4,9}.?\d{4}?/;
const regexFormacao: RegExp = /fund|med|tec|sup|posgrad|mest|doc|posdoc/;
const regexLinkedin: RegExp = /(https?\:\/\/)?(www\.)?linkedin.com\/in\/[\w]+\//;
const regexPortifolio: RegExp = /(?:https?\:\/\/)?(?:www\.)?\w+\.\w{2,}(?:\.\w{2,})*(?:\/[\w]+)*(?:\/)?/;
const regexSkillsDescXP_e_Ramo: RegExp = /[^ ](\w*[,\s]?)*/;
const regex_XpTempo_e_qtdFunc: RegExp = /(?<=^)(\d{1,3})/;
const regexSenioridade: RegExp = /est|trn|jr|pl|sr|esp/;
const regexCEP: RegExp = /(?<=\b)\d{2}\.?\d{3}\-?\d{3}/;

export default function validarDadosDoCandidato() {

    candSubmitButton.disabled = true;

    inputCandNome.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputCandNome.value), e.currentTarget, candSubmitButton)
    }
    

    inputCandCPF.oninput = (e: any) => {
        validar(regexCPF.test(inputCandCPF.value), e.currentTarget, candSubmitButton)
    }

    inputCandFone.oninput = (e: any) => {
        validar(regexFone.test(inputCandFone.value), e.currentTarget, candSubmitButton)
    }
    
    inputCandFormacao.onchange = (e: any) => {
        validar(regexFormacao.test(inputCandFormacao.value), e.currentTarget, candSubmitButton)
    }

    inputCandLinkedin.oninput = (e: any) => {
        validar(regexLinkedin.test(inputCandLinkedin.value), e.currentTarget, candSubmitButton)
    }

    inputCandPortifolio.oninput = (e: any) => {
        validar(regexPortifolio.test(inputCandPortifolio.value), e.currentTarget, candSubmitButton)
    }

    inputCandSkills.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputCandSkills.value), e.currentTarget, candSubmitButton)
    }

    inputCandXPEmp.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputCandXPEmp.value), e.currentTarget, candSubmitButton)
    }

    inputCandXPCargo.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputCandXPCargo.value), e.currentTarget, candSubmitButton)
    }

    inputCandXPTempo.oninput = (e: any) => {
        validar(regex_XpTempo_e_qtdFunc.test(inputCandXPTempo.value), e.currentTarget, candSubmitButton)
    }

    inputCandLevel.onchange = (e: any) => {
        validar(regexSenioridade.test(inputCandLevel.value), e.currentTarget, candSubmitButton)
    }

    inputCandResumo.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputCandResumo.value), e.currentTarget, candSubmitButton)
    }
}

//falta qtdFunc e ramo
export function validarDadosEmpresa(){

    empSubmitButton.disabled = true;

    inputEmpNome.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputEmpNome.value), e.currentTarget, empSubmitButton)
    }

    inputEmpCNPJ.oninput = (e: any) => {
        validar(regexCNPJ.test(inputEmpCNPJ.value), e.currentTarget, empSubmitButton)
    }

    inputEmpFone.oninput = (e: any) => {
        validar(regexFone.test(inputEmpFone.value), e.currentTarget, empSubmitButton)
    }

    inputEmpResumo.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputEmpResumo.value), e.currentTarget, empSubmitButton)
    }

    inputEmpQtdFunc.oninput = (e: any) => {
        validar(regex_XpTempo_e_qtdFunc.test(inputEmpQtdFunc.value), e.currentTarget, empSubmitButton)
    }

    inputEmpCEP.oninput = (e: any) => {
        validar(regexCEP.test(inputEmpCEP.value), e.currentTarget, empSubmitButton)
    }

    inputEmpRamo.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputEmpRamo.value), e.currentTarget, empSubmitButton)
    }
}

export function validarVaga(){

    vagaSubmitButton.disabled = true;

    inputVagaNome.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputVagaNome.value), e.currentTarget, vagaSubmitButton)
    }

    inputVagaDep.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputVagaDep.value), e.currentTarget, vagaSubmitButton)
    }

    inputVagaDesc.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputVagaDesc.value), e.currentTarget, vagaSubmitButton)
    }

    inputVagaLevel.oninput = (e: any) => {
        validar(regexSenioridade.test(inputVagaLevel.value), e.currentTarget, vagaSubmitButton)
    }

    inputVagaSkills.oninput = (e: any) => {
        validar(regexSkillsDescXP_e_Ramo.test(inputVagaSkills.value), e.currentTarget, vagaSubmitButton)
    }
}

export function validarSkill(){

    skillSubmitButton.disabled = true;

    inputSkillNew.oninput = (e: any) => {
        validar(regexNomeResumo_e_Historia.test(inputSkillNew.value), e.currentTarget, skillSubmitButton)
    }
}

function validar(regexTest: boolean, input: any, button: HTMLInputElement) {
    if (!regexTest){
        input.parentElement.classList.remove('success');
        input.parentElement.classList.add('error');
        button.disabled = true;
    } else {
        input.parentElement.classList.remove('error');
        input.parentElement.classList.add('success');
        button.disabled = false;
    }
}
