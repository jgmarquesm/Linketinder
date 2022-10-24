package com.linketinder.utils

import com.linketinder.DAO.VagaDAO

class Vaga {

    String nome
    String descricao
    String senioridade
    String cidade
    int id_empresa

    void criar(VagaDAO vagaDAO){ vagaDAO.create(this)}

    static void listar(VagaDAO vagaDAO){vagaDAO.read(1)}
}
