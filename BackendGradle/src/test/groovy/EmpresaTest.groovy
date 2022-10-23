package test

import com.linketinder.usuarios.Empresa
import spock.lang.Specification

class EmpresaTest extends Specification {

    def "test Empresa toString" () {
        given:
            Empresa empresa = new Empresa(nome: "Empresa Teste", cnpj: "00000000000000", telefone: "0000000000",
            cep: "00000000", resumo: "blablabla", ramo: "Teste", qtdFunc: "00")
        when:
            empresa.toString()
            String resultadoEsperado = """
nome: Empresa Teste
CNPJ: 00000000000000
Telefone: 0000000000
Cep: 00000000
Descrição: blablabla
Atuação: Teste
Quantidade de funcionário: 00
               """
        then:
            empresa.toString().equals(resultadoEsperado)
    }
}
