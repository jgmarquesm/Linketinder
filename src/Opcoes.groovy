import javax.swing.JOptionPane

class Opcoes {

    static void opcoesCandidatos(ArrayList<Empresa> empresas){

        String emp = JOptionPane.showInputDialog("""Você deseja:
1- Listar empresas cadastradas.
2- Atualizar cadastro.
3- Voltar.""")

        switch (emp.toLowerCase(Locale.ROOT)) {
            case "1" -> listar(empresas)
            case "2" -> String msg = JOptionPane.showMessageDialog(null, "Desculpe, estamos trabalhando nisso.")
            case "3" -> App.rodando()
        }
        App.rodando()
    }

    static void opcoesEmpresas(ArrayList<Candidato> candidatos){

        String cand = JOptionPane.showInputDialog("""Você deseja:
1- Listar candidatos cadastrados.
2- Atualizar cadastro.
3- Voltar.""")

        switch (cand.toLowerCase(Locale.ROOT)) {
            case "1" -> listar(candidatos)
            case "2" -> String msg = JOptionPane.showMessageDialog(null, "Desculpe, estamos trabalhando nisso.")
            case "3" -> App.rodando()
        }
        App.rodando()
    }

    static void listar(ArrayList lista){
        lista.each {it -> println it}
    }
}
