package ProjetoPrototipo.src.MENU;

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int op1 = 1;

        do{
            menuPrincipal();
            op1 = scanner.nextInt();
            Menu.clearBuffer(scanner);

            int opLogin = 1;

            switch(op1){

                // MENU DO ESTUDANTE ////////////////////////////////////////////////
                case 1:
                    while(opLogin != 0){
                        menuLogin();
                        opLogin = scanner.nextInt();
                        Menu.clearBuffer(scanner);

                        switch(opLogin){

                            // OPÇÃO DE LOGIN
                            case 1:
                                int opMenuEstudante = 1;
                                do{
                                    menuEstudante();
                                    opMenuEstudante = scanner.nextInt();
                                    Menu.clearBuffer(scanner);

                                    switch(opMenuEstudante){
                                        
                                        // SUBMENU DE MATRICULA PARA ESTUDANTE
                                        case 1:
                                            int opSubmenuEstudante1 = 1;
                                            do{
                                                opcoesMatriculaEstudante();
                                                opSubmenuEstudante1 = scanner.nextInt();
                                                Menu.clearBuffer(scanner);

                                                switch(opSubmenuEstudante1){
                                                    case 1:

                                                    break;

                                                    case 2:

                                                    break;

                                                    case 3:

                                                    break;

                                                    case 0:
                                                        System.out.println("Voltando...");
                                                    break;

                                                    default:
                                                        System.out.println("Opção inválida.");
                                                    break;

                                                }

                                            }while(opSubmenuEstudante1 != 0);
                                        break;

                                        // SUBMENU DE TURMAS PARA ESTUDANTE
                                        case 2:
                                            int opSubmenuEstudante2 = 1;
                                            do{
                                                opcoesTurmaEstudante();
                                                opSubmenuEstudante2 = scanner.nextInt();
                                                Menu.clearBuffer(scanner);

                                                switch(opSubmenuEstudante2){
                                                    case 1:

                                                    break;

                                                    case 2:

                                                    break;

                                                    case 3:

                                                    break;

                                                    case 4:

                                                    break;

                                                    case 0:
                                                        System.out.println("Voltando...");
                                                    break;

                                                    default:
                                                        System.out.println("Opção inválida.");
                                                    break;
                                                }

                                            }while(opSubmenuEstudante2 != 0);
                                        break;

                                        // SUBMENU DO RU PARA ESTUDANTE
                                        case 3:
                                            int opSubmenuEstudante3 = 1;
                                            do{
                                                opcoesRestaurante();
                                                opSubmenuEstudante3 = scanner.nextInt();
                                                Menu.clearBuffer(scanner);

                                                switch(opSubmenuEstudante3){
                                                    case 1:

                                                    break;

                                                    case 2:

                                                    break;

                                                    case 3:

                                                    break;

                                                    case 0:
                                                        System.out.println("Voltando...");
                                                    break;

                                                    default:
                                                        System.out.println("Opção inválida.");
                                                    break;
                                                }

                                            }while(opSubmenuEstudante3 != 0);
                                        break;

                                        // SUBMENU DOS DADOS ESTUDANTE
                                        case 4:
                                            int opSubmenuEstudante4 = 1;
                                            do{
                                                opcoesDadosEstudante();
                                                opSubmenuEstudante4 = scanner.nextInt();
                                                Menu.clearBuffer(scanner);

                                                switch(opSubmenuEstudante4){
                                                    case 1:

                                                    break;

                                                    case 2:

                                                    break;

                                                    case 0:
                                                        System.out.println("Voltando...");
                                                    break;

                                                    default:
                                                        System.out.println("Opção inválida.");
                                                    break;
                                                }

                                            }while(opSubmenuEstudante4 != 0);
                                        break;

                                        // VOLTANDO
                                        case 0:
                                            System.out.println("Voltando...\n");
                                        break;

                                        default:
                                            System.out.println("Opção inválida.");
                                        break;

                                    }
                                }while(opMenuEstudante != 0);
                            break;

                            // OPÇÃO DE CADASTRO
                            case 2:

                            break;
                        }
                    }

                break;



                // MENU DO PROFESSOR ////////////////////////////////////////////////
                case 2:

                break;



                // SAIR ////////////////////////////////////////////////////////////
                case 0:
                    System.out.println("Finalizando o sistema...");
                break;

                // OPÇÃO INVÁLIDA //////////////////////////////////////////////////
                default:
                    System.out.println("Opção inválida.");
                break;
            }

        }while(op1 != 0);

    }

    // Menu Principal
    public static void menuPrincipal(){
        System.out.println("Bem vindo ao sistema da UFERSA");
        System.out.println("Que tipo de usuário você é? ");
        System.out.println("(1)- Estudante");
        System.out.println("(2)- Professor");
        System.out.println("(0)- Sair\n");
    }

    // Opções de Login
    public static void menuLogin(){
        System.out.println("Escolha a opção de entrada:");
        System.out.println("(1)- Login");
        System.out.println("(2)- Cadastro");
        System.out.println("(0)- Voltar\n");
    }

    // Menu do Estudante
    public static void menuEstudante(){
        System.out.println("O que você deseja verificar?");
        System.out.println("(1)- Matrícula");
        System.out.println("(2)- Turmas");
        System.out.println("(3)- Restaurante Universitário");
        System.out.println("(4)- Dados pessoais");
        System.out.println("(0)- Voltar\n");
    }

    // Submenus do Estudante
    public static void opcoesMatriculaEstudante(){
        System.out.println(">>>MENU DE MATRÍCULA");
        System.out.println("(1)- Realizar Matrícula em uma disciplina");
        System.out.println("(2)- Cancelamento de disciplina");
        System.out.println("(3)- Ver comprovante de matrícula");
        System.out.println("(0)- Voltar\n");
    }

    public static void opcoesTurmaEstudante(){
        System.out.println(">>>MENU DE TURMA");
        System.out.println("(1)- Verificar dados da turma");
        System.out.println("(2)- Verificar participantes da turma");
        System.out.println("(3)- Verificar notas");
        System.out.println("(4)- Verificar presenças");
        System.out.println("(0)- Voltar\n");
    }

    public static void opcoesRestaurante(){
        System.out.println(">>>MENU DO RESTAURANTE UNIVERSITÁRIO");
        System.out.println("(1)- Cardápio semanal");
        System.out.println("(2)- Fazer um comentário");
        System.out.println("(3)- Ver comentários");
        System.out.println("(0)- Voltar\n");
    }

    public static void opcoesDadosEstudante(){
        System.out.println(">>>MENU DE PERFIL");
        System.out.println("(1)- Ver dados pessoais");
        System.out.println("(2)- Atualizar dados pessoais");
        System.out.println("(0)- Voltar\n");
    }
}
