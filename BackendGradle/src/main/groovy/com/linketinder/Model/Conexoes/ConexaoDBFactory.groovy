package com.linketinder.Model.Conexoes

import com.linketinder.Model.Conexoes.ConexaoDB
import com.linketinder.Model.Conexoes.ConexaoPostgreSQL
import com.linketinder.Model.utils.BDSuportados

abstract class ConexaoDBFactory {
    private ConexaoDBFactory() {}

    static ConexaoDB conectar(BDSuportados db) {
        switch (db) {
            case "POSTGRESQL":
                return new ConexaoPostgreSQL();
            default:
                throw new RuntimeException("Banco não existe");
        }
    }

}
