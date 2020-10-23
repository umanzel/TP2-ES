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
    private int idmodalidade;
    private String tipo;
    private int quantidade;
    private int valormensal;

    public Plano() {
        this.codigo = 0;
    }

    public Plano(int codigo, int idmodalidade, String tipo, int quantidade, int valormensal) {
        this.codigo = codigo;
        this.idmodalidade = idmodalidade;
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

    public int getIdmodalidade() {
        return idmodalidade;
    }

    public void setIdmodalidade(int idmodalidade) {
        this.idmodalidade = idmodalidade;
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

    public int getValormensal() {
        return valormensal;
    }

    public void setValormensal(int valormensal) {
        this.valormensal = valormensal;
    }
    
}
