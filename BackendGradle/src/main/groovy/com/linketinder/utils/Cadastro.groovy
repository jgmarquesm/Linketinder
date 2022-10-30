package com.linketinder.utils

import com.linketinder.DAO.*
import com.linketinder.usuarios.Candidato
import com.linketinder.usuarios.Empresa

import javax.swing.JOptionPane

class Cadastro {

    static void novoCandidato(Candidato candidato) {
        candidato.criar()
        Habilidades.cadastrar(candidato)
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaEmpresa(Empresa empresa) {
        empresa.criar()
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaVaga(Vaga vaga){
        vaga.criar()
        Habilidades.cadastrar(vaga)
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }
}
