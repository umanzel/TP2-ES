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
public class Plano {
    private int codigo;
    private int idaluno;
    private String tipo;
    private int quantidade;
    private double valormensal;

    public Plano() {
        this.codigo = 0;
    }

    public Plano(int codigo, int idaluno, String tipo, int quantidade, double valormensal) {
        this.codigo = codigo;
        this.idaluno = idaluno;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valormensal = valormensal;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValormensal() {
        return valormensal;
    }

    public void setValormensal(double valormensal) {
        this.valormensal = valormensal;
    }
    
}
