import javax.swing.JOptionPane

class App {
    @SuppressWarnings('GroovyAssignabilityCheck')
    static void rodando(){

        ArrayList<Candidato> candidatos = new ArrayList<>()
        ArrayList<Empresa> empresas = new ArrayList<>()
        ArrayList<String> comps = new ArrayList<>()
        comps.add("Java")
        comps.add("Python")
        comps.add("Angular")
        comps.add("Groovy")
        comps.add("Git")

        Candidato c1 = new Candidato(nome: "Cadidato 1", email: "cadidato1@acelerazg.com.br", cpf: "11111111111",
                idade: 1, estado: "Goiás", cep: "11111111", descricao: "Candidato1", competencias: comps)
        candidatos.add(c1)
        Candidato c2 = new Candidato(nome: "Cadidato 2", email: "cadidato2@acelerazg.com.br", cpf: "22222222222",
                idade: 2, estado: "Goiás", cep: "22222222", descricao: "Candidato2", competencias: comps)
        candidatos.add(c2)
        Candidato c3 = new Candidato(nome: "Cadidato 3", email: "cadidato3@acelerazg.com.br", cpf: "33333333333",
                idade: 3, estado: "Goiás", cep: "33333333", descricao: "Candidato3", competencias: comps)
        candidatos.add(c3)
        Candidato c4 = new Candidato(nome: "Cadidato 4", email: "cadidato4@acelerazg.com.br", cpf: "44444444444",
                idade: 4, estado: "Goiás", cep: "44444444", descricao: "Candidato4", competencias: comps)
        candidatos.add(c4)
        Candidato c5 = new Candidato(nome: "Cadidato 5", email: "cadidato5@acelerazg.com.br", cpf: "55555555555",
                idade: 5, estado: "Goiás", cep: "55555555", descricao: "Candidato5", competencias: comps)
        candidatos.add(c5)

        Empresa e1 = new Empresa(nome: "Empresa 1", emailCorporativo: "empresa1@acelerazg.com.br", cnpj: "11111111111111",
                pais: "Brasil", estado: "Goiás", cep: "11111111", descricao: "Empresa1", competencias: comps)
        empresas.add(e1)
        Empresa e2 = new Empresa(nome: "Empresa 2", emailCorporativo: "empresa2@acelerazg.com.br", cnpj: "22222222222222",
                pais: "Brasil", estado: "Goiás", cep: "22222222", descricao: "Empresa2", competencias: comps)
        empresas.add(e2)
        Empresa e3 = new Empresa(nome: "Empresa 3", emailCorporativo: "empresa3@acelerazg.com.br", cnpj: "33333333333333",
                pais: "Brasil", estado: "Goiás", cep: "33333333", descricao: "Empresa3", competencias: comps)
        empresas.add(e3)
        Empresa e4 = new Empresa(nome: "Empresa 4", emailCorporativo: "empresa4@acelerazg.com.br", cnpj: "44444444444444",
                pais: "Brasil", estado: "Goiás", cep: "44444444", descricao: "Empresa4", competencias: comps)
        empresas.add(e4)
        Empresa e5 = new Empresa(nome: "Empresa 5", emailCorporativo: "empresa5@acelerazg.com.br", cnpj: "55555555555555",
                pais: "Brasil", estado: "Goiás", cep: "55555555", descricao: "Empresa5", competencias: comps)
        empresas.add(e5)

        String inicio = JOptionPane.showInputDialog("""Você é...
1- Um(a) candidato(a).
2- Um empresa.
3- Quero me cadastrar como candidato.
4- Quero me cadastrar como empresa.""")

        switch (inicio.toLowerCase(Locale.ROOT)){
            case "1" -> Opcoes.opcoesCandidatos(empresas)
            case "2" -> Opcoes.opcoesEmpresas(candidatos)
            case "3" -> {
                Candidato novoCandidato = Cadastro.cadastroCandidato()
                candidatos.add(novoCandidato)
            }
            case "4" -> {
                Empresa novaEmpresa = Cadastro.cadastroEmpresa()
                empresas.add(novaEmpresa)
            }
        }
    }
}
