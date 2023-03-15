/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.math.BigInteger;

/**
 *
 * @author Admin
 */
public class Professor {
    private int id;
    private String nome, data_de_nascimento;
    private int id_curso;

    public int getId() {
        return id;
    }

    /**
     * @return the cpf
     */
    public void setId(int id) { 
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the id_disciplina
     */

    
    
}
