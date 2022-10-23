package com.linketinder.interfaces

interface DAO {
    void create(def t)
    void read(def ... args)
    void update(String campo, String valor, int id)
    void delete(int id)
}