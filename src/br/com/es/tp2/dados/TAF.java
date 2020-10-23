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
public class TAF {
    private int codigo;
    private int idmedico;
    private String ausculta;
    private String afericaopressao;
    private Anamnese idanamnese;
    private Double peso;
    private Double altura;
    private Double percentualgordura;
    private Double massamagra;
    private Double imc;
    private boolean apto;

    public TAF() {
        this.codigo = 0;
    }

    public TAF(int codigo, int idmedico, String ausculta, String afericaopressao, Anamnese idanamnese, Double peso, Double altura, Double percentualgordura, Double massamagra, Double imc, boolean apto) {
        this.codigo = codigo;
        this.idmedico = idmedico;
        this.ausculta = ausculta;
        this.afericaopressao = afericaopressao;
        this.idanamnese = idanamnese;
        this.peso = peso;
        this.altura = altura;
        this.percentualgordura = percentualgordura;
        this.massamagra = massamagra;
        this.imc = imc;
        this.apto = apto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public String getAusculta() {
        return ausculta;
    }

    public void setAusculta(String ausculta) {
        this.ausculta = ausculta;
    }

    public String getAfericaopressao() {
        return afericaopressao;
    }

    public void setAfericaopressao(String afericaopressao) {
        this.afericaopressao = afericaopressao;
    }

    public Anamnese getIdanamnese() {
        return idanamnese;
    }

    public void setIdanamnese(Anamnese idanamnese) {
        this.idanamnese = idanamnese;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPercentualgordura() {
        return percentualgordura;
    }

    public void setPercentualgordura(Double percentualgordura) {
        this.percentualgordura = percentualgordura;
    }

    public Double getMassamagra() {
        return massamagra;
    }

    public void setMassamagra(Double massamagra) {
        this.massamagra = massamagra;
    }

    public Double getImc() {
        return this.peso / this.altura;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }
    
}
