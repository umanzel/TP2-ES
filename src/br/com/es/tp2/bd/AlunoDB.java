/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.bd;

import br.com.es.tp2.dados.Aluno;
import br.com.es.tp2.dados.FichaTreino;
import br.com.es.tp2.dados.Plano;
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
        String sql = "INSERT INTO ALUNO (IDENTIDADE, DATANASCIMENTO, IDFICHA, IDCARTAO, IDTAF, IDANAMNESE, IDUSUARIO) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, aluno.getIdentidade());
        ps.setDate(2, new Date(aluno.getDatanascimento().getTime()));
        ps.setInt(3, aluno.getFichatreino().getCodigo());
        ps.setInt(4, aluno.getCartao().getCodigo());
        ps.setInt(5, aluno.getTAF().getCodigo());
        ps.setInt(6, aluno.getAnamnese().getCodigo());
        ps.setInt(7, aluno.getIdusuario());
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int idAluno = rs.getInt(1);

        for (Plano pl : aluno.getPlanos()) {
            sql = "INSERT INTO PLANO (IDALUNO, TIPO, QUANTIDADE, VALORMENSAL) VALUES (?, ?, ?, ?)";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, idAluno);
            ps.setString(2, pl.getTipo());
            ps.setInt(3, pl.getQuantidade());
            ps.setDouble(4, pl.getValormensal());
            ps.execute();
        }

        c.confirmar();
    }

    @Override
    public void alterar(Aluno aluno) throws Exception {
        Conexao c = new Conexao();
        String sql = "UPDATE ALUNO SET IDENTIDADE=?, DATANASCIMENTO=?, IDFICHA=?, IDCARTAO=?, IDTAF=?, IDANAMNESE=?, IDUSUARIO=? WHERE CODIGO=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, aluno.getIdentidade());
        ps.setDate(2, new Date(aluno.getDatanascimento().getTime()));
        ps.setInt(3, aluno.getFichatreino().getCodigo());
        ps.setInt(4, aluno.getCartao().getCodigo());
        ps.setInt(5, aluno.getTAF().getCodigo());
        ps.setInt(6, aluno.getAnamnese().getCodigo());
        ps.setInt(7, aluno.getIdusuario());
        ps.setInt(8, aluno.getCodigo());
        ps.execute();

        for (Plano pl : aluno.getRemoverPlano()) {
            sql = "DELETE FROM PLANO WHERE CODIGO=?";
            ps = c.getConexao().prepareStatement(sql);
            ps.setInt(1, pl.getCodigo());
            ps.execute();
        }
        for (Plano pl : aluno.getPlanos()) {
            if (pl.getCodigo() == 0) {
                sql = "INSERT INTO PLANO (IDALUNO, TIPO, QUANTIDADE, VALORMENSAL) VALUES (?, ?, ?, ?)";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, aluno.getCodigo());
                ps.setString(2, pl.getTipo());
                ps.setInt(3, pl.getQuantidade());
                ps.setDouble(4, pl.getValormensal());
                ps.execute();
            } else {
                sql = "UPDATE PLANO SET IDALUNO=?, TIPO=?, QUANTIDADE=?, VALORMENSAL=? WHERE CODIGO=?";
                ps = c.getConexao().prepareStatement(sql);
                ps.setInt(1, aluno.getCodigo());
                ps.setString(2, pl.getTipo());
                ps.setInt(3, pl.getQuantidade());
                ps.setDouble(4, pl.getValormensal());
                ps.setInt(5, pl.getCodigo());
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
//private int matricula;
//    private String identidade;
//    private java.util.Date datanascimento;
//    private FichaTreino fichatreino;
//    private List<Plano> planos;
//    private List<Plano> removerPlano;
//    private double pagamentoMensal;
//    private Cartao cartao;
//    private TAF taf;
//    private Anamnese anamnese;
//    private int idusuario;

    @Override
    public ArrayList<Aluno> listarTodos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM ALUNO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaAlunos = new ArrayList();
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setMatricula(rs.getInt("MATRICULA"));
            aluno.setIdentidade(rs.getString("IDENTIDADE"));
            aluno.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            aluno.setPagamentoMensal(rs.getDouble("PAGAMENTOMENSAL"));
            aluno.setIdusuario(rs.getInt("IDUSUARIO"));

            String sqlFicha = "SELECT * FROM FICHATREINO WHERE IDALUNO=?";
            String sqlExercicio = "SELECT * FROM EXERCICIO";

            PreparedStatement psFicha = c.getConexao().prepareStatement(sqlFicha);
            PreparedStatement psExercicio = c.getConexao().prepareStatement(sqlExercicio);

            psFicha.setInt(1, aluno.getCodigo());
//            psExercicio.setInt(1, ft.getCodigo());

            ResultSet rsFicha = psFicha.executeQuery();
            ResultSet rsExercicio = psExercicio.executeQuery();

            while (rsFicha.next()) {
                FichaTreino ft = new FichaTreino();
                ft.setCodigo(rsFicha.getInt("CODIGO"));
                while (rsExercicio.next()) {
                    if (rsExercicio.getInt("IDFICHA") == ft.getCodigo()) {

                    }
                }
            }

            String sqlPlano = "SELECT * FROM PLANO WHERE CODIGO=?";
            PreparedStatement psPlano = c.getConexao().prepareStatement(sqlPlano);
            psPlano.setInt(1, aluno.getCodigo());
            ResultSet rsPlano = psPlano.executeQuery();

            while (rsPlano.next()) {
                Plano pl = new Plano();
                pl.setCodigo(rs.getInt("CODIGO"));
                pl.setIdaluno(aluno.getCodigo());
                pl.setTipo(rs.getString("TIPO"));
                pl.setQuantidade(rs.getInt("QUANTIDADE"));
                pl.setValormensal(rs.getDouble("VALORMENSAL"));
                aluno.addPlano(pl);
            }

            listaAlunos.add(aluno);
        }

        return listaAlunos;
    }

    @Override
    public Aluno recuperar(int codigo) throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM ALUNO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Aluno aluno = new Aluno();
        while (rs.next()) {
            aluno.setMatricula(rs.getInt("MATRICULA"));
            aluno.setIdentidade(rs.getString("IDENTIDADE"));
            aluno.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            aluno.setPagamentoMensal(rs.getDouble("PAGAMENTOMENSAL"));
            aluno.setIdusuario(rs.getInt("IDUSUARIO"));

            String sqlFicha = "SELECT * FROM FICHATREINO WHERE IDALUNO=?";
            String sqlExercicio = "SELECT * FROM EXERCICIO";

            PreparedStatement psFicha = c.getConexao().prepareStatement(sqlFicha);
            PreparedStatement psExercicio = c.getConexao().prepareStatement(sqlExercicio);

            psFicha.setInt(1, aluno.getCodigo());
//            psExercicio.setInt(1, ft.getCodigo());

            ResultSet rsFicha = psFicha.executeQuery();
            ResultSet rsExercicio = psExercicio.executeQuery();

            while (rsFicha.next()) {
                FichaTreino ft = new FichaTreino();
                ft.setCodigo(rsFicha.getInt("CODIGO"));
                while (rsExercicio.next()) {
                    if (rsExercicio.getInt("IDFICHA") == ft.getCodigo()) {

                    }
                }
            }

            String sqlPlano = "SELECT * FROM PLANO WHERE CODIGO=?";
            PreparedStatement psPlano = c.getConexao().prepareStatement(sqlPlano);
            psPlano.setInt(1, aluno.getCodigo());
            ResultSet rsPlano = psPlano.executeQuery();

            while (rsPlano.next()) {
                Plano pl = new Plano();
                pl.setCodigo(rs.getInt("CODIGO"));
                pl.setIdaluno(aluno.getCodigo());
                pl.setTipo(rs.getString("TIPO"));
                pl.setQuantidade(rs.getInt("QUANTIDADE"));
                pl.setValormensal(rs.getDouble("VALORMENSAL"));
                aluno.addPlano(pl);
            }

        }

        return aluno;
    }

    public void mostraAlunos() throws Exception {
        Conexao c = new Conexao();

        String sql = "SELECT * FROM ALUNO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Aluno> listaAlunos = new ArrayList();
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setMatricula(rs.getInt("MATRICULA"));
            aluno.setIdentidade(rs.getString("IDENTIDADE"));
            aluno.setDatanascimento(rs.getDate("DATANASCIMENTO"));
            aluno.setPagamentoMensal(rs.getDouble("PAGAMENTOMENSAL"));
            aluno.setIdusuario(rs.getInt("IDUSUARIO"));

            String sqlFicha = "SELECT * FROM FICHATREINO WHERE IDALUNO=?";
            String sqlExercicio = "SELECT * FROM EXERCICIO";

            PreparedStatement psFicha = c.getConexao().prepareStatement(sqlFicha);
            PreparedStatement psExercicio = c.getConexao().prepareStatement(sqlExercicio);

            psFicha.setInt(1, aluno.getCodigo());
//            psExercicio.setInt(1, ft.getCodigo());

            ResultSet rsFicha = psFicha.executeQuery();
            ResultSet rsExercicio = psExercicio.executeQuery();

            while (rsFicha.next()) {
                FichaTreino ft = new FichaTreino();
                ft.setCodigo(rsFicha.getInt("CODIGO"));
                while (rsExercicio.next()) {
                    if (rsExercicio.getInt("IDFICHA") == ft.getCodigo()) {

                    }
                }
            }

            String sqlPlano = "SELECT * FROM PLANO WHERE CODIGO=?";
            PreparedStatement psPlano = c.getConexao().prepareStatement(sqlPlano);
            psPlano.setInt(1, aluno.getCodigo());
            ResultSet rsPlano = psPlano.executeQuery();

            while (rsPlano.next()) {
                Plano pl = new Plano();
                pl.setCodigo(rs.getInt("CODIGO"));
                pl.setIdaluno(aluno.getCodigo());
                pl.setTipo(rs.getString("TIPO"));
                pl.setQuantidade(rs.getInt("QUANTIDADE"));
                pl.setValormensal(rs.getDouble("VALORMENSAL"));
                aluno.addPlano(pl);
            }

            listaAlunos.add(aluno);
        }
        for(int i = 0; i <= listaAlunos.size(); i++){
            System.out.println("" +listaAlunos.get(i).getCodigo() +"" +listaAlunos.get(i).getNome());
        }
    }
    

}
