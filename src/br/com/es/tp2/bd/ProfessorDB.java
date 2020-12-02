/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class ProfessorDB implements DB<Professor> {

    @Override
    public void inserir(Professor professor) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO PROFESSOR (NOME, CPF, DATANASCIMENTO, IDUSUARIO) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, professor.getNome());
        ps.setString(2, professor.getCpf());
        ps.setInt(3, professor.getIdusuario());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Professor professor) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE PROFESSOR SET NOME=?, CPF=?, DATANASCIMENTO=?, IDUSUARIO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, professor.getNome());
        ps.setString(2, professor.getCpf());
        ps.setInt(3, professor.getIdusuario());
        ps.setInt(4, professor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Professor professor) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM PROFESSOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, professor.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Professor> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM PROFESSOR";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaProfessor = new ArrayList();
        while (rs.next()) {
            Professor professor = new Professor();
            professor.setCodigo(rs.getInt("CODIGO"));
            professor.setNome(rs.getString("NOME"));
            professor.setCpf(rs.getString("CPF"));
            professor.setIdusuario(rs.getInt("IDUSUARIO"));
            listaProfessor.add(professor);
        }

        return listaProfessor;
    }

    @Override
    public Professor recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM PROFESSOR WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Professor professor = new Professor();
        while (rs.next()) {
            professor.setCodigo(rs.getInt("CODIGO"));
            professor.setNome(rs.getString("NOME"));
            professor.setCpf(rs.getString("CPF"));
            professor.setIdusuario(rs.getInt("IDUSUARIO"));
        }

        return professor;
    }

}
