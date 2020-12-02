/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.dados;

import java.util.Date;

/**
 *
 * @author Xtrem
 */
public class Professor extends Usuario{
    private int codigo;
    private int idusuario;

    public Professor(int codigo, int idusuario) {
        this.codigo = codigo;
        this.idusuario = idusuario;
    }

    public Professor() {
        this.codigo = 0;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
}
