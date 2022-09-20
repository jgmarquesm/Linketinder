export class Empresa {

    constructor(public nomeEmpresa: string, public cnpj: string, public telefone: string,
        public cep: string, public resumo: string, public ramo: string, public qtdFunc: number){}

    toString(): string {
        return `{"nomeEmpresa": "${this.nomeEmpresa}",
"cnpj": "${this.cnpj}",
"fone": "${this.telefone}",
"cep": "${this.cep}",
"resumo": "${this.resumo}",
"ramo": "${this.ramo}",
"qtdFunc": "${this.qtdFunc}"}`
    }

    retornoAPI(): JSON {
        return JSON.parse(this.toString());
    }
    
}