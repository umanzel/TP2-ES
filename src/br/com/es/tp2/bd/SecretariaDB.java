/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Secretaria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class SecretariaDB implements DB<Secretaria> {

    @Override
    public void inserir(Secretaria secretaria) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO SECRETARIA (NOME, CPF, IDUSUARIO) VALUES (?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, secretaria.getNome());
        ps.setString(2, secretaria.getCpf());
        ps.setInt(3, secretaria.getIdusuario());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Secretaria secretaria) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE SECRETARIA SET NOME=?, CPF=?, IDUSUARIO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, secretaria.getNome());
        ps.setString(2, secretaria.getCpf());
        ps.setInt(3, secretaria.getIdusuario());
        ps.setInt(4, secretaria.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Secretaria secretaria) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM SECRETARIA WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, secretaria.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Secretaria> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM SECRETARIA";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaSecretaria = new ArrayList();
        while (rs.next()) {
            Secretaria secretaria = new Secretaria();
            secretaria.setCodigo(rs.getInt("CODIGO"));
            secretaria.setNome(rs.getString("NOME"));
            secretaria.setCpf(rs.getString("CPF"));
            secretaria.setIdusuario(rs.getInt("IDUSUARIO"));
            listaSecretaria.add(secretaria);
        }

        return listaSecretaria;
    }

    @Override
    public Secretaria recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM SECRETARIA WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Secretaria secretaria = new Secretaria();
        while (rs.next()) {
            secretaria.setCodigo(rs.getInt("CODIGO"));
            secretaria.setNome(rs.getString("NOME"));
            secretaria.setCpf(rs.getString("CPF"));
            secretaria.setIdusuario(rs.getInt("IDUSUARIO"));
        }

        return secretaria;
    }

}
