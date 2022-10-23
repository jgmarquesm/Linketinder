package com.linketinder.mocks.usuarios

import com.linketinder.DAO.CandidatoDAO
import com.linketinder.DAO.HabilidadesDAO
import com.linketinder.interfaces.DAO
import com.linketinder.interfaces.SkillsDAO
import com.linketinder.interfaces.UsuarioCandidato
import com.linketinder.mocks.DAO.CandidatoDAOMock
import com.linketinder.mocks.DAO.HabilidadesDAOMock

import static org.mockito.Mockito.*

class CandidatoMock {

    private static DAO candidatoDAOMock = new CandidatoDAOMock() as DAO
    static SkillsDAO habilidadesDAO = new HabilidadesDAOMock() as SkillsDAO

    static void criarMock() {
        UsuarioCandidato candidatoMock = mock(UsuarioCandidato.class)
        when(candidatoMock.criar(candidatoDAOMock as CandidatoDAO)).thenReturn(candidatoDAOMock.create(candidatoMock))
        when(candidatoMock.listar(candidatoDAOMock as CandidatoDAO)).thenReturn(candidatoDAOMock.read(1))
        when(candidatoMock.listarHabilidades(habilidadesDAO as HabilidadesDAO, 1)).thenReturn(HabilidadesDAOMock.habilidadesCandidato)
    }
}