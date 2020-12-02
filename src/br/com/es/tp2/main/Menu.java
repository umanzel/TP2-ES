/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.main;

import br.com.es.tp2.dados.Usuario;

/**
 *
 * @author Xtrem
 */
public class Menu {
    private Usuario user;

    public Menu(Usuario user) {
        this.user = user;
    }
    
    public void exibirMenu(){
        if(user.getPerfil()== 1){
            System.out.println("1. Ver ficha de treino");
            System.out.println("2. Ver ficha TAF");
            System.out.println("\n0. Sair");
            System.out.print("\n\nDigite a opção desejada: ");
        }
        else if(user.getPerfil()== 2){
            System.out.println("1. Mostrar planos");
            System.out.println("2. Matricular aluno");
            System.out.println("\n0. Sair");
            System.out.print("\n\nDigite a opção desejada: ");
        }
    }
}
