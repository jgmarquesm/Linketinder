package com.linketinder.Services

import com.linketinder.Domain.Empresa

class ServiceEmpresas {

    static void cadastrarEmpresa(Map<String, Object> empresaJson){
        Empresa empresa = new Empresa()

        String nome = empresaJson.get("nome")
        String cnpj = empresaJson.get("cnpj")
        String telefone = empresaJson.get("telefone")
        String cep = empresaJson.get("cep")
        String resumo = empresaJson.get("resumo")
        String ramo = empresaJson.get("ramo")
        String qtdFunc = empresaJson.get("qtdFunc")

        empresa.nome = nome
        empresa.cnpj = cnpj
        empresa.telefone = telefone
        empresa.cep = cep
        empresa.resumo = resumo
        empresa.ramo = ramo
        empresa.qtdFunc = qtdFunc

        empresa.criar()
    }
}
