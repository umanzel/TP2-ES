/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xtrem
 */
public class Aluno {
    private int codigo;
    private String nome;
    private String cpf;
    private String identidade;
    private Date datanascimento;
    private int idcartao;
    private List<FichaTreino> fichatreino;
    private List<FichaTreino> removerfichatreino;
    private int matricula;
    private Double pagamentomensal;
    private int idtaf;
    private int idusuario;

    public Aluno() {
        this.codigo = 0;
        this.nome = "";
        this.cpf = "";
        this.identidade = "";
        this.datanascimento = new Date();
        this.idcartao = 0;
        this.fichatreino = new ArrayList();
        this.matricula = 0;
        this.pagamentomensal = 0.0;
        this.idtaf = 0;
        this.idusuario = 0;
    }

    public Aluno(int codigo, String nome, String cpf, String identidade, Date datanascimento, int idcartao, List<FichaTreino> fichatreino, int matricula, Double pagamentomensal, int idtaf, int idusuario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.identidade = identidade;
        this.datanascimento = datanascimento;
        this.idcartao = idcartao;
        this.fichatreino = fichatreino;
        this.matricula = matricula;
        this.pagamentomensal = pagamentomensal;
        this.idtaf = idtaf;
        this.idusuario = idusuario;
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

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getIdcartao() {
        return idcartao;
    }

    public void setIdcartao(int idcartao) {
        this.idcartao = idcartao;
    }
    
    public void addFicha(FichaTreino fichaTreino) {
        this.fichatreino.add(fichaTreino);
    }
    
    public List<FichaTreino> getRemoverFichaTreino() {
        return removerfichatreino;
    }
    
    public void removeFichaTreino(FichaTreino ficha) {
        fichatreino.remove(ficha);
        if (ficha.getCodigo() != 0){
            removerfichatreino.add(ficha);
        }
    }

    public List<FichaTreino> getFichatreino() {
        return fichatreino;
    }

    public void setFichatreino(List<FichaTreino> fichatreino) {
        this.fichatreino = fichatreino;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Double getPagamentomensal() {
        return pagamentomensal;
    }

    public void setPagamentomensal(Double pagamentomensal) {
        this.pagamentomensal = pagamentomensal;
    }

    public int getIdtaf() {
        return idtaf;
    }

    public void setIdtaf(int idtaf) {
        this.idtaf = idtaf;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
}
