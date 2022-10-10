package com.linketinder

import javax.swing.JOptionPane

class App {

    static void rodando(){

        String inicio = JOptionPane.showInputDialog("""Você é...
1- Um(a) Candidato(a).
2- Um Empresa.
3- Quero me cadastrar como candidato.
4- Quero me cadastrar como empresa.""")

        switch (inicio.toLowerCase(Locale.ROOT)){
            case "1" -> Opcoes.opcoesCandidatos()
            case "2" -> Opcoes.opcoesEmpresas()
            case "3" -> Cadastro.novoCandidato()
            case "4" -> Cadastro.novaEmpresa()
        }
    }
}
