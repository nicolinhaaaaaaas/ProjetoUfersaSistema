package ProjetoPrototipo.src.MENU;

import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.Aluno;
import ProjetoPrototipo.src.SERVICOS.*;
import java.sql.*;

public class Menu {

    static AlunoServico alunoServico = new AlunoServico();

    // OPÇÕES DE LOGIN E PESSOAIS /////////////////////////////////////////////////////////////////////////

    public static void cadastroAluno(int usuario) throws SQLException{
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite seu nome: ");
            String nome = entrada.nextLine();
            System.out.println("Digite seu E-Mail: ");
            String email = entrada.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = entrada.nextLine();
            if(alunoServico.verificarLogin(email) == true){
                System.out.println("E-Mail já cadastrado.");
            }else{
                alunoServico.cadastrarAluno(nome, email, senha);
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static Aluno loginAluno() throws SQLException{
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Digite seu E-Mail: ");
            String email = entrada.nextLine();
            System.out.println("Digite sua senha: ");
            String senha = entrada.nextLine();
            if(alunoServico.loginAluno(email, senha) != null){
                System.out.println("Login bem sucedido!");
                return alunoServico.loginAluno(email, senha);
            }else{
                System.out.println("Login não sucedido.");
                return null;
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
        return null;
    } 

    public static void verDadosPessoaisAluno(Aluno aluno){
        System.out.println(aluno.toString());
    }

    public static void atualizarPerfilAluno(Aluno aluno) throws SQLException{
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Dados atuais: "+aluno.toString());
            System.out.println("Deseja atualizá-los? (1)-Sim (0)-Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                System.out.println("Digite o novo nome: ");
                String novoNome = entrada.nextLine();
                System.out.println("Digite o novo E-Mail: ");
                String novoEmail = entrada.nextLine();
                System.out.println("digite a nova senha: ");
                String novaSenha = entrada.nextLine();
                //verifica se o novo login fornecido é igual ao login atual, ou seja, não precisa mudar
                if(novoEmail.equals(aluno.getEmail())){
                    aluno.setNome(novoNome);
                    aluno.setSenha(novaSenha);
                    alunoServico.atualizarAluno(aluno);
                }else{ // o novo email é diferente do atual
                    if(alunoServico.verificarLogin(novoEmail) == true){
                        System.out.println("Email já cadastrado.");
                    }else{
                        aluno.setNome(novoNome);
                        aluno.setEmail(novoEmail);
                        aluno.setSenha(novaSenha);
                        alunoServico.atualizarAluno(aluno);
                    }
                }
            }else{
                System.out.println("Operação cancelada.");
            }
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

    public static void cadastroProfessor(){
        
    }

    public static void loginProfessor(){

    }

    public static void adicionarDisciplina(){

    }

    public static void atualizarDisciplina(){

    } 

    // CLEAR BUFFER ///////////////////////////////////////////////////////////////////////////

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
