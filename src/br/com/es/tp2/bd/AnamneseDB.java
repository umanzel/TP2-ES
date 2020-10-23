/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Anamnese;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class AnamneseDB implements DB<Anamnese> {

    @Override
    public void inserir(Anamnese anamnese) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO ANAMNESE (IDALUNO, IDMEDICO, QUESTAO1, QUESTAO2, QUESTAO3, QUESTAO4, QUESTAO5, QUESTAO6, QUESTAO7, QUESTAO8, QUESTAO9, QUESTAO10) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, anamnese.getIdaluno());
        ps.setInt(2, anamnese.getIdmedico());
        ps.setInt(3, anamnese.getQuestao1());
        ps.setInt(4, anamnese.getQuestao2());
        ps.setInt(5, anamnese.getQuestao3());
        ps.setInt(6, anamnese.getQuestao4());
        ps.setInt(7, anamnese.getQuestao5());
        ps.setInt(8, anamnese.getQuestao6());
        ps.setInt(9, anamnese.getQuestao7());
        ps.setInt(10, anamnese.getQuestao8());
        ps.setInt(11, anamnese.getQuestao9());
        ps.setInt(12, anamnese.getQuestao10());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void alterar(Anamnese anamnese) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE ANAMNESE SET IDALUNO=?, IDMEDICO=?, QUESTAO1=?, QUESTAO2=?, QUESTAO3=?, QUESTAO4=?, QUESTAO5=?, QUESTAO6=?, QUESTAO7=?, QUESTAO8=?, QUESTAO9=?, QUESTAO10=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, anamnese.getIdaluno());
        ps.setInt(2, anamnese.getIdmedico());
        ps.setInt(3, anamnese.getQuestao1());
        ps.setInt(4, anamnese.getQuestao2());
        ps.setInt(5, anamnese.getQuestao3());
        ps.setInt(6, anamnese.getQuestao4());
        ps.setInt(7, anamnese.getQuestao5());
        ps.setInt(8, anamnese.getQuestao6());
        ps.setInt(9, anamnese.getQuestao7());
        ps.setInt(10, anamnese.getQuestao8());
        ps.setInt(11, anamnese.getQuestao9());
        ps.setInt(12, anamnese.getQuestao10());
        ps.setInt(13, anamnese.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public void excluir(Anamnese anamnese) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM ANAMNESE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, anamnese.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Anamnese> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ANAMNESE";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaAnamnese = new ArrayList();
        while (rs.next()) {
            Anamnese anamnese = new Anamnese();
            anamnese.setCodigo(rs.getInt("CODIGO"));
            anamnese.setIdaluno(rs.getInt("IDALUNO"));
            anamnese.setIdmedico(rs.getInt("IDMEDICO"));
            anamnese.setQuestao1(rs.getInt("QUESTAO1"));
            anamnese.setQuestao2(rs.getInt("QUESTAO2"));
            anamnese.setQuestao3(rs.getInt("QUESTAO3"));
            anamnese.setQuestao4(rs.getInt("QUESTAO4"));
            anamnese.setQuestao5(rs.getInt("QUESTAO5"));
            anamnese.setQuestao6(rs.getInt("QUESTAO6"));
            anamnese.setQuestao7(rs.getInt("QUESTAO7"));
            anamnese.setQuestao8(rs.getInt("QUESTAO8"));
            anamnese.setQuestao9(rs.getInt("QUESTAO9"));
            anamnese.setQuestao10(rs.getInt("QUESTAO10"));
            listaAnamnese.add(anamnese);
        }

        return listaAnamnese;
    }

    @Override
    public Anamnese recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM ANAMNESE WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Anamnese anamnese = new Anamnese();
        while (rs.next()) {
            anamnese.setCodigo(rs.getInt("CODIGO"));
            anamnese.setIdaluno(rs.getInt("IDALUNO"));
            anamnese.setIdmedico(rs.getInt("IDMEDICO"));
            anamnese.setQuestao1(rs.getInt("QUESTAO1"));
            anamnese.setQuestao2(rs.getInt("QUESTAO2"));
            anamnese.setQuestao3(rs.getInt("QUESTAO3"));
            anamnese.setQuestao4(rs.getInt("QUESTAO4"));
            anamnese.setQuestao5(rs.getInt("QUESTAO5"));
            anamnese.setQuestao6(rs.getInt("QUESTAO6"));
            anamnese.setQuestao7(rs.getInt("QUESTAO7"));
            anamnese.setQuestao8(rs.getInt("QUESTAO8"));
            anamnese.setQuestao9(rs.getInt("QUESTAO9"));
            anamnese.setQuestao10(rs.getInt("QUESTAO10"));
        }

        return anamnese;
    }

}
