/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Medico;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class MedicoDB implements DB<Medico> {

    @Override
    public void inserir(Medico medico) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO MEDICO (NOME, CPF, IDUSUARIO) VALUES (?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, medico.getNome());
        ps.setString(2, medico.getCpf());
        ps.setInt(3, medico.getIdusuario());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Medico medico) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE MEDICO SET NOME=?, CPF=?, IDUSUARIO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, medico.getNome());
        ps.setString(2, medico.getCpf());
        ps.setInt(3, medico.getIdusuario());
        ps.setInt(4, medico.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Medico medico) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM MEDICO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, medico.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Medico> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM MEDICO";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaMedico = new ArrayList();
        while (rs.next()) {
            Medico medico = new Medico();
            medico.setCodigo(rs.getInt("CODIGO"));
            medico.setNome(rs.getString("NOME"));
            medico.setCpf(rs.getString("CPF"));
            medico.setIdusuario(rs.getInt("IDUSUARIO"));
            listaMedico.add(medico);
        }

        return listaMedico;
    }

    @Override
    public Medico recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM MEDICO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Medico medico = new Medico();
        while (rs.next()) {
            medico.setCodigo(rs.getInt("CODIGO"));
            medico.setNome(rs.getString("NOME"));
            medico.setCpf(rs.getString("CPF"));
            medico.setIdusuario(rs.getInt("IDUSUARIO"));
        }

        return medico;
    }

}
