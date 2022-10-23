package com.linketinder.interfaces

import com.linketinder.DAO.VagaDAO

interface Vagas {
    void criar(VagaDAO vagaDAO)
    void listar(VagaDAO vagaDAO)
}