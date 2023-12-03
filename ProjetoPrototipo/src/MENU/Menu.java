package ProjetoPrototipo.src.MENU;

import java.util.Scanner;

public class Menu {

    // OPÇÕES DE LOGIN E PESSOAIS /////////////////////////////////////////////////////////////////////////

    public static void login(){

    } 

    public static void cadastro(){

    }

    public static void verDadosPessoais(){

    }

    public static void atualizarPerfil(){
        
    }
    
    // OPÇÕES DO ESTUDANTE /////////////////////////////////////////////////////////////////////

    public static void matriculaDisciplina(){

    }

    public static void cancelarDisciplina(){

    }

    public static void verComprovanteMatricula(){

    }

    public static void verDadosTurma(){

    }

    public static void verPariticipantesTurma(){

    }

    public static void verificarNotas(){

    }

    // OPÇÕES DO PROFESSOR ////////////////////////////////////////////////////////////////////



    // CLEAR BUFFER ///////////////////////////////////////////////////////////////////////////

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
