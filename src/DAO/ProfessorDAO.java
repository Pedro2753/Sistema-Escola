/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Professor;
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
public class ProfessorDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet  rs;
    ArrayList<Professor> lista = new ArrayList<>();
            
            public void cadastrarProfessor(Professor prof){
     String sql = "insert into professor (nome, data_de_nascimento, id_curso) values (?, ?, ?)";
     conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, prof.getNome());
     pstm.setString(2, prof.getData_de_nascimento());
     pstm.setInt(3, prof.getId_curso());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro AlunoDAO" + e);
         
     }
 }
             public ArrayList<Professor> PesquisarProfessor(){
         String sql = "select * from professor";
         conn = new Conexao().conectaBD();
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             while(rs.next()){
                 Professor prof = new Professor();
                 prof.setId(rs.getInt("id"));
                 prof.setNome(rs.getString("nome"));
                 prof.setData_de_nascimento(rs.getString("data_de_nascimento"));
                 prof.setId_curso(rs.getInt("id_curso"));
                 
                 lista.add(prof);
             }       
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "ProfessorDAO Pesquisar" + erro);
         }
         return lista;
         }
             
              public void AlterarProfessor(Professor prof){
        String sql = "update professor set nome = ?, data_de_nascimento = ?, id_curso = ? where id = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, prof.getNome());
     pstm.setString(2, prof.getData_de_nascimento());
     pstm.setInt(3, prof.getId_curso());
     pstm.setInt(4, prof.getId());
   
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro ProfessorDAO alterar" + e);
         
     }
 }    
              public void ExcluirProfessor(Professor prof){
        String sql = "delete from professor where id = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setInt(1, prof.getId());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro ProfessorDAO excluir" + e);
         
     }
 }
    
        public ResultSet listarCurso(){
       conn = new Conexao().conectaBD();
       String sql = "SELECT * FROM curso ORDER BY nome_curso";
       
       try{
           pstm = conn.prepareStatement(sql);
           return pstm.executeQuery();
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null,"Erro listarCurso / ProfessorDAO" + e);
           return null;
       }
    }
}


