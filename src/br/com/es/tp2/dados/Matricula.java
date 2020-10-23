/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.List;

/**
 *
 * @author Xtrem
 */
public class Matricula {
    private int codigo;
    private int idaluno;
    private Plano planos;

    public Matricula() {
        this.codigo = 0;
    }

    public Matricula(int codigo, int idaluno, Plano planos) {
        this.codigo = codigo;
        this.idaluno = idaluno;
        this.planos = planos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public Plano getPlanos() {
        return planos;
    }

    public void setPlanos(Plano planos) {
        this.planos = planos;
    }
    
}
