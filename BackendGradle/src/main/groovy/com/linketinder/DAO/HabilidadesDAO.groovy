package com.linketinder.DAO

import com.linketinder.usuarios.User
import groovy.sql.Sql
import com.linketinder.usuarios.Candidato
import com.linketinder.utils.Vaga
import javax.swing.JOptionPane
import java.sql.SQLException

class HabilidadesDAO extends ClassDAO{

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
            Sql create = conectar()
            create.query("SELECT c.id FROM candidatos AS c WHERE c.cpf = ${c.getCpf()}") {
                while (it.next()) {
                    ArrayList<String> lista_habilidades = new ArrayList<>()
                    create.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato as hc, candidatos as c WHERE h.id = hc.id_habilidade AND hc.id_candidato = ${it.getInt('id')}") {
                        while (it.next()) { lista_habilidades.add(it.getString("habilidade"))}
                    }
                    if (habilidade in lista_habilidades) {
                        JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                        break
                    } else {
                        create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                        create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") {
                            while (it.next()) {
                                create.executeInsert("INSERT INTO habilidadescandidato (id_habilidade, id_candidato) VALUES (${it.getInt('id')}, ${it.getInt('id')})")
                                break
                            }
                        }
                    }
                    lista_habilidades = []
                }
            }
            desconectar(create)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }

   private static void createHabilidadeVaga(String habilidade, Vaga v) {
       try {
           Sql create = conectar()
           String nome = v.getNome()
           int id_empresa = v.id_empresa
           create.query("SELECT v.id FROM vagas AS v WHERE v.nome = ${nome} AND v.id_empresa = ${id_empresa}") {
               while (it.next()) {
                   int id_vaga = it.getInt('id')
                   ArrayList<String> lista_habilidades = new ArrayList<>()
                   create.query("SELECT h.habilidade FROM habilidades AS h, habilidadesvaga as hc, vagas as v WHERE h.id = hc.id_habilidade AND hc.id_vaga = $id_vaga") {
                       while (it.next()) {
                           lista_habilidades.add(it.getString("habilidade"))
                       }
                   }
                   if (habilidade in lista_habilidades) {
                       JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                       break
                   } else {
                       create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                       create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") {
                           while (it.next()) {
                               int id_habilidade = it.getInt('id')
                               create.executeInsert("INSERT INTO habilidadesvaga (id_habilidade, id_vaga) VALUES ($id_habilidade, $id_vaga)")
                               break
                           }
                       }
                   }
                   lista_habilidades = []
               }
           }
           desconectar(create)
       } catch(SQLException e) {
           e.printStackTrace()
           throw e
       }
   }

    static void habilidadesCandidato(int id) {
        try {
            Sql readSkills = conectar()
            readSkills.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato AS hc WHERE hc.id_habilidade = h.id AND hc.id_candidato = $id") {
                while (it.next()) {
                    String habilidade = it.getString('habilidade')
                    printf "%s %n-----------------------%n", habilidade
                }
            }
            desconectar(readSkills)
        } catch(SQLException e) {
            e.printStackTrace()
            throw e
        }
    }
}
