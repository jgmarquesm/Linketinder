package com.linketinder.View


import com.linketinder.Services.Opcoes

import javax.swing.JOptionPane

class App {
    static void rodando(){
        String inicio = JOptionPane.showInputDialog("""Você é...
1 - Um(a) Candidato(a).
2 - Um Empresa.
3 - Sair
""")
        switch (inicio.toLowerCase(Locale.ROOT)){
            case "1" -> Opcoes.authCandidato()
            case "2" -> Opcoes.authEmpresa()
            case "3" -> {System.exit(0)}
        }
    }
}
