package com.linketinder.usuarios

import com.linketinder.DAO.CandidatoDAO
import com.linketinder.DAO.HabilidadesDAO

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

    void criar(CandidatoDAO candidatoDAO) {candidatoDAO.create(this)}

    static void listar(CandidatoDAO candidatoDAO) {candidatoDAO.read(1)}

    static void listarHabilidades(HabilidadesDAO habilidadesDAO, int id) {habilidadesDAO.habilidadesCandidato(id)}
}
