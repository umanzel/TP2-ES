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
public class Cartao {
    private int codigo;
    private String numero;
    private String validade;
    private int codigocartao;
    private String nome;
    private String bandeira;

    public Cartao() {
        this.codigo = 0;
    }

    public Cartao(int codigo, String numero, String validade, int codigocartao, String nome, String bandeira) {
        this.codigo = codigo;
        this.numero = numero;
        this.validade = validade;
        this.codigocartao = codigocartao;
        this.nome = nome;
        this.bandeira = bandeira;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCodigocartao() {
        return codigocartao;
    }

    public void setCodigocartao(int codigocartao) {
        this.codigocartao = codigocartao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
    
    
}
