package com.linketinder.utils


import com.linketinder.DAO.*
import com.linketinder.usuarios.Candidato
import com.linketinder.usuarios.Empresa

import javax.swing.JOptionPane

class Cadastro {

    static void novoCandidato(Candidato candidato) {

        candidato.criar(new CandidatoDAO())
        new Habilidades().cadastrar(new HabilidadesDAO(), 1, candidato)

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaEmpresa(Empresa empresa) {

        empresa.criar(new EmpresaDAO())
        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaVaga(Vaga vaga){

        vaga.criar(new VagaDAO())
        new Habilidades().cadastrar(new HabilidadesDAO(), 2, vaga)

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }
}
