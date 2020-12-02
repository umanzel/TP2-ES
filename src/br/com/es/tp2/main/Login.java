/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.main;

import br.com.es.tp2.bd.Conexao;
import br.com.es.tp2.dados.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Xtrem
 */
public class Login {
    private Usuario user;
    private String login;
    private String senha;
    private int acesso;

    public Login() {
        this.user = new Usuario();
        this.login = "";
        this.senha = "";
        this.acesso = 0;
    }
    
    public int Logar(Usuario user) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM USUARIO WHERE LOGIN=? AND SENHA=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, user.getLogin());
        ps.setString(2, user.getSenha());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user.setLogin(rs.getString("LOGIN"));
            user.setSenha(rs.getString("SENHA"));
            user.setPerfil(rs.getInt("PERFIL"));
            user.setNome(rs.getString("NOME"));
            user.setCpf(rs.getString("CPF"));
            user.setEndereco(rs.getString("ENDERECO"));
            user.setTelefone(rs.getString("TELEFONE"));
            user.setEmail(rs.getString("EMAIL"));
            return user.getPerfil();
        } else {
            return 0;
        }
    }
}
