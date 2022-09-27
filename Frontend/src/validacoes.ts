const regexNome: RegExp = /(?=^.{2,60}$)^(?:[^_\\][A-ù]\s?)+$/;
const regexCPF: RegExp = /(?:\d{3}\.?){3}-?\d{2}/;
const regexFone: RegExp = /(?:\(?\d{2,3}\)?\s?\d\s?)?\d{4,9}.?\d{4}?/;
const regexFormacao: RegExp = /fund|med|tec|sup|posgrad|mest|doc|posdoc/;
const regexLinkedin: RegExp = /(https?\:\/\/)?(www\.)?linkedin.com\/in\/[\w]+\//;
const regexPortifolio: RegExp = /(?:https?\:\/\/)?(?:www\.)?\w+\.\w{2,}(?:\.\w{2,})*(?:\/[\w]+)*(?:\/)?/;
const regexSkills: RegExp = /(\w*,?\s?)*/;
const regexXpCandidatoEmp: RegExp = /\w*/;
const regexXpCandidatoCargo: RegExp = /\w*/;
const regexXpCandidatoTempo: RegExp = /[^-](?<= )(\d{2,3})/;
const regexLevelCandidato: RegExp = /est|trn|jr|pl|sr|esp/;
const regexResumo: RegExp = /(\w*\s?)*/;


export const validaNome = (nome: string) => {regexNome.test(nome)}
export const validaCPF = (cpf: string) => {regexCPF.test(cpf)}
export const validaFone = (fone: string) => {regexFone.test(fone)}
export const validaFormacao = (formacao: string) => {regexFormacao.test(formacao)}
export const validaLinkedin = (linkedin: string) => {regexLinkedin.test(linkedin)}
export const validaPortifolio = (portifolio: string) => {regexPortifolio.test(portifolio)}
export const validaSkills = (skills: string) => {regexSkills.test(skills)}
export const validaXpEmp = (empresa: string) => {regexXpCandidatoEmp.test(empresa)}
export const validaXpCargo = (cargo: string) => {regexXpCandidatoCargo.test(cargo)}
export const validaXpTempo = (tempo: string) => {regexXpCandidatoTempo.test(tempo)}
export const validaLevelCandidato = (level: string) => {regexLevelCandidato.test(level)}
export const validaResumo = (resumo: string) => {regexResumo.test(resumo)}



