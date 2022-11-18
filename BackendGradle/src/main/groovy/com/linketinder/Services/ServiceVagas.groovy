package com.linketinder.Services

import com.google.gson.Gson
import com.linketinder.Domain.Vaga
import static com.linketinder.Services.ServiceHabilidades.cadastrar

class ServiceVagas {

    static String listarTodas(){
        return new Gson().toJson(Vaga.listar())
    }

    static void cadastrarVaga(Map<String, Object> vagaJson){
        Vaga vaga = new Vaga()

        String nome = vagaJson.get("nome")
        String descricao = vagaJson.get("descricao")
        String senioridade = vagaJson.get("senioridade")
        String cidade = vagaJson.get("cidade")
        Integer id_empresa = Integer.parseInt(vagaJson.get("id_empresa").toString())
        Object habilidades = vagaJson.get("habilidades")

        vaga.nome = nome
        vaga.descricao = descricao
        vaga.senioridade = senioridade
        vaga.cidade = cidade
        vaga.id_empresa = id_empresa

        vaga.criar()
        habilidades.each {it -> cadastrar(it.toString(), vaga)}
    }
}
