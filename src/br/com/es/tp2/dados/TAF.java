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
    private ExameAptidao exameAptidao;
    private Anamnese anamnese;
    private boolean apto;

    public TAF() {
        this.codigo = 0;
    }

    public TAF(int codigo, int idmedico, String ausculta, String afericaopressao, ExameAptidao exameAptidao, Anamnese anamnese, boolean apto) {
        this.codigo = codigo;
        this.idmedico = idmedico;
        this.ausculta = ausculta;
        this.afericaopressao = afericaopressao;
        this.exameAptidao = exameAptidao;
        this.anamnese = anamnese;
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

    public ExameAptidao getExameAptidao() {
        return exameAptidao;
    }

    public void setExameAptidao(ExameAptidao exameAptidao) {
        this.exameAptidao = exameAptidao;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public boolean isApto() {
        return apto;
    }

    public void setApto(boolean apto) {
        this.apto = apto;
    }
    
}
