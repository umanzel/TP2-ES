/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.es.tp2.main;

import br.com.es.tp2.bd.AlunoDB;
import br.com.es.tp2.bd.CartaoDB;
import br.com.es.tp2.bd.MatriculaDB;
import br.com.es.tp2.bd.MedicoDB;
import br.com.es.tp2.bd.ProfessorDB;
import br.com.es.tp2.bd.UsuarioDB;
import br.com.es.tp2.dados.Aluno;
import br.com.es.tp2.dados.Cartao;
import br.com.es.tp2.dados.Exercicio;
import br.com.es.tp2.dados.FichaTreino;
import br.com.es.tp2.dados.Matricula;
import br.com.es.tp2.dados.Medico;
import br.com.es.tp2.dados.Usuario;
import java.util.ArrayList;
import java.util.List;
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
        UsuarioDB usuariodb = new UsuarioDB();
        MedicoDB medicodb = new MedicoDB();
        AlunoDB alunodb = new AlunoDB();
        ProfessorDB professordb = new ProfessorDB();
        Matricula matricula = new Matricula();
        int perfil = 0;
        int opcao = 99;
        int loop = 99;
        
        System.out.print("login: ");
        user.setLogin(in.nextLine());
        
        System.out.print("senha: ");
        user.setSenha(in.nextLine());
        
        if(logon.Logar(user) > 0){
            if(logon.Logar(user) == 1){
                MenuAluno();
            }
            else if(logon.Logar(user) == 2){
                MenuSecretaria();
                opcao = in.nextInt();
                if(opcao == 1){
                    Usuario usuario = new Usuario();
                    System.out.println("Cadastro de usuario:\n");
                    System.out.print("Login: ");
                    usuario.setLogin(in.nextLine());
                    System.out.print("Senha: ");
                    usuario.setSenha(in.nextLine());
                    System.out.print("Nome: ");
                    usuario.setNome(in.nextLine());
                    System.out.print("CPF: ");
                    usuario.setCpf(in.nextLine());
                    System.out.print("Endereço: ");
                    usuario.setEndereco(in.nextLine());
                    System.out.print("Telefone: ");
                    usuario.setTelefone(in.nextLine());
                    System.out.print("E-mail: ");
                    usuario.setEmail(in.nextLine());
                    
                    System.out.println("Nivel de acesso\n\n1. Aluno\n2. Secretaria\n3. Professor\n4. Medico\n\n");
                    perfil = in.nextInt();
                    if(perfil == 1){
                        Aluno aluno = new Aluno();
                        System.out.print("Identidade: ");
                        aluno.setIdentidade(in.nextLine());
                        alunodb.inserir(aluno);
                        usuariodb.inserir(usuario);
                    }
                    else if(perfil == 4){
                        Medico medico = new Medico();
                        System.out.print("CRM: ");
                        medico.setCRM(in.nextLine());
                        medicodb.inserir(medico);
                        usuariodb.inserir(usuario);
                    }
                    else{
                        usuariodb.inserir(usuario);
                    }
                    
                }
            }
            else if(logon.Logar(user) == 3){
                MenuProfessor();
                opcao = in.nextInt();
                if(opcao == 1){
                    int idAluno = 0;
                    alunodb.mostraAlunos();
                    Exercicio exercicio = new Exercicio();
                    FichaTreino ft = new FichaTreino();
                    System.out.print("\nSelecione o aluno: ");
                    idAluno = in.nextInt();
                    while(loop != 0){
                        Clear();
                        System.out.println("Cadastrar novo exercicio:\n");
                        String ex = in.nextLine();                        
                        ex = in.nextLine();

                        exercicio.setExercicio(ex);
                        System.out.print("Repetições: ");
                        exercicio.setRepeticoes(in.nextInt());
                        ft.addExercicio(exercicio);
                        System.out.println("\n\nDeseja cadastrar novo exercicio:\n1. Sim\n0. Não");
                        loop = in.nextInt();
                    }
                    loop = 99;
                    while(loop != 0){
                        Clear();
                        System.out.println("Matricular na turma:\n");
                        MenuTurma();
                        System.out.print("\nSelecionar turma: ");
                        matricula.setIdturma(in.nextInt());
                        System.out.println("Deseja matricular em outra turma?\n\n1. Sim\n0. Não");
                        loop = in.nextInt();
                    }
                }
            }
            else if(logon.Logar(user) == 4){
                MenuMedico();
                opcao = in.nextInt();
                if(opcao == 1){
                    
                }
            }
        }
        else
            System.out.println("Falha de login");
    }

    private static void MenuMedico() {
        Clear();
        System.out.println("1. Cadastrar TAF");
        System.out.println("0. Sair");
    }
    
    private static void MenuSecretaria(){
        Clear();
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Matricular Aluno");
        System.out.println("0. Sair");
    }
    private static void MenuProfessor() {
        Clear();
        System.out.println("1. Cadastrar nova ficha");
        System.out.println("0. Sair");
    }
    
    private static void MenuAluno(){
        Clear();
        System.out.println("1. Visualizar TAF");
        System.out.println("2. Visualizar Treino");
    }
    
    private static void Clear() {
        for (int i = 0; i < 100; i++){
            System.out.println("");
        }
    }
    
    private static void MenuPlano(){
        Clear();
        System.out.println("1. R$ 215,00/mês - 2x/sem - Natação");
        System.out.println("2. R$ 229,00/mês - 3x/sem - Natação");
        System.out.println("3. R$ 193,50/sem - 2x/sem - Natação");
        System.out.println("4. R$ 206,10/sem - 3x/sem - Natação");
        System.out.println("5. R$ 182,75/ano - 2x/sem - Natação");
        System.out.println("6. R$ 189,00/ano - 3x/sem - Natação");
        System.out.println("7. R$ 125,00/mês - 7x/sem - Musculação");
        System.out.println("8. R$ 115,50/sem - 7x/sem - Musculação");
        System.out.println("9. R$ 106,25/ano - 7x/sem - Musculação");
        System.out.println("10. R$ 155,00/mes - 3x/sem - Crossfit");
        System.out.println("11. R$ 139,00/sem - 3x/sem - Crossfit");
        System.out.println("12. R$ 130,00/ano - 3x/sem - Crossfit");
        System.out.println("13. R$ 155,00/mes - 3x/sem - Ritmos");
        System.out.println("14. R$ 139,00/sem - 3x/sem - Ritmos");
        System.out.println("15. R$ 130,00/ano - 3x/sem - Ritmos");
        System.out.println("16. R$ 155,00/mes - 3x/sem - Spinning");
        System.out.println("17. R$ 139,00/sem - 3x/sem - Spinning");
        System.out.println("18. R$ 130,00/ano - 3x/sem - Spinning");
    }
    
    private static void MenuTurma(){
        Clear();
        System.out.println("1. C0630SQS - 06:30 - Crossfit");
        System.out.println("2. C0630TQS - 06:30 - Crossfit");
        System.out.println("3. S0700SQS - 07:00 - Spinning");
        System.out.println("4. S0700TQS - 07:00 - Spinning");
        System.out.println("5. N0800TQ - 08:00 - Natação");
        System.out.println("6. N0800SQS - 08:00 - Natação");
        System.out.println("7. C0830SQS - 08:30 - Crossfit");
        System.out.println("8. C0830TQS - 08:30 - Crossfit");
        System.out.println("9. R0900SQS - 09:00 - Ritmos");
        System.out.println("10. R0900TQS - 09:00 - Ritmos");
        System.out.println("11. N1000TQ - 10:00 - Natação");
        System.out.println("12. N1000SQS - 10:00 - Natação");
        System.out.println("13. C1015SQS - 10:15 - Crossfit");
        System.out.println("14. C1015TQS - 10:15 - Crossfit");
        System.out.println("15. S1200SQS - 12:00 - Spinning");
        System.out.println("16. S1200TQS - 12:00 - Spinning");
        System.out.println("17. C1200SQS - 12:00 - Crossfit");
        System.out.println("18. C1200TQS - 12:00 - Crossfit");
        System.out.println("19. S1600SQS - 16:00 - Spinning");
        System.out.println("20. S1600TQS - 16:00 - Spinning");
        System.out.println("21. R1700SQS - 17:00 - Ritmos");
        System.out.println("22. R1700TQS - 17:00 - Ritmos");
        System.out.println("23. N1700TQ - 17:00 - Natação");
        System.out.println("24. N1700SQS - 17:00 - Natação");
        System.out.println("25. R1800SQS - 18:00 - Ritmos");
        System.out.println("26. R1800TQS - 18:00 - Ritmos");
        System.out.println("27. C1800SQS - 18:00 - Crossfit");
        System.out.println("28. C1800TQS - 18:00 - Crossfit");
        System.out.println("29. N1900TQ - 19:00 - Natação");
        System.out.println("30. N1900SQS - 19:00 - Natação");
        System.out.println("31. R1900SQS - 19:00 - Ritmos");
        System.out.println("32. R1900TQS - 19:00 - Ritmos");
        System.out.println("33. N2000TQ - 20:00 - Natação");
        System.out.println("34. N2000SQS - 20:00 - Natação");
        System.out.println("35. C2000SQS - 20:00 - Crossfit");
        System.out.println("36. C2000TQS - 20:00 - Crossfit");
        System.out.println("99. Any - Musculação");
       
        
    }
}
