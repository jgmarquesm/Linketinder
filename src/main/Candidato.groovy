package main

class Candidato {

    private String nome
    private String email
    private String cpf
    private int idade
    private String estado
    private String cep
    private String descricao
    private ArrayList<String> competencias = new ArrayList<>()

    ArrayList<String> getCompetencias() {
        return competencias
    }

    void addCompetencia(ArrayList<String> comps){
        comps.each(it -> competencias.add(it))
    }

    @Override
    String toString() {
        return """
nome: $nome
email: $email
CPF: $cpf
Idade: $idade
Estado: $estado
Cep: $cep
Descrição: $descricao
Competencias: $competencias
           """
    }
}
