class Empresa {

    private String nome
    private String emailCorporativo
    private String cnpj
    private String pais
    private String estado
    private String cep
    private String descricao
    private ArrayList<String> competencias = new ArrayList<>()

    void addCompetencia(ArrayList<String> comps){
        comps.each(it -> competencias.add(it))
    }

    @Override
    String toString() {
        return """
nome: $nome
email: $emailCorporativo
CNPJ: $cnpj
País: $pais
Estado: $estado
Cep: $cep
Descrição: $descricao
Competencias desejadas: $competencias
               """
    }

}
