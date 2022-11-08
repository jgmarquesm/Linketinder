package com.linketinder.Controller

import com.linketinder.Domain.Candidato
import com.linketinder.Domain.Empresa
import com.linketinder.Domain.Habilidades
import com.linketinder.Domain.Vaga
import com.linketinder.View.App

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
