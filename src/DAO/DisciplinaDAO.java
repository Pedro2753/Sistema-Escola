/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import DTO.Disciplina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DisciplinaDAO {
     Connection conn;
    PreparedStatement pstm;
    ResultSet  rs;
    ArrayList<Disciplina> lista = new ArrayList<>();
    
     public void cadastrarDisciplina(Disciplina objdisciplina){
     String sql = "insert into disciplina (nome_disciplina, id_curso) values (?, ?)";
     conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, objdisciplina.getNome_disciplina());
     pstm.setInt(2, objdisciplina.getId_curso());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro DisciplinaDAO" + e);
         
     }
 }
     
     public ArrayList<Disciplina> PesquisarDisciplina(){
         String sql = "select * from Disciplina";
         conn = new Conexao().conectaBD();
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             while(rs.next()){
                 Disciplina objdisciplina = new Disciplina();
                 objdisciplina.setId_disciplina(rs.getInt("id_disciplina"));
                 objdisciplina.setNome_disciplina(rs.getString("nome_disciplina"));
                 objdisciplina.setId_curso(rs.getInt("id_curso"));
                 
                 lista.add(objdisciplina);
             }       
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "DisciplinaDAO Pesquisar" + erro);
         }
         return lista;
         }
     
     public void AlterarDisciplina(Disciplina objdisciplina){
        String sql = "update disciplina set nome_disciplina = ?, id_curso = ? where id_disciplina = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, objdisciplina.getNome_disciplina());
     pstm.setInt(2, objdisciplina.getId_curso());
     pstm.setInt(3, objdisciplina.getId_disciplina());
   
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO alterar" + e);
         
     }
 } 
     public void ExcluirDisciplina(Disciplina objdisciplina){
        String sql = "delete from disciplina where id_disciplina = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setInt(1, objdisciplina.getId_disciplina());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro DisciplinaDAO alterar" + e);
         
     }
 }
    
        public ResultSet listarCurso(){
       conn = new Conexao().conectaBD();
       String sql = "SELECT * FROM curso ORDER BY nome_curso";
       
       try{
           pstm = conn.prepareStatement(sql);
           return pstm.executeQuery();
       }catch (SQLException e){
           JOptionPane.showMessageDialog(null,"Erro listarCurso / DisciplinaDAO" + e);
           return null;
       }
    }
}


