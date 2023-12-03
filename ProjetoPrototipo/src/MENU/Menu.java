package ProjetoPrototipo.src.MENU;

import java.util.*;
import ProjetoPrototipo.src.SERVICOS.*;
import java.sql.*;

public class Menu {

    AlunoServico usuarioServico = new AlunoServico();

    // OPÇÕES DE LOGIN E PESSOAIS /////////////////////////////////////////////////////////////////////////

    public static void login(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite seu E-Mail: ");
            String email = entrada.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = entrada.nextLine();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    } 

    public static void cadastro(int usuario){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite seu nome: ");
            String nome = entrada.nextLine();
            System.out.println("Digite seu E-Mail: ");
            String email = entrada.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = entrada.nextLine();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void verDadosPessoais(){

    }

    public static void atualizarPerfil(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }
    
    // OPÇÕES DO ESTUDANTE /////////////////////////////////////////////////////////////////////

    public static void matriculaDisciplina(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void cancelarDisciplina(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void verComprovanteMatricula(){

    }

    public static void verDadosTurma(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void verPariticipantesTurma(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void verificarNotas(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    // OPÇÕES DO PROFESSOR ////////////////////////////////////////////////////////////////////



    // CLEAR BUFFER ///////////////////////////////////////////////////////////////////////////

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
