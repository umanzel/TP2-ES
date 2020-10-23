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
public class Turma {
    private int codigo;
    private int idmodalidade;
    private int idhora;
    private int segunda;
    private int terca;
    private int quarta;
    private int quinta;
    private int sexta;

    public Turma() {
        this.codigo = 0;
    }

    public Turma(int codigo, int idmodalidade, int idhora, int segunda, int terca, int quarta, int quinta, int sexta) {
        this.codigo = codigo;
        this.idmodalidade = idmodalidade;
        this.idhora = idhora;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdmodalidade() {
        return idmodalidade;
    }

    public void setIdmodalidade(int idmodalidade) {
        this.idmodalidade = idmodalidade;
    }

    public int getIdhora() {
        return idhora;
    }

    public void setIdhora(int idhora) {
        this.idhora = idhora;
    }

    public int getSegunda() {
        return segunda;
    }

    public void setSegunda(int segunda) {
        this.segunda = segunda;
    }

    public int getTerca() {
        return terca;
    }

    public void setTerca(int terca) {
        this.terca = terca;
    }

    public int getQuarta() {
        return quarta;
    }

    public void setQuarta(int quarta) {
        this.quarta = quarta;
    }

    public int getQuinta() {
        return quinta;
    }

    public void setQuinta(int quinta) {
        this.quinta = quinta;
    }

    public int getSexta() {
        return sexta;
    }

    public void setSexta(int sexta) {
        this.sexta = sexta;
    }
    
    
}
