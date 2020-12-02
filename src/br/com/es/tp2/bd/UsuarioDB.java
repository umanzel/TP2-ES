/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class UsuarioDB implements DB<Usuario> {

    @Override
    public void inserir(Usuario user) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO USUARIO (LOGIN, SENHA, PERFIL, NOME, CPF, ENDERECO, TELEFONE, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getSenha());
        ps.setInt(3, user.getPerfil());
        ps.setString(4, user.getNome());
        ps.setString(5, user.getCpf());
        ps.setString(6, user.getEndereco());
        ps.setString(7, user.getTelefone());
        ps.setString(8, user.getEmail());        
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Usuario user) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE USUARIO SET LOGIN=?, SENHA=?, PERFIL=?, NOME=?, CPF=?, ENDERECO=?, TELEFONE=?, EMAIL=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getSenha());
        ps.setInt(3, user.getPerfil());
        ps.setString(4, user.getNome());
        ps.setString(5, user.getCpf());
        ps.setString(6, user.getEndereco());
        ps.setString(7, user.getTelefone());
        ps.setString(8, user.getEmail());
        ps.setInt(9, user.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Usuario user) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM USUARIO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, user.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM USUARIO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
//LOGIN=?, SENHA=?, PERFIL=?, NOME=?, CPF=?, ENDERECO=?, TELEFONE=?, EMAIL=? WHERE CODIGO=?
        ArrayList listaUsuarios = new ArrayList();
        while (rs.next()) {
            Usuario user = new Usuario();
            user.setCodigo(rs.getInt("CODIGO"));
            user.setLogin(rs.getString("LOGIN"));
            user.setSenha(rs.getString("SENHA"));
            user.setPerfil(rs.getInt("PERFIL"));
            user.setNome(rs.getString("NOME"));
            user.setCpf(rs.getString("CPF"));
            user.setEndereco(rs.getString("ENDERECO"));
            user.setTelefone(rs.getString("TELEFONE"));
            user.setEmail(rs.getString("EMAIL"));

            listaUsuarios.add(user);
        }

        return listaUsuarios;
    }

    @Override
    public Usuario recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM USUARIO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Usuario user = new Usuario();

        while (rs.next()) {
            user.setCodigo(rs.getInt("CODIGO"));
            user.setLogin(rs.getString("LOGIN"));
            user.setSenha(rs.getString("SENHA"));
            user.setPerfil(rs.getInt("PERFIL"));
            user.setNome(rs.getString("NOME"));
            user.setCpf(rs.getString("CPF"));
            user.setEndereco(rs.getString("ENDERECO"));
            user.setTelefone(rs.getString("TELEFONE"));
            user.setEmail(rs.getString("EMAIL"));

        }
        return user;
    }

}
