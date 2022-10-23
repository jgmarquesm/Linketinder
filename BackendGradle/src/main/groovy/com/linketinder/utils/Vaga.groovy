package com.linketinder.utils

import com.linketinder.DAO.VagaDAO
import com.linketinder.interfaces.Vagas

class Vaga implements Vagas{

    String nome
    String descricao
    String senioridade
    String cidade
    int id_empresa

    @Override
    void criar(VagaDAO vagaDAO){
        vagaDAO.create(this)
    }

    @Override
    void listar(VagaDAO vagaDAO){
        vagaDAO.read(1)
    }
}
