export class Vaga {

    constructor(public nomeVaga: string, public departamento: string, public senioridade: string,
        public requiredSkills: string, public descricao: string){}

    toString(): string {
        return `"nomeVaga": ${this.nomeVaga},
"dep": ${this.departamento},
"skills": ${[this.requiredSkills]},
"desc": ${this.descricao},
"level": ${this.senioridade}`
    }

    retornoAPI(): JSON {

        return JSON.parse(this.toString());
    }
    
}