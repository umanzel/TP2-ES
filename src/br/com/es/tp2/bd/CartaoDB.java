/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Cartao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class CartaoDB implements DB<Cartao> {

    @Override
    public void inserir(Cartao cartao) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO CARTAO (NUMERO, VALIDADE, CODCARTAO, NOME, BANDEIRA) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cartao.getNumero());
        ps.setString(2, cartao.getValidade());
        ps.setInt(3, cartao.getCodigocartao());
        ps.setString(4, cartao.getNome());
        ps.setString(5, cartao.getBandeira());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Cartao cartao) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE CARTAO SET NUMERO=?, VALIDADE=?, CODCARTAO=?, NOME=?, BANDEIRA=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, cartao.getNumero());
        ps.setString(2, cartao.getValidade());
        ps.setInt(3, cartao.getCodigocartao());
        ps.setString(4, cartao.getNome());
        ps.setString(5, cartao.getBandeira());
        ps.setInt(6, cartao.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Cartao cartao) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM CARTAO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, cartao.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Cartao> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CARTAO";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaCartao = new ArrayList();
        while (rs.next()) {
            Cartao cartao = new Cartao();
            cartao.setCodigo(rs.getInt("CODIGO"));
            cartao.setNumero(rs.getString("NUMERO"));
            cartao.setValidade(rs.getString("VALIDADE"));
            cartao.setCodigocartao(rs.getInt("CODCARTAO"));
            cartao.setNome(rs.getString("NOME"));
            cartao.setBandeira(rs.getString("BANDEIRA"));
            listaCartao.add(cartao);
        }

        return listaCartao;
    }

    @Override
    public Cartao recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM CARTAO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Cartao cartao = new Cartao();
        while (rs.next()) {
            cartao.setCodigo(rs.getInt("CODIGO"));
            cartao.setNumero(rs.getString("NUMERO"));
            cartao.setValidade(rs.getString("VALIDADE"));
            cartao.setCodigocartao(rs.getInt("CODCARTAO"));
            cartao.setNome(rs.getString("NOME"));
            cartao.setBandeira(rs.getString("BANDEIRA"));
        }

        return cartao;
    }

}
