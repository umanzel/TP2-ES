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
public class Turma {
    private String idTurma;
    private int capacidade;
    private int quantidadeMatriculados;
    private String modalidade;
    private String dia;
    private String hora;

    public Turma(String idTurma, int capacidade, int quantidadeMatriculados, String modalidade, String dia, String hora) {
        this.idTurma = idTurma;
        this.capacidade = capacidade;
        this.quantidadeMatriculados = quantidadeMatriculados;
        this.modalidade = modalidade;
        this.dia = dia;
        this.hora = hora;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getQuantidadeMatriculados() {
        return quantidadeMatriculados;
    }

    public void setQuantidadeMatriculados(int quantidadeMatriculados) {
        this.quantidadeMatriculados = quantidadeMatriculados;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean verificarDisponibilidade(){
        if((this.capacidade - this.quantidadeMatriculados) > 0){
            return true;
        }
        else
            return false;
    }
    
    
}
