package com.linketinder.Domain

interface User {
   void criar()
   List<Object> getColunas()
   String getSqlCreateStatement()
}