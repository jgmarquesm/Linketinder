export class Candidato {

    public listadeHabilidades = this.skill.split(", ");

    constructor(public nomeCandidato: string, public cpf: string, public telefone: string,
        public formacao: string, public linkedin: string, public portifolio: string, 
        public skill: string, public xpEmpresa: string, public xpCargo: string, 
        public xpTempo: string, public level: string, public resumo: string){}

    toString(): string {
        return `{"nomeCandidato": "${this.nomeCandidato}",
"cpf": "${this.cpf}",
"fone": "${this.telefone}",
"formacao": "${this.formacao}",
"linkedin": "${this.linkedin}",
"portifolio": "${this.portifolio}",
"skill": "${this.skill}",
"level": "${this.level}",
"xpEmpresa": "${this.xpEmpresa}",
"xpCargo": "${this.xpCargo}",
"xpTempo": "${this.xpTempo}",
"resumo": "${this.resumo}"}`
    }

    retornoAPI(): JSON {
        return JSON.parse(this.toString());
    }

    habilidades(): string[] { 
        return this.listadeHabilidades;
    }

    addHabilidade(hab: string): void {
        this.listadeHabilidades.push(hab);
    }

}
