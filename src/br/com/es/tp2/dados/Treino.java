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
public class Treino {
    private int codigo;
    private int idprofessor;
    private int idmodalidade;
    private String exercicios;
    private int repeticoes;

    public Treino(int codigo, int idprofessor, int idmodalidade, String exercicios, int repeticoes) {
        this.codigo = codigo;
        this.idprofessor = idprofessor;
        this.idmodalidade = idmodalidade;
        this.exercicios = exercicios;
        this.repeticoes = repeticoes;
    }

    public Treino() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    public int getIdmodalidade() {
        return idmodalidade;
    }

    public void setIdmodalidade(int idmodalidade) {
        this.idmodalidade = idmodalidade;
    }

    public String getExercicios() {
        return exercicios;
    }

    public void setExercicios(String exercicios) {
        this.exercicios = exercicios;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }
    
}
