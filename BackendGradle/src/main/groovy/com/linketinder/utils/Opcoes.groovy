package com.linketinder.utils


import com.linketinder.DAO.*
import com.linketinder.usuarios.Candidato
import com.linketinder.usuarios.Empresa

import javax.swing.JOptionPane

class Opcoes {

    static void authCandidato(){
        String cpf = JOptionPane.showInputDialog("Digite seu CPF: (apenas números)")
        opcoesCandidato(CandidatoDAO.readCPF(cpf))
    }

    static void authEmpresa(){
        String cnpj = JOptionPane.showInputDialog("Digite seu CNPJ: (apenas números)")
        opcoesEmpresa(EmpresaDAO.readCNPJ(cnpj))
    }

    static void opcoesCandidato(int ID){

        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar vagas cadastradas.
2 - Listar minhas habilidades.
3 - Atualizar cadastro.
4 - Apagar conta.
5 - Voltar.""")

        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> new Vaga().listar(new VagaDAO())
            case "2" -> new Candidato().listarHabilidades(new HabilidadesDAO(), ID)
            case "3" -> atualizarCadastroCandidato(ID)
            case "4" -> apagar(CandidatoDAO, ID)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizarCadastroCandidato(int ID){
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
            case "1" -> atualizar(CandidatoDAO,"nome", valor, ID)
            case "2" -> atualizar(CandidatoDAO,"sobrenome", valor, ID)
            case "3" -> atualizar(CandidatoDAO,"cpf", valor, ID)
            case "4" -> atualizar(CandidatoDAO,"telefone", valor, ID)
            case "5" -> atualizar(CandidatoDAO,"resumo", valor, ID)
            case "6" -> atualizar(CandidatoDAO,"linkedin", valor, ID)
            case "7" -> atualizar(CandidatoDAO,"portifolio", valor, ID)
            case "8" -> atualizar(CandidatoDAO,"formacao", valor, ID)
        }
    }

    static void opcoesEmpresa(int ID){

        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar Candidatos cadastrados.
2 - Atualizar cadastro.
3 - Gerenciar vagas.
4 - Apagar conta.
5 - Voltar.""")

        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> new Candidato().listar(new CandidatoDAO())
            case "2" -> atualizarCadastroEmpresa(ID)
            case "3" -> gerenciarVagas(ID)
            case "4" -> apagar(EmpresaDAO, ID)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizarCadastroEmpresa(int ID){
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
            case "1" -> atualizar(EmpresaDAO,"nome", valor, ID)
            case "2" -> atualizar(EmpresaDAO,"cnpj", valor, ID)
            case "3" -> atualizar(EmpresaDAO,"telefone", valor, ID)
            case "4" -> atualizar(EmpresaDAO,"cep", valor, ID)
            case "5" -> atualizar(EmpresaDAO,"resumo", valor, ID)
            case "6" -> atualizar(EmpresaDAO,"ramo", valor, ID)
            case "7" -> atualizar(EmpresaDAO,"quantidade_funcionario", valor, ID)
        }
        App.rodando()
    }

    static void gerenciarVagas(int ID) {
        String vag = JOptionPane.showInputDialog('''Gerenciar Vagas:
1 - Listar Vagas Cadastradas.
2 - Cadastrar Vaga.
3 - Atualizar Vaga.
4 - Apagar Vaga.
5 - Voltar.
''')

        switch (vag.toLowerCase(Locale.ROOT)) {
            case "1" -> Empresa.listarMinhasVagas(new VagaDAO(), ID)
            case "2" -> {
                String nome = JOptionPane.showInputDialog("Nome:")
                String descricao = JOptionPane.showInputDialog("Descrição:")
                String senioridade = JOptionPane.showInputDialog("Senioridade:")
                String cidade = JOptionPane.showInputDialog("Cidade:")
                int ID_EMPRESA = ID

                Vaga vaga = new Vaga(nome: nome, descricao: descricao, senioridade: senioridade, cidade: cidade, id_empresa: ID_EMPRESA)

                Cadastro.novaVaga(vaga)
            }
            case "3" -> {
                String id_vaga = JOptionPane.showInputDialog("ID da vaga:")
                int idVaga = id_vaga.toInteger()
                atualizarCadastroVagas(idVaga)
            }
            case "4" -> {
                String id_vaga = JOptionPane.showInputDialog("ID da vaga:")
                int idVaga = id_vaga.toInteger()
                apagar(VagaDAO, idVaga)
            }
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizarCadastroVagas(int ID) {
        String campo = JOptionPane.showInputDialog('''Qual campo deseja atualizar?
1 - Nome.
2 - Descrição.
3 - Senioridade.
4 - Cidade.
5 - Voltar.
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")

        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> atualizar(VagaDAO,"nome", valor, ID)
            case "2" -> atualizar(VagaDAO,"descricao", valor, ID)
            case "3" -> atualizar(VagaDAO,"senioridade", valor, ID)
            case "4" -> atualizar(VagaDAO,"cidade", valor, ID)
            case "5" -> App.rodando()
        }
        App.rodando()
    }

    static void atualizar(Class<?> classeDAO, String campo, String valor, int id){
        classeDAO.update(campo, valor, id)
    }

    static void apagar(Class<?> classeDAO, int id) {
        classeDAO.delete(id)
    }
}
