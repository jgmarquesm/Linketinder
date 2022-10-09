package main

class Candidato {

    String nome
    String sobrenome
    String cpf
    String telefone
    String resumo
    String linkedin
    String portifolio
    String formacao

    @Override
    String toString() {
        return """
Nome: $nome
Sobrenome: $sobrenome
CPF: $cpf
Telefone: $telefone
Resumo: $resumo
Linkedin: $linkedin
Portifólio: $portifolio
Formação: $formacao
           """
    }
}
