package main

import main.DAO.CandidatoDAO
import main.DAO.EmpresaDAO
import main.DAO.HabilidadesDAO
import main.DAO.VagaDAO

import javax.swing.JOptionPane

class Opcoes {

    static void opcoesCandidatos(){
        String cpf = JOptionPane.showInputDialog("Digite seu CPF: (apenas números)")
        opcoesCand(CandidatoDAO.readCPF(cpf))
    }

    static void opcoesCand(int id){

        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar vagas cadastradas.
2 - Listar minhas habilidades.
3 - Atualizar cadastro.
4 - Apagar conta.
5 - Voltar.""")

        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> VagaDAO.readAll()
            case "2" -> HabilidadesDAO.listarHabilidadesCandidato(id)
            case "3" -> atualizarCadastroCandidato(id)
            case "4" -> CandidatoDAO.delete(id)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizarCadastroCandidato(int id){
        String campo = JOptionPane.showInputDialog('''Qual campo deseja atualizar?
1 - Nome
2 - Sobrenome
3 - CPF
4 - Telefone
5 - Resumo
6 - Linkedin
7 - Portifolio
8 - Formação
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")

        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> CandidatoDAO.update("nome", valor, id)
            case "2" -> CandidatoDAO.update("sobrenome", valor, id)
            case "3" -> CandidatoDAO.update("cpf", valor, id)
            case "4" -> CandidatoDAO.update("telefone", valor, id)
            case "5" -> CandidatoDAO.update("resumo", valor, id)
            case "6" -> CandidatoDAO.update("linkedin", valor, id)
            case "7" -> CandidatoDAO.update("portifolio", valor, id)
            case "8" -> CandidatoDAO.update("formacao", valor, id)
        }
    }

    static void opcoesEmpresas(){
        String cnpj = JOptionPane.showInputDialog("Digite seu CNPJ: (apenas números)")
        opcoesEmp(EmpresaDAO.readCNPJ(cnpj))
    }

    static void opcoesEmp(int id){

        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar Candidatos cadastrados.
2 - Atualizar cadastro.
3 - Gerenciar vagas.
4 - Apagar conta.
5 - Voltar.""")

        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> CandidatoDAO.readAll()
            case "2" -> atualizarCadastroEmpresa(id)
            case "3" -> gerenciarVagas(id)
            case "4" -> EmpresaDAO.delete(id)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizarCadastroEmpresa(int id){
        String campo = JOptionPane.showInputDialog('''Qual campo deseja atualizar?
1 - Nome
2 - CNPJ
3 - Telefone
4 - CEP
5 - Resumo
6 - Ramo de Atuação
7 - Quantidade de funcionários
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")

        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> EmpresaDAO.update("nome", valor, id)
            case "2" -> EmpresaDAO.update("cnpj", valor, id)
            case "3" -> EmpresaDAO.update("telefone", valor, id)
            case "4" -> EmpresaDAO.update("cep", valor, id)
            case "5" -> EmpresaDAO.update("resumo", valor, id)
            case "6" -> EmpresaDAO.update("ramo", valor, id)
            case "7" -> EmpresaDAO.update("quantidade_funcionario", valor, id)
        }
        App.rodando()
    }

    static void atualizarCadastroVagas() {
        String id_str = JOptionPane.showInputDialog("Id da vaga: ")
        int id = id_str.toInteger()
        String campo = JOptionPane.showInputDialog('''Qual campo deseja atualizar?
1 - Nome.
2 - Descrição.
3 - Senioridade.
4 - Cidade.
5 - Voltar.
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")

        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> VagaDAO.update("nome", valor, id)
            case "2" -> VagaDAO.update("descricao", valor, id)
            case "3" -> VagaDAO.update("senioridade", valor, id)
            case "4" -> VagaDAO.update("cidade", valor, id)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void gerenciarVagas(int id) {
        String vag = JOptionPane.showInputDialog('''Gerenciar Vagas:
1 - Listar Vagas Cadastradas.
2 - Cadastrar Vaga.
3 - Atualizar Vaga.
4 - Apagar Vaga.
5 - Voltar.
''')

        switch (vag.toLowerCase(Locale.ROOT)) {
            case "1" -> VagaDAO.readAll()
            case "3" -> Cadastro.novaVaga(id)
            case "2" -> atualizarCadastroVagas()
            case "4" -> {
                String id_vaga_str = JOptionPane.showInputDialog("ID da vaga:")
                int id_vaga = id_vaga_str.toInteger()
                VagaDAO.delete(id_vaga)
            }
            case "5" -> App.rodando()
        }
        App.rodando()
    }
}
