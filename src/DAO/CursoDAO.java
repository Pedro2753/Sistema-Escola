/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CursoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet  rs;
    ArrayList<Curso> lista = new ArrayList<>();
    
 public void cadastrarCurso(Curso objcurso){
     String sql = "insert into curso (nome_curso, nivel, duracao) values (?, ?, ?)";
     conn = new Conexao().conectaBD();
     
     try {
         pstm = conn.prepareStatement(sql);
              pstm.setString(1, objcurso.getNome_curso());
     pstm.setString(2, objcurso.getNivel());
     pstm.setInt(3, objcurso.getDuracao());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO" + e);
         
     }
 }
 
 

    public ArrayList<Curso> PesquisarCurso(){
         String sql = "select * from curso";
         conn = new Conexao().conectaBD();
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             while(rs.next()){
                 Curso objcurso = new Curso();
                 objcurso.setId_curso(rs.getInt("id_curso"));
                 objcurso.setNome_curso(rs.getString("nome_curso"));
                 objcurso.setNivel(rs.getString("nivel"));
                 objcurso.setDuracao(rs.getInt("duracao"));
                 
                 lista.add(objcurso);
             }       
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "CursoDAO Pesquisar" + erro);
         }
         return lista;
         }
    
    public void AlterarCurso(Curso objcurso){
        String sql = "update curso set nome_curso = ?, nivel = ?, duracao = ? where id_curso = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, objcurso.getNome_curso());
     pstm.setString(2, objcurso.getNivel());
     pstm.setInt(3, objcurso.getDuracao());
     pstm.setInt(4, objcurso.getId_curso());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO alterar" + e);
         
     }
 }    
    
    public void ExcluirCurso(Curso objcurso){
        String sql = "delete from curso where id_curso = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setInt(1, objcurso.getId_curso());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO alterar" + e);
         
     }
 }    
    
     }
    
   




