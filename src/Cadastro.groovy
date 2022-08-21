import javax.swing.JOptionPane

class Cadastro {

    static Candidato cadastroCandidato() {

        ArrayList<String> competencias = new ArrayList<>()

        String nome = JOptionPane.showInputDialog("Nome:")
        String email = JOptionPane.showInputDialog("E-mail:")
        String cpf = JOptionPane.showInputDialog("CPF:")

        String idadeStr = JOptionPane.showInputDialog("Idade:")
        byte idade = idadeStr.toInteger() as byte

        String estado = JOptionPane.showInputDialog("Estado:")
        String cep = JOptionPane.showInputDialog("CEP:")
        String descricao = JOptionPane.showInputDialog("Descrição Pessoal:")

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            competencias.add(competencia)
            sair = competencia
        }

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")

        Candidato novoCandidatoCadastrado = new Candidato(nome: nome, email: email, cpf: cpf,
                idade: idade, estado: estado, cep: cep, descricao: descricao)

        novoCandidatoCadastrado.addCompetencia(competencias)

        App.rodando()
        novoCandidatoCadastrado
    }

    static Empresa cadastroEmpresa() {

        ArrayList<String> competencias = new ArrayList<>()

        String nome = JOptionPane.showInputDialog("Nome:")
        String email = JOptionPane.showInputDialog("E-mail Corporativo:")
        String cnpj = JOptionPane.showInputDialog("CNPJ:")
        String pais = JOptionPane.showInputDialog("País:")
        String estado = JOptionPane.showInputDialog("Estado:")
        String cep = JOptionPane.showInputDialog("CEP:")
        String descricao = JOptionPane.showInputDialog("Descrição da empresa:")

        String sair = JOptionPane.showInputDialog("""Digite:
\'Nova\' para cadastrar uma competencia desejada.
\'Fim\' para finalizar o cadastro.""")

        while(!sair.equalsIgnoreCase("fim")) {
            String competencia = JOptionPane.showInputDialog("Competência:\n \'Fim\' para finalizar o cadastro.")
            competencias.add(competencia)
            sair = competencia
        }

        String msg = JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.")

        Empresa novaEmpresaCadastrada = new Empresa(nome: nome, emailCorporativo: email, cnpj: cnpj,
                pais: pais, estado: estado, cep: cep, descricao: descricao)

        novaEmpresaCadastrada.addCompetencia(competencias)

        App.rodando()
        novaEmpresaCadastrada
    }
}
