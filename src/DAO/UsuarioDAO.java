/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Usuario;
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
public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet  rs;
    ArrayList<Usuario> lista = new ArrayList<>();
    
    public ResultSet autenticacaoUsuario(Usuario objusuariodto){
        conn =  new Conexao().conectaBD();
        
        try {
          String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
          
          PreparedStatement pstm = conn.prepareStatement(sql);
          pstm.setString(1, objusuariodto.getNome_usuario());
          pstm.setString(2, objusuariodto.getSenha_usuario());
          
          ResultSet rs = pstm.executeQuery();
          return  rs;
        } catch (SQLException erro)  {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            return null; 
        }
    }
    
        
        public void cadastrarUsuario(Usuario usu){
     String sql = "insert into usuario (nome_usuario, senha_usuario, tipo) values (?, ?, ?)";
     conn = new Conexao().conectaBD();
     
     try {
         pstm = conn.prepareStatement(sql);
              pstm.setString(1, usu.getNome_usuario());
     pstm.setString(2, usu.getSenha_usuario());
     pstm.setString(3,usu.getTipo());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro CursoDAO" + e);
         
     }
 }
 
 

    public ArrayList<Usuario> PesquisarUsuario(){
         String sql = "select * from usuario";
         conn = new Conexao().conectaBD();
         try {
             pstm = conn.prepareStatement(sql);
             rs = pstm.executeQuery();
             while(rs.next()){
                 Usuario usu = new Usuario();
                 usu.setId_usuario(rs.getInt("id_usuario"));
                 usu.setNome_usuario(rs.getString("nome_usuario"));
                 usu.setSenha_usuario(rs.getString("senha_usuario"));
                 usu.setTipo(rs.getString("tipo"));
                 
                 lista.add(usu);
             }       
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "UsuarioDAO Pesquisar" + erro);
         }
         return lista;
         }
    
    public void AlterarUsuario(Usuario usu){
        String sql = "update usuario set nome_usuario = ?, senha_usuario = ?, tipo = ? where id_usuario = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setString(1, usu.getNome_usuario());
     pstm.setString(2, usu.getSenha_usuario());
     pstm.setString(3, usu.getTipo());
     pstm.setInt(4, usu.getId_usuario());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro UsuarioDAO alterar" + e);
         
     }
 }    
    
    public void ExcluirUsuario(Usuario usu){
        String sql = "delete from usuario where id_usuario = ?";
    conn = new Conexao().conectaBD();
     
     try {
     pstm = conn.prepareStatement(sql);
     pstm.setInt(1, usu.getId_usuario());
     
     pstm.execute();
     pstm.close();
    
     } catch (SQLException e) {
         
         JOptionPane.showMessageDialog(null,"Erro UsuarioDAO alterar" + e);
         
     }
 }    
}
