package com.linketinder.Services

import com.linketinder.Model.DAO.HabilidadesDAO

import javax.swing.JOptionPane

class ServiceHabilidades {

    static void cadastrar(String competencia, def T){
        HabilidadesDAO.create(competencia, T)
    }
}
