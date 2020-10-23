/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.main;

import br.com.es.tp2.dados.Usuario;
import java.util.Scanner;

/**
 *
 * @author Xtrem
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Login logon = new Login();
        Scanner in = new Scanner(System.in);
        Usuario user = new Usuario();
        String login;
        String senha;
        int loop = 1;
        int opcao = 0;
        
        System.out.print("login: ");
        user.setLogin(in.nextLine());
        
        System.out.print("senha: ");
        user.setSenha(in.nextLine());
        
        if(logon.Logar(user) > 0){
            while(loop != 0){
                Menu menu = new Menu(user);
                menu.exibirMenu();
                opcao = in.nextInt();
            }
        }
    }
}
