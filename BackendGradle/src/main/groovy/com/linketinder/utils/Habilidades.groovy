package com.linketinder.utils

import com.linketinder.DAO.HabilidadesDAO

import javax.swing.JOptionPane

class Habilidades {

    static void cadastrar(HabilidadesDAO habilidadesDAO, int choice, def T){

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            if (!competencia.equalsIgnoreCase("fim")) {
                new HabilidadesDAO().create(competencia, choice, T)
            }
            sair = competencia
        }

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
    }
}
