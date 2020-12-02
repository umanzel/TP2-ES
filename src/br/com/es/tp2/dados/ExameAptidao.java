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
public class ExameAptidao {
    
    private Anamnese anamnese;
    private Double peso;
    private Double altura;
    private Double percentualgordura;
    private Double massamagra;
    private Double imc;

    public ExameAptidao(){
    }
    
    public ExameAptidao(Anamnese anamnese, Double peso, Double altura, Double percentualgordura, Double massamagra, Double imc) {
        this.anamnese = anamnese;
        this.peso = peso;
        this.altura = altura;
        this.percentualgordura = percentualgordura;
        this.massamagra = massamagra;
        this.imc = imc;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
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
        return (this.altura / this.peso);
    }

    public void setImc(Double altura, Double peso) {
        this.imc = (altura / peso);
    }
    
    
}
