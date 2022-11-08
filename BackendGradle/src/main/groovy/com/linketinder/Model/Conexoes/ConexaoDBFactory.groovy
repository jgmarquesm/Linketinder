package com.linketinder.Model.Conexoes

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
