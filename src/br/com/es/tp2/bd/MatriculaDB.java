/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Matricula;
import br.com.es.tp2.dados.Plano;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class MatriculaDB implements DB<Matricula>{

    @Override
    public void inserir(Matricula matricula) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO MATRICULA (IDALUNO, IDPLANO) VALUES (?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, matricula.getIdaluno());
        ps.setInt(2, matricula.getPlanos().getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Matricula matricula) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE MATRICULA SET IDALUNO=?, IDPLANO=? WHERE CODIGO=?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, matricula.getIdaluno());
        ps.setInt(2, matricula.getPlanos().getCodigo());
        ps.setInt(3, matricula.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Matricula matricula) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM MATRICULA WHERE CODIGO =?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, matricula.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Matricula> listarTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matricula recuperar(int codigo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
