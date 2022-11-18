package com.linketinder.Services

import com.google.gson.Gson
import com.linketinder.Domain.Candidato

import static com.linketinder.Services.ServiceHabilidades.cadastrar

class ServiceCandidatos {

    static String listarTodos(){
        return new Gson().toJson(Candidato.listar())
    }

    static void cadastrarCandidato(Map<String, Object> candidatoJson){
        Candidato candidato = new Candidato()

        String nome = candidatoJson.get("nome")
        String sobrenome = candidatoJson.get("sobrenome")
        String cpf = candidatoJson.get("cpf")
        String telefone = candidatoJson.get("telefone")
        String resumo = candidatoJson.get("resumo")
        String linkedin = candidatoJson.get("linkedin")
        String portifolio = candidatoJson.get("portifolio")
        String formacao = candidatoJson.get("formacao")
        Object habilidades = candidatoJson.get("habilidades")

        candidato.nome = nome
        candidato.sobrenome = sobrenome
        candidato.cpf = cpf
        candidato.telefone = telefone
        candidato.resumo = resumo
        candidato.linkedin = linkedin
        candidato.portifolio = portifolio
        candidato.formacao = formacao

        candidato.criar()
        habilidades.each {it -> cadastrar(it.toString(), candidato)}
    }
}
