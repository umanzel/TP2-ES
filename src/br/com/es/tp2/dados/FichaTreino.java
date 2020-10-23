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
public class FichaTreino {
    private int codigo;
    private Aluno aluno;
    private int iddia;
    private int idhora;
    private int idprofessor;
    private int idmodalidade;
    private String exercicio;
    private int repeticoes;

    public FichaTreino() {
        this.codigo = 0;
    }

    public FichaTreino(int codigo, Aluno aluno, int iddia, int idhora, int idprofessor, int idmodalidade, String exercicio, int repeticoes) {
        this.codigo = codigo;
        this.aluno = aluno;
        this.iddia = iddia;
        this.idhora = idhora;
        this.idprofessor = idprofessor;
        this.idmodalidade = idmodalidade;
        this.exercicio = exercicio;
        this.repeticoes = repeticoes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno idaluno) {
        this.aluno = idaluno;
    }

    public int getIddia() {
        return iddia;
    }

    public void setIddia(int iddia) {
        this.iddia = iddia;
    }

    public int getIdhora() {
        return idhora;
    }

    public void setIdhora(int idhora) {
        this.idhora = idhora;
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

    public String getExercicio() {
        return exercicio;
    }

    public void setExercicio(String exercicio) {
        this.exercicio = exercicio;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    
    
}
