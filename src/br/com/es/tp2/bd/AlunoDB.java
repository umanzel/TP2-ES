/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Aluno;
import br.com.es.tp2.dados.FichaTreino;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xtrem
 */
public class AlunoDB implements DB<Aluno> {

    @Override
    public void inserir(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "INSERT INTO ALUNO (NOME, CPF, IDENTIDADE, DATANASCIMENTO, IDCARTAO, IDMATRICULA, PAGAMENTOMENSAL, IDTAF, IDUSUARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getCpf());
        ps.setString(3, aluno.getIdentidade());
        ps.setDate(4, new Date(aluno.getDatanascimento().getTime()));
        ps.setInt(5, aluno.getIdcartao());
        ps.setInt(6, aluno.getMatricula());
        ps.setDouble(7, aluno.getPagamentomensal());
        ps.setInt(8, aluno.getIdtaf());
        ps.setInt(9, aluno.getIdusuario());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idAluno = rs.getInt(1);

        for (FichaTreino ft : aluno.getFichatreino()) {
            sql = "INSERT INTO FICHATREINO (IDALUNO, IDDIA, IDHORA, IDPROFESSOR, IDMODALIDADE, EXERCICIO, REPETICOES) VALUES (?, ?, ?, ?, ?, ?, ?)";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.setInt(2, ft.getIddia());
            ps.setInt(3, ft.getIdhora());
            ps.setInt(4, ft.getIdprofessor());
            ps.setInt(5, ft.getIdmodalidade());
            ps.setString(6, ft.getExercicio());
            ps.setInt(7, ft.getRepeticoes());
            ps.execute();
        }
        c.confirmar();
    }

    @Override
    public void alterar(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE ALUNO SET NOME=?, CPF=?, IDENTIDADE=?, DATANASCIMENTO=?, IDCARTAO=?, IDMATRICULA=?, PAGAMENTOMENSAL=?, IDTAF=?, IDUSUARIO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, aluno.getNome());
        ps.setString(2, aluno.getCpf());
        ps.setString(3, aluno.getIdentidade());
        ps.setDate(4, new Date(aluno.getDatanascimento().getTime()));
        ps.setInt(5, aluno.getIdcartao());
        ps.setInt(6, aluno.getMatricula());
        ps.setDouble(7, aluno.getPagamentomensal());
        ps.setInt(8, aluno.getIdtaf());
        ps.setInt(9, aluno.getIdusuario());
        ps.setInt(10, aluno.getCodigo());
        ps.execute();

        for (FichaTreino ft : aluno.getRemoverFichaTreino()) {
            sql = "DELETE FROM FICHATREINO WHERE CODIGO=?";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, ft.getCodigo());
            ps.execute();
        }

        for (FichaTreino ft : aluno.getFichatreino()) {
            if (ft.getCodigo() == 0) {
                sql = "INSERT INTO FICHATREINO (IDALUNO, IDDIA, IDHORA, IDPROFESSOR, IDMODALIDADE, EXERCICIO, REPETICOES) VALUES (?, ?, ?, ?, ?, ?, ?)";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, ft.getAluno().getCodigo());
                ps.setInt(2, ft.getIddia());
                ps.setInt(3, ft.getIdhora());
                ps.setInt(4, ft.getIdprofessor());
                ps.setInt(5, ft.getIdmodalidade());
                ps.setString(6, ft.getExercicio());
                ps.setInt(7, ft.getRepeticoes());
                ps.execute();
            } else {
                sql = "UPDATE FICHATREINO SET IDALUNO=?, IDDIA=?, IDHORA=?, IDPROFESSOR=?, IDMODALIDADE=?, EXERCICIO=?, REPETICOES=? WHERE CODIGO=?)";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, ft.getAluno().getCodigo());
                ps.setInt(2, ft.getIddia());
                ps.setInt(3, ft.getIdhora());
                ps.setInt(4, ft.getIdprofessor());
                ps.setInt(5, ft.getIdmodalidade());
                ps.setString(6, ft.getExercicio());
                ps.setInt(7, ft.getRepeticoes());
                ps.setInt(8, ft.getCodigo());
                ps.execute();
            }
        }
        c.confirmar();
    }

    @Override
    public void excluir(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "DELETE FROM ALUNO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, aluno.getCodigo());
        ps.execute();
        c.confirmar();
    }

    @Override
    public ArrayList<Aluno> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM ALUNO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaAlunos = new ArrayList();
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setCodigo(rs.getInt("CODIGO"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setCpf(rs.getString("CPF"));
            aluno.setIdentidade(rs.getString("IDENTIDADE"));
            aluno.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            aluno.setIdcartao(rs.getInt("IDCARTAO"));
            aluno.setMatricula(rs.getInt("IDMATRICULA"));
            aluno.setPagamentomensal(rs.getDouble("PAGAMENTOMENSAL"));
            aluno.setIdtaf(rs.getInt("IDTAF"));
            aluno.setIdusuario(rs.getInt("IDUSUARIO"));

            String sqlFicha = "SELECT * FROM FICHATREINO WHERE IDALUNO=?";
            PreparedStatement psFicha = c.getConexao().prepareStatement(sqlFicha);
            psFicha.setInt(1, aluno.getCodigo());
            ResultSet rsFicha = psFicha.executeQuery();

            while (rsFicha.next()) {
                FichaTreino ft = new FichaTreino();
                ft.setCodigo(rsFicha.getInt("CODIGO"));
                ft.setAluno(aluno);
                ft.setIddia(rs.getInt("IDDIA"));
                ft.setIdhora(rs.getInt("IDHORA"));
                ft.setIdprofessor(rs.getInt("IDPROFESSOR"));
                ft.setIdmodalidade(rs.getInt("IDMODALIDADE"));
                ft.setExercicio(rs.getString("EXERCICIO"));
                ft.setRepeticoes(rs.getInt("REPETICOES"));
                aluno.addFicha(ft);
            }

            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }

    @Override
    public Aluno recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM ALUNO WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

        Aluno aluno = new Aluno();

        while (rs.next()) {
            aluno.setCodigo(rs.getInt("CODIGO"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setCpf(rs.getString("CPF"));
            aluno.setIdentidade(rs.getString("IDENTIDADE"));
            aluno.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            aluno.setIdcartao(rs.getInt("IDCARTAO"));
            aluno.setMatricula(rs.getInt("IDMATRICULA"));
            aluno.setPagamentomensal(rs.getDouble("PAGAMENTOMENSAL"));
            aluno.setIdtaf(rs.getInt("IDTAF"));
            aluno.setIdusuario(rs.getInt("IDUSUARIO"));

            String sqlFicha = "SELECT * FROM FICHATREINO WHERE IDALUNO=?";
            PreparedStatement psFicha = c.getConexao().prepareStatement(sqlFicha);
            psFicha.setInt(1, aluno.getCodigo());
            ResultSet rsFicha = psFicha.executeQuery();

            while (rsFicha.next()) {
                FichaTreino ft = new FichaTreino();
                ft.setCodigo(rsFicha.getInt("CODIGO"));
                ft.setAluno(aluno);
                ft.setIddia(rs.getInt("IDDIA"));
                ft.setIdhora(rs.getInt("IDHORA"));
                ft.setIdprofessor(rs.getInt("IDPROFESSOR"));
                ft.setIdmodalidade(rs.getInt("IDMODALIDADE"));
                ft.setExercicio(rs.getString("EXERCICIO"));
                ft.setRepeticoes(rs.getInt("REPETICOES"));
                aluno.addFicha(ft);
            }
        }
        return aluno;
    }

}
