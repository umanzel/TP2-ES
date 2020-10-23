/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

/**
 *
 * @author Xtrem
 */
public class Usuario {
    private int codigo;
    private String login;
    private String senha;
    private int acesso;

    public Usuario() {
    }

    public Usuario(int codigo, String login, String senha, int acesso) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
        this.acesso = acesso;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
}
