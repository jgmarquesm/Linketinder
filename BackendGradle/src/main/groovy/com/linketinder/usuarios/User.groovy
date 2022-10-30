package com.linketinder.usuarios

interface User {
   void criar()
   List<Object> getColunas()
   String getSqlCreateStatement()
}