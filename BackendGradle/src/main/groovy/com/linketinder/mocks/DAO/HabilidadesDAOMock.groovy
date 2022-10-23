package com.linketinder.mocks.DAO

import com.linketinder.interfaces.SkillsDAO
import com.linketinder.mocks.usuarios.CandidatoMock
import com.linketinder.mocks.utils.VagaMock

import static org.mockito.Mockito.*

class HabilidadesDAOMock {

    static ArrayList<String> habilidadesCandidato = ["Skill1", "Skill2", "Skill3"]
    static ArrayList<String> habilidadesVaga = ["Skill1", "Skill2", "Skill3", "Skill4"]

    static void criarMock(){
        SkillsDAO habilidadesDAOMock = mock(SkillsDAO.class)
        when(habilidadesDAOMock.createHabilidade("competencia", 1, CandidatoMock.criarMock())).
                thenReturn(habilidadesCandidato.add("competencia"))
        when(habilidadesDAOMock.createHabilidade("competencia", 2, VagaMock.criarMock())).
                thenReturn(habilidadesVaga.add("competencia"))
        when(habilidadesDAOMock.habilidadesCandidato(1)).thenReturn(habilidadesCandidato)
    }
}
