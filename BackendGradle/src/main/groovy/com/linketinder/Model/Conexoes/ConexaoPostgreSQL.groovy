package com.linketinder.Model.Conexoes

import groovy.sql.Sql

class ConexaoPostgreSQL implements ConexaoDB{

    @Override
    Sql conectar() {
        String url = 'jdbc:postgresql://localhost:5432/Linketinder'
        String user = 'jgmarquesm'
        String password = 'postgres'
        String driver = 'org.postgresql.Driver'
        Sql sql = Sql.newInstance url, user, password, driver
        sql
    }

    @Override
    void desconectar(Sql connection) {connection.close()}
}
