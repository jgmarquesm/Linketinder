package com.linketinder.Domain

import com.linketinder.Model.DAO.HabilidadesDAO

import javax.swing.JOptionPane

class Habilidades {

    static void cadastrar(def T){

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            if (!competencia.equalsIgnoreCase("fim")) {
                HabilidadesDAO.create(competencia, T)
            }
            sair = competencia
        }
    }
}
