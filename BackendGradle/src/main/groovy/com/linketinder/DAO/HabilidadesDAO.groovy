package com.linketinder.DAO

import com.linketinder.interfaces.SkillsDAO
import groovy.sql.Sql
import com.linketinder.usuarios.Candidato
import com.linketinder.utils.Vaga

import javax.swing.JOptionPane

class HabilidadesDAO implements SkillsDAO{

    static def url = 'jdbc:postgresql://localhost:5432/Linketinder'
    static def user = 'jgmarquesm'
    static def password = 'postgres'
    static def driver = 'org.postgresql.Driver'

    private static Sql conectar() { Sql sql = Sql.newInstance url, user, password, driver }
    private static void desconectar(connection) { connection.close() }

    @Override
    void createHabilidade(String competencia, int choice, def T){
        switch (choice){
            case 1 -> {
                try {
                    createHabilidadeCandidato(competencia, (T as Candidato))
                } catch (ClassCastException e){
                    e.cause
                    e.printStackTrace()
                }
            }
            case 2 -> {
                try {
                    createHabilidadeVaga(competencia, (T as Vaga))
                } catch (ClassCastException e){
                    e.cause
                    e.printStackTrace()
                }
            }
        }
    }

    static void createHabilidadeCandidato(String habilidade, Candidato c) {
        Sql create = conectar()
        String cpf = c.getCpf()
        create.query("SELECT c.id FROM candidatos AS c WHERE c.cpf = ${cpf}"){
            while (it.next()) {
                def id_candidato = it.getInt('id')
                ArrayList<String> lista_habilidades = new ArrayList<>()
                create.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato as hc, candidatos as c WHERE h.id = hc.id_habilidade AND hc.id_candidato = $id_candidato") {
                    while (it.next()) {
                        lista_habilidades.add(it.getString("habilidade"))
                    }
                }
                if (habilidade in lista_habilidades) {
                    String msg = JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                    break
                } else {
                    create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                    create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") {
                        while (it.next()){
                            def id_habilidade = it.getInt('id')
                            create.executeInsert("INSERT INTO habilidadescandidato (id_habilidade, id_candidato) VALUES ($id_habilidade, $id_candidato)")
                            break
                        }
                    }
                }
                lista_habilidades = []
            }
        }
        desconectar(create)
    }

   static void createHabilidadeVaga(String habilidade, Vaga v) {
        Sql create = conectar()
        String nome = v.getNome()
        int id_empresa = v.id_empresa
        create.query("SELECT v.id FROM vagas AS v WHERE v.nome = ${nome} AND v.id_empresa = ${id_empresa}"){
            while (it.next()) {
                def id_vaga = it.getInt('id')
                ArrayList<String> lista_habilidades = new ArrayList<>()
                create.query("SELECT h.habilidade FROM habilidades AS h, habilidadesvaga as hc, vagas as v WHERE h.id = hc.id_habilidade AND hc.id_vaga = $id_vaga") {
                    while (it.next()) {
                        lista_habilidades.add(it.getString("habilidade"))
                    }
                }
                if (habilidade in lista_habilidades) {
                    String msg = JOptionPane.showMessageDialog(null, "Habilidade já cadastrada.")
                    break
                } else {
                    create.executeInsert("INSERT INTO habilidades (habilidade) VALUES ($habilidade)")
                    create.query("SELECT h.id FROM habilidades AS h WHERE h.habilidade = $habilidade") {
                        while (it.next()){
                            def id_habilidade = it.getInt('id')
                            create.executeInsert("INSERT INTO habilidadesvaga (id_habilidade, id_vaga) VALUES ($id_habilidade, $id_vaga)")
                            break
                        }
                    }
                }
                lista_habilidades = []
            }
        }
        desconectar(create)
    }

    @Override
    void habilidadesCandidato(int id) {

        Sql readSkills = conectar()
        readSkills.query("SELECT h.habilidade FROM habilidades AS h, habilidadescandidato AS hc WHERE hc.id_habilidade = h.id AND hc.id_candidato = $id"){
            while(it.next()){
                String habilidade = it.getString('habilidade')
                printf "%s %n-----------------------%n", habilidade
            }
        }
        desconectar(readSkills)
    }
}
