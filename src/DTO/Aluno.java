/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class Aluno {
    private int matricula, id_curso;
    private String nome_aluno, data_de_nascimento;

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }



    /**
     * @return the matricula
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nome_aluno
     */
    public String getNome_aluno() {
        return nome_aluno;
    }

    /**
     * @param nome_aluno the nome_aluno to set
     */
    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    /**
     * @return the data_de_nascimento
     */
    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    /**
     * @param data_de_nascimento the data_de_nascimento to set
     */
    public void setData_de_nascimento(String data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }
    
    
}
