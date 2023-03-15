/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Curso {
    private int id_curso;
    private String nome_curso, nivel;
    private int duracao;

    /**
     * @return the id_curso
     */
    public int getId_curso() {
        return id_curso;
    }

    /**
     * @param id_curso the id_curso to set
     */
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the nome_curso
     */
    public String getNome_curso() {
        return nome_curso;
    }

    /**
     * @param nome_curso the nome_curso to set
     */
    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
}
