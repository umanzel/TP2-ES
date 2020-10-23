/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.Date;

/**
 *
 * @author Xtrem
 */
public class Professor {
    private int codigo;
    private String nome;
    private String cpf;
    private Date datanascimento;
    private int idusuario;

    public Professor(int codigo, String nome, String cpf, Date datanascimento, int idusuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.datanascimento = datanascimento;
        this.idusuario = idusuario;
    }

    public Professor() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.datanascimento = new Date();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
}
