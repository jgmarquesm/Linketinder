package com.linketinder.interfaces

import com.linketinder.DAO.CandidatoDAO
import com.linketinder.DAO.HabilidadesDAO

interface UsuarioCandidato {
    void criar(CandidatoDAO candidatoDAO)
    void listar(CandidatoDAO candidatoDAO)
    void listarHabilidades(HabilidadesDAO habilidadesDAO, int id)
}