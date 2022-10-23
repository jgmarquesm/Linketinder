package com.linketinder.utils

import com.linketinder.DAO.HabilidadesDAO
import com.linketinder.interfaces.Skills

import javax.swing.JOptionPane

class Habilidades implements Skills{

    @Override
    void cadastrar(HabilidadesDAO habilidadesDAO, int choice, def T){

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            if (!competencia.equalsIgnoreCase("fim")) {
                new HabilidadesDAO().createHabilidade(competencia, choice, T)
            }
            sair = competencia
        }

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
    }
}
