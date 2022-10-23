package com.linketinder.utils

import com.linketinder.usuarios.Candidato
import com.linketinder.usuarios.Empresa
import javax.swing.JOptionPane

class App {

    static void rodando(){

        String inicio = JOptionPane.showInputDialog("""Você é...
1 - Um(a) Candidato(a).
2 - Um Empresa.
3 - Quero me cadastrar como candidato.
4 - Quero me cadastrar como empresa.
5 - Sair
""")

        switch (inicio.toLowerCase(Locale.ROOT)){
            case "1" -> Opcoes.authCandidato()
            case "2" -> Opcoes.authEmpresa()
            case "3" -> {
                String nome = JOptionPane.showInputDialog("Nome:")
                String sobrenome = JOptionPane.showInputDialog("Sobrenome:")
                String cpf = JOptionPane.showInputDialog("CPF:")
                String telefone = JOptionPane.showInputDialog("Telefone:")
                String resumo = JOptionPane.showInputDialog("Resumo:")
                String linkedin = JOptionPane.showInputDialog("Linkedin:")
                String portifolio = JOptionPane.showInputDialog("Portifolio:")
                String formacao = JOptionPane.showInputDialog("Formação:")

                Candidato candidato = new Candidato(nome: nome, sobrenome: sobrenome, cpf: cpf,
                        telefone: telefone, resumo: resumo, linkedin: linkedin, portifolio: portifolio, formacao: formacao)

                Cadastro.novoCandidato(candidato)
            }
            case "4" -> {
                String nome = JOptionPane.showInputDialog("Nome:")
                String cnpj = JOptionPane.showInputDialog("CNPJ:")
                String telefone = JOptionPane.showInputDialog("Telefone:")
                String cep = JOptionPane.showInputDialog("CEP:")
                String resumo = JOptionPane.showInputDialog("Resumo:")
                String ramo = JOptionPane.showInputDialog("Ramo de Atuação:")
                String qtdFunc = JOptionPane.showInputDialog("Quantidade de funcionários:")

                Empresa empresa = new Empresa(nome: nome, cnpj: cnpj, telefone: telefone, cep: cep, resumo: resumo,
                        ramo: ramo, qtdFunc: qtdFunc)

                Cadastro.novaEmpresa(empresa)
            }
            case "5" -> {System.exit(0)}
        }
    }
}
