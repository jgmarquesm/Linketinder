package com.linketinder.mocks.DAO

import com.linketinder.interfaces.DAO
import com.linketinder.mocks.usuarios.CandidatoMock
import static org.mockito.Mockito.*

class CandidatoDAOMock {

    static ArrayList<CandidatoMock> listaDeCandidatosMock = new ArrayList<>()

    static void criarMock() {
        DAO candidatoDAOMock = mock(DAO.class)

        Properties props = new Properties()
        props.put("nome", "Candidato")
        props.put("sobrenome", "Mock")
        props.put("cpf", "000000000000")
        props.put("telefone", "62900000000")
        props.put("resumo", "Candidato Mock Para testes unitários")
        props.put("linkedin", "linkedin.com/in/candidatoMock")
        props.put("portifolio", "portifolio.com/candidatoMock")
        props.put("formacao", "Mockagem")
        CandidatoMock candidatoMock = new CandidatoMock(props)

        when(candidatoDAOMock.create(candidatoMock)).thenReturn(listaDeCandidatosMock.add(candidatoMock))
        when(candidatoDAOMock.read(1)).thenReturn(listaDeCandidatosMock)
        when(candidatoDAOMock.read(2, 1)).thenReturn(candidatoMock.getProperty("cpf"))
        when(candidatoDAOMock.update("nome", "novo", 1)).thenReturn(candidatoMock.setProperty("nome", "1"))
        when(candidatoDAOMock.update("sobrenome", "novo", 1)).thenReturn(candidatoMock.setProperty("sobrenome", "2"))
        when(candidatoDAOMock.update("cpf", "novo", 1)).thenReturn(candidatoMock.setProperty("cpf", "3"))
        when(candidatoDAOMock.update("telefone", "novo", 1)).thenReturn(candidatoMock.setProperty("telefone", "4"))
        when(candidatoDAOMock.update("resumo", "novo", 1)).thenReturn(candidatoMock.setProperty("resumo", "5"))
        when(candidatoDAOMock.update("linkedin", "novo", 1)).thenReturn(candidatoMock.setProperty("linkedin", "6"))
        when(candidatoDAOMock.update("portifolio", "novo", 1)).thenReturn(candidatoMock.setProperty("portifolio", "7"))
        when(candidatoDAOMock.update("formacao", "novo", 1)).thenReturn(candidatoMock.setProperty("formacao", "8"))
        when(candidatoDAOMock.delete(1)).thenReturn(listaDeCandidatosMock.remove(candidatoMock))
    }
}
