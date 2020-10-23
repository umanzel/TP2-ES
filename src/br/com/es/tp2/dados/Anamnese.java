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
public class Anamnese {
    private int codigo;
    private int idaluno;
    private int idmedico;
    private int questao1;
    private int questao2;
    private int questao3;
    private int questao4;
    private int questao5;
    private int questao6;
    private int questao7;
    private int questao8;
    private int questao9;
    private int questao10;

    public Anamnese() {
        this.codigo = 0;
    }

    public Anamnese(int codigo, int idaluno, int idmedico, int questao1, int questao2, int questao3, int questao4, int questao5, int questao6, int questao7, int questao8, int questao9, int questao10) {
        this.codigo = codigo;
        this.idaluno = idaluno;
        this.idmedico = idmedico;
        this.questao1 = questao1;
        this.questao2 = questao2;
        this.questao3 = questao3;
        this.questao4 = questao4;
        this.questao5 = questao5;
        this.questao6 = questao6;
        this.questao7 = questao7;
        this.questao8 = questao8;
        this.questao9 = questao9;
        this.questao10 = questao10;
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

    public int getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(int idmedico) {
        this.idmedico = idmedico;
    }

    public int getQuestao1() {
        return questao1;
    }

    public void setQuestao1(int questao1) {
        this.questao1 = questao1;
    }

    public int getQuestao2() {
        return questao2;
    }

    public void setQuestao2(int questao2) {
        this.questao2 = questao2;
    }

    public int getQuestao3() {
        return questao3;
    }

    public void setQuestao3(int questao3) {
        this.questao3 = questao3;
    }

    public int getQuestao4() {
        return questao4;
    }

    public void setQuestao4(int questao4) {
        this.questao4 = questao4;
    }

    public int getQuestao5() {
        return questao5;
    }

    public void setQuestao5(int questao5) {
        this.questao5 = questao5;
    }

    public int getQuestao6() {
        return questao6;
    }

    public void setQuestao6(int questao6) {
        this.questao6 = questao6;
    }

    public int getQuestao7() {
        return questao7;
    }

    public void setQuestao7(int questao7) {
        this.questao7 = questao7;
    }

    public int getQuestao8() {
        return questao8;
    }

    public void setQuestao8(int questao8) {
        this.questao8 = questao8;
    }

    public int getQuestao9() {
        return questao9;
    }

    public void setQuestao9(int questao9) {
        this.questao9 = questao9;
    }

    public int getQuestao10() {
        return questao10;
    }

    public void setQuestao10(int questao10) {
        this.questao10 = questao10;
    }
    
}
