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
public class Medico extends Usuario{
    private int codigo;
    private String CRM;
    private int idusuario;

    public Medico() {
        this.codigo = 0;
    }

    public Medico(int codigo, String CRM, int idusuario) {
        this.codigo = codigo;
        this.CRM = CRM;
        this.idusuario = idusuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public void cadastraTAF(ExameAptidao ea, Medico medico, String afericao, String ausculta, boolean apto){
        TAF taf = new TAF();
        taf.setExameAptidao(ea);
        taf.setIdmedico(medico.getCodigo());
        taf.setAfericaopressao(afericao);
        taf.setAusculta(ausculta);
        taf.setApto(apto);
        
    }
    
    public void alteraTAF(ExameAptidao ea, Medico medico, String afericao, String ausculta, boolean apto){
        TAF taf = new TAF();
        taf.setExameAptidao(ea);
        taf.setIdmedico(medico.getCodigo());
        taf.setAfericaopressao(afericao);
        taf.setAusculta(ausculta);
        taf.setApto(apto);
    }
    
    public void ExcluiTAF(){
        TAF taf;
        ExameAptidao ea;
    }
}
