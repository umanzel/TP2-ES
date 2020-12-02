/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Xtrem
 */
public class Aluno extends Usuario{
    private int matricula;
    private String identidade;
    private Date datanascimento;
    private FichaTreino fichatreino;
    private List<Plano> planos;
    private List<Plano> removerPlano;
    private double pagamentoMensal;
    private Cartao cartao;
    private TAF taf;
    private Anamnese anamnese;
    private int idusuario;

    public Aluno(int matricula, String identidade, Date datanascimento, FichaTreino fichatreino, List<Plano> planos, double pagamentoMensal, Cartao cartao, TAF taf, Anamnese anamnese, int idusuario) {
        this.matricula = matricula;
        this.identidade = identidade;
        this.datanascimento = datanascimento;
        this.fichatreino = fichatreino;
        this.planos = planos;
        this.pagamentoMensal = pagamentoMensal;
        this.cartao = cartao;
        this.taf = taf;
        this.anamnese = anamnese;
        this.idusuario = idusuario;
    }

    public Aluno() {
        this.matricula = 0;
        this.identidade = "";
        this.datanascimento = new Date();
        this.fichatreino = new FichaTreino();
        this.planos = new ArrayList<>();
        this.cartao = new Cartao();
        this.taf = new TAF();
        this.anamnese = new Anamnese();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public FichaTreino getFichatreino() {
        return fichatreino;
    }

    public void setFichatreino(FichaTreino fichatreino) {
        this.fichatreino = fichatreino;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public List<Plano> getRemoverPlano() {
        return removerPlano;
    }

    public void setRemoverPlano(List<Plano> removerPlano) {
        this.removerPlano = removerPlano;
    }
    
    public void addPlano(Plano plano){
        planos.add(plano);
    }
    
    public void removePlano(Plano plano){
        if (plano.getCodigo() != 0){
            removerPlano.add(plano);
        }
        planos.remove(plano);
    }
    
    public double getPagamentoMensal(){
        return this.pagamentoMensal;
    }
    
    public void setPagamentoMensal(double pagamentoMensal){
        this.pagamentoMensal = pagamentoMensal;
    }
    
    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public TAF getTAF() {
        return taf;
    }

    public void setTAF(TAF taf) {
        this.taf = taf;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

}
