package com.linketinder.Model.DAO

import groovy.sql.Sql
import com.linketinder.Domain.Candidato
import com.linketinder.Domain.Vaga
import javax.swing.JOptionPane
import java.sql.SQLException

class HabilidadesDAO extends ClassDAO {

    static void create(String competencia, def T){
        if (T instanceof Candidato){
            createHabilidadeCandidato(competencia, T)
        } else if (T instanceof Vaga) {
            createHabilidadeVaga(competencia, T)
        } else {
            throw new Exception("Opção não disponível. Revise a implementação! Método HabilidadeDAO.create(String competencia, def T). " +
                    "<T extends ${Candidato.class} & ${Vaga.class}> e você tentou implementar para ${T}")
        }
    }

    private static void createHabilidadeCandidato(String habilidade, Candidato c) {
        try {
            Sql create = conexaoDB.conectar()
            create.query("SELECT c.id FROM candidatos AS c WHERE c.cpf = ${c.getCpf()}") {candidato ->
                while (candidato.next()) {
                    ArrayList<String> lista_habilidades = new ArrayList<>()
                    create.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato as hc, candidatos as c WHERE h.id = hc.id_habilidade AND hc.id_candidato = ${candidato.getInt('id')}") {skillVerify ->
                        while (skillVerify.next()) { lista_habilidades.add(skillVerify.getString("habilidade"))}
                    }
                    if (habilidade in lista_habilidades) {
                        JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                        break
                    } else {
                        create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                        create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") {putSkill ->
                            while (putSkill.next()) {
                                create.executeInsert("INSERT INTO habilidadescandidato (id_habilidade, id_candidato) VALUES (${putSkill.getInt('id')}, ${candidato.getInt('id')})")
                                break
                            }
                        }
                    }
                    lista_habilidades = []
                }
            }
            conexaoDB.desconectar(create)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

   private static void createHabilidadeVaga(String habilidade, Vaga v) {
       try {
           Sql create = conexaoDB.conectar()
           String nome = v.getNome()
           int id_empresa = v.id_empresa
           create.query("SELECT v.id FROM vagas AS v WHERE v.nome = ${nome} AND v.id_empresa = ${id_empresa}") {vaga ->
               while (vaga.next()) {
                   ArrayList<String> lista_habilidades = new ArrayList<>()
                   create.query("SELECT h.habilidade FROM habilidades AS h, habilidadesvaga as hc, vagas as v WHERE h.id = hc.id_habilidade AND hc.id_vaga = ${vaga.getInt('id')}") { skillVerify ->
                       while (skillVerify.next()) {
                           lista_habilidades.add(skillVerify.getString("habilidade"))
                       }
                   }
                   if (habilidade in lista_habilidades) {
                       JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                       break
                   } else {
                       create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                       create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") { putSkill ->
                           while (putSkill.next()) {
                               create.executeInsert("INSERT INTO habilidadesvaga (id_habilidade, id_vaga) VALUES (${putSkill.getInt('id')}, ${vaga.getInt('id')})")
                               break
                           }
                       }
                   }
                   lista_habilidades = []
               }
           }
           conexaoDB.desconectar(create)
       } catch(SQLException e) {
           e.printStackTrace()
           throw e
       }
   }

    static void habilidadesCandidato(int id) {
        try {
            Sql readSkills = conexaoDB.conectar()
            readSkills.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato AS hc WHERE hc.id_habilidade = h.id AND hc.id_candidato = $id") {
                while (it.next()) {
                    String habilidade = it.getString('habilidade')
                    printf "%s %n-----------------------%n", habilidade
                }
            }
            conexaoDB.desconectar(readSkills)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
