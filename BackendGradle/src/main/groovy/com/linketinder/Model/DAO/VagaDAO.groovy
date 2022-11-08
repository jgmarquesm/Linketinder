package com.linketinder.Model.DAO

import static com.linketinder.Model.DAO.utils.utilsVaga.listarMinhasVagas

class VagaDAO extends ClassDAO{

    static void read(int id_empresa){
        listarMinhasVagas(id_empresa, conexaoDB)
    }
}
