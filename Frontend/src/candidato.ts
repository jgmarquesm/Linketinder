export class Candidato {
    
     constructor(public nomeCandidato: string, public cpf: string, public telefone: string,
        public linkedin: string, public portifolio: string, public skill: string, public level: string,
        public xp: string, public resumo: string){}

    toString(): string {
        return `"nomeCandidato": ${this.nomeEmpresa},
        "cpf": ${this.cpf},
        "fone": ${this.telefone},
        "linkedin": ${this.linkedin},
        "portifolio": ${this.portifolio},
        "skill": ${this.skill},
        "level": ${this.level},
        "xp": ${this.xp},
        "resumo": ${this.resumo}
        `
    }

    retornoAPI(): JSON {
        return JSON.parse(this.toString());
    }
    
}
