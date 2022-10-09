package main

import main.DAO.CandidatoDAO
import main.DAO.EmpresaDAO
import main.DAO.HabilidadesDAO
import main.DAO.VagaDAO

import javax.swing.JOptionPane

class Cadastro {

    static void novoCandidato() {

        String nome = JOptionPane.showInputDialog("Nome:")
        String sobrenome = JOptionPane.showInputDialog("Sobrenome:")
        String cpf = JOptionPane.showInputDialog("CPF:")
        String telefone = JOptionPane.showInputDialog("Telefone:")
        String resumo = JOptionPane.showInputDialog("Resumo:")
        String linkedin = JOptionPane.showInputDialog("Linkedin:")
        String portifolio = JOptionPane.showInputDialog("Portifolio:")
        String formacao = JOptionPane.showInputDialog("Formação:")

        Candidato novoCandidato = new Candidato(nome: nome, sobrenome: sobrenome, cpf: cpf,
                telefone: telefone, resumo: resumo, linkedin: linkedin, portifolio: portifolio, formacao: formacao)

        CandidatoDAO.create(novoCandidato)

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            if (!competencia.equalsIgnoreCase("fim")) {
                HabilidadesDAO.createHabilidadeCandidato(competencia, novoCandidato)
            }
            sair = competencia
        }

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaEmpresa() {

        String nome = JOptionPane.showInputDialog("Nome:")
        String cnpj = JOptionPane.showInputDialog("CNPJ:")
        String telefone = JOptionPane.showInputDialog("Telefone:")
        String cep = JOptionPane.showInputDialog("CEP:")
        String resumo = JOptionPane.showInputDialog("Resumo:")
        String ramo = JOptionPane.showInputDialog("Ramo de Atuação:")
        String qtdFunc = JOptionPane.showInputDialog("Quantidade de funcionários:")

        Empresa novaEmpresa = new Empresa(nome: nome, cnpj: cnpj, telefone: telefone, cep: cep, resumo: resumo,
                ramo: ramo, qtdFunc: qtdFunc)

        EmpresaDAO.create(novaEmpresa)

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }

    static void novaVaga(int id){
        String nome = JOptionPane.showInputDialog("Nome:")
        String descricao = JOptionPane.showInputDialog("Descrição:")
        String senioridade = JOptionPane.showInputDialog("Senioridade:")
        String cidade = JOptionPane.showInputDialog("Cidade:")
        int id_empresa = id

        Vaga novaVaga = new Vaga(nome: nome, descricao: descricao, senioridade: senioridade, cidade: cidade, id_empresa: id_empresa)

        VagaDAO.create(novaVaga)

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")
        App.rodando()
    }
}
