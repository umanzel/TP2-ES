/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.TAF;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class TafDB implements DB<TAF>{

    @Override
    public void inserir(TAF taf) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO TAF (IDMEDICO, AUSCULTA, AFERICAOPRESSAO, IDANAMNESE, PESO, ALTURA, PERCENTUALGORDURA, MASSAMAGRA, IMC, APTO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, taf.getIdmedico());
        ps.setString(2, taf.getAusculta());
        ps.setString(3, taf.getAfericaopressao());
        ps.setInt(4, taf.getIdanamnese().getCodigo());
        ps.setDouble(5, taf.getPeso());
        ps.setDouble(6, taf.getAltura());
        ps.setDouble(7, taf.getPercentualgordura());
        ps.setDouble(8, taf.getMassamagra());
        ps.setDouble(9, taf.getImc());
        ps.setBoolean(10, taf.isApto());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(TAF taf) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE TAF SET IDMEDICO=?, AUSCULTA=?, AFERICAOPRESSAO=?, IDANAMNESE=?, PESO=?, ALTURA=?, PERCENTUALGORDURA=?, MASSAMAGRA=?, IMC=?, APTO=? WHERE CODIGO=?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, taf.getIdmedico());
        ps.setString(2, taf.getAusculta());
        ps.setString(3, taf.getAfericaopressao());
        ps.setInt(4, taf.getIdanamnese().getCodigo());
        ps.setDouble(5, taf.getPeso());
        ps.setDouble(6, taf.getAltura());
        ps.setDouble(7, taf.getPercentualgordura());
        ps.setDouble(8, taf.getMassamagra());
        ps.setDouble(9, taf.getImc());
        ps.setBoolean(10, taf.isApto());
        ps.setInt(11, taf.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(TAF taf) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM TAF WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, taf.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<TAF> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TAF recuperar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
