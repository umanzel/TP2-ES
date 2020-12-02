/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Xtrem
 */
public class FichaTreino {
    private int codigo;
    private int idMatriculaAluno;
    private List<Exercicio> exercicios;
    

    public FichaTreino() {
        this.codigo = 0;
        this.exercicios = new ArrayList<>();
    }

    public FichaTreino(int codigo, int idMatriculaAluno, List<Exercicio> exercicios) {
        this.codigo = codigo;
        this.idMatriculaAluno = idMatriculaAluno;
        this.exercicios = exercicios;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdMatriculaAluno() {
        return idMatriculaAluno;
    }

    public void setIdMatriculaAluno(int idMatriculaAluno) {
        this.idMatriculaAluno = idMatriculaAluno;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void setExercicios(List<Exercicio> exercicios) {
        this.exercicios = exercicios;
    }
    
    public void addExercicio(Exercicio excercicio) {
        this.exercicios.add(excercicio);
    }
    
}
