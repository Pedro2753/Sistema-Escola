/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Aluno;
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
public class AlunoDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet  rs;
    ArrayList<Aluno> lista = new ArrayList<>();
    
    public void cadastrarAluno(Aluno objaluno){
     String sql = "insert into aluno (nome_aluno, data_de_nascimento, id_curso) values (?, ?, ?)";
     conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, objaluno.getNome_aluno());
     pstm.setString(2, objaluno.getData_de_nascimento());
     pstm.setInt(3, objaluno.getId_curso());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro AlunoDAO" + e);
         
     }
 }
 
 

    public ArrayList<Aluno> PesquisarAluno(){
         String sql = "select * from aluno";
         conn = new Conexao().conectaBD();
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             while(rs.next()){
                 Aluno objaluno = new Aluno();
                 objaluno.setMatricula(rs.getInt("matricula"));
                 objaluno.setNome_aluno(rs.getString("nome_aluno"));
                 objaluno.setData_de_nascimento(rs.getString("data_de_nascimento"));
                 objaluno.setId_curso(rs.getInt("id_curso"));
                 
                 lista.add(objaluno);
             }       
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "alunoDAO Pesquisar" + erro);
         }
         return lista;
         }
    
    public void AlterarAluno(Aluno objaluno){
        String sql = "update aluno set nome_aluno = ?, data_de_nascimento = ?, id_curso = ? where matricula = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, objaluno.getNome_aluno());
     pstm.setString(2, objaluno.getData_de_nascimento());
     pstm.setInt(3, objaluno.getId_curso());
     pstm.setInt(4, objaluno.getMatricula());
   
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO alterar" + e);
         
     }
 }    
    
    public void ExcluirAluno(Aluno objaluno){
        String sql = "delete from aluno where matricula = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setInt(1, objaluno.getMatricula());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO alterar" + e);
         
     }
 }
    
        public ResultSet listarCurso(){
       conn = new Conexao().conectaBD();
       String sql = "SELECT * FROM curso ORDER BY nome_curso";
       
       try{
           pstm = conn.prepareStatement(sql);
           return pstm.executeQuery();
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null,"Erro listarCurso / AlunoDAO" + e);
           return null;
       }
    }
}

