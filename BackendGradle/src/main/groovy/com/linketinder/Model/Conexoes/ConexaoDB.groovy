package com.linketinder.Model.Conexoes

import groovy.sql.Sql

interface ConexaoDB {

    Sql conectar()
    void desconectar(Sql connection)
}