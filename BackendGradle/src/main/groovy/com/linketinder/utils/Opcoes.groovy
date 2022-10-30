package com.linketinder.utils

import com.linketinder.DAO.*
import com.linketinder.usuarios.*

import javax.swing.JOptionPane

class Opcoes {

    static void authCandidato(){
        String cpf = JOptionPane.showInputDialog("Digite seu CPF: (apenas números)")
        opcoesCandidato(CandidatoDAO.read("candidatos", "cpf", cpf))
    }

    static void authEmpresa(){
        String cnpj = JOptionPane.showInputDialog("Digite seu CNPJ: (apenas números)")
        opcoesEmpresa(EmpresaDAO.read("empresas", "cnpj", cnpj))
    }

    static void opcoesCandidato(int ID){
        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar vagas cadastradas
2 - Listar minhas habilidades
3 - Atualizar cadastro
4 - Apagar conta
5 - Voltar
6 - Sair""")
        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> Vaga.listar()
            case "2" -> Candidato.listarHabilidades(ID)
            case "3" -> atualizarCadastroCandidato(ID)
            case "4" -> apagar(new CandidatoDAO(), "candidatos", ID)
            case "5" -> App.rodando()
            case "6" -> System.exit(0)
        }
        opcoesCandidato(ID)
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
9 - Voltar
10 - Sair
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")
        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> atualizar(new CandidatoDAO(),"candidatos","nome", valor, ID)
            case "2" -> atualizar(new CandidatoDAO(),"candidatos","sobrenome", valor, ID)
            case "3" -> atualizar(new CandidatoDAO(),"candidatos","cpf", valor, ID)
            case "4" -> atualizar(new CandidatoDAO(),"candidatos","telefone", valor, ID)
            case "5" -> atualizar(new CandidatoDAO(),"candidatos","resumo", valor, ID)
            case "6" -> atualizar(new CandidatoDAO(),"candidatos","linkedin", valor, ID)
            case "7" -> atualizar(new CandidatoDAO(),"candidatos","portifolio", valor, ID)
            case "8" -> atualizar(new CandidatoDAO(),"candidatos","formacao", valor, ID)
            case "9" -> opcoesCandidato(ID)
            case "10" -> {System.exit(0)}
        }
        atualizarCadastroCandidato(ID)
    }

    static void opcoesEmpresa(int ID){
        String emp = JOptionPane.showInputDialog("""Você deseja:
1 - Listar Candidatos cadastrados
2 - Atualizar cadastro
3 - Gerenciar vagas
4 - Apagar conta
5 - Voltar
6 - Sair""")
        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> Candidato.listar()
            case "2" -> atualizarCadastroEmpresa(ID)
            case "3" -> gerenciarVagas(ID)
            case "4" -> apagar(new EmpresaDAO(), "empresas", ID)
            case "5" -> App.rodando()
            case "6" -> {System.exit(0)}
        }
        opcoesEmpresa(ID)
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
8 - Voltar
9 - Sair
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")
        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> atualizar(new EmpresaDAO(),"empresas", "nome", valor, ID)
            case "2" -> atualizar(new EmpresaDAO(),"empresas","cnpj", valor, ID)
            case "3" -> atualizar(new EmpresaDAO(),"empresas","telefone", valor, ID)
            case "4" -> atualizar(new EmpresaDAO(),"empresas","cep", valor, ID)
            case "5" -> atualizar(new EmpresaDAO(),"empresas","resumo", valor, ID)
            case "6" -> atualizar(new EmpresaDAO(),"empresas","ramo", valor, ID)
            case "7" -> atualizar(new EmpresaDAO(),"empresas","quantidade_funcionario", valor, ID)
            case "8" -> opcoesEmpresa(ID)
            case "9" -> {System.exit(0)}
        }
        atualizarCadastroEmpresa(ID)
    }

    static void gerenciarVagas(int ID) {
        String vag = JOptionPane.showInputDialog('''Gerenciar Vagas:
1 - Listar Vagas Cadastradas
2 - Cadastrar Vaga
3 - Atualizar Vaga
4 - Apagar Vaga
5 - Voltar
6 - Sair
''')
        switch (vag.toLowerCase(Locale.ROOT)) {
            case "1" -> Empresa.listarMinhasVagas(ID)
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
                apagar(new VagaDAO(), "vagas", idVaga)
            }
            case "5" -> opcoesEmpresa(ID)
            case "6" -> {System.exit(0)}
        }
    }

    static void atualizarCadastroVagas(int ID) {
        String campo = JOptionPane.showInputDialog('''Qual campo deseja atualizar?
1 - Nome
2 - Descrição
3 - Senioridade
4 - Cidade
5 - Voltar
6 - Sair
''')
        String valor = JOptionPane.showInputDialog("Novo valor: ")
        switch (campo.toLowerCase(Locale.ROOT)) {
            case "1" -> atualizar(new VagaDAO(), "vagas", "nome", valor, ID)
            case "2" -> atualizar(new VagaDAO(), "vagas","descricao", valor, ID)
            case "3" -> atualizar(new VagaDAO(), "vagas","senioridade", valor, ID)
            case "4" -> atualizar(new VagaDAO(), "vagas","cidade", valor, ID)
            case "5" -> gerenciarVagas(ID)
            case "6" -> {System.exit(0)}
        }
        atualizarCadastroVagas(ID)
    }

    static void atualizar(ClassDAO classeDAO, String tabela, String campo, String valor, int id){
        classeDAO.update(tabela, campo, valor, id)
    }

    static void apagar(ClassDAO classeDAO, String tabela, int id) { classeDAO.delete(tabela, id) }
}
