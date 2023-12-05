package ProjetoPrototipo.src.MENU;

import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.Aluno;
import ProjetoPrototipo.src.ENTIDADES.Disciplina;
import ProjetoPrototipo.src.SERVICOS.*;
import java.sql.*;

public class Menu {

    static AlunoServico alunoServico = new AlunoServico();
    static TurmaServico turmaServico = new TurmaServico();

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
    
    public static void cancelarVinculo(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }
    
    // OPÇÕES DO ESTUDANTE /////////////////////////////////////////////////////////////////////

    public static void matriculaDisciplina(Aluno aluno){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Disciplinas disponíveis no sistema:");
            System.out.println(turmaServico.mostrarTodasDisciplinas());
            System.out.println("Digite o ID da disciplina que deseja fazer matrícula: (0)-Cancelar");
            String escolha = entrada.nextLine();
            Disciplina disciplinaEscolhida = turmaServico.buscarDisciplinaPorId(Integer.parseInt(escolha));
            if(disciplinaEscolhida != null){
                System.out.println("Você escolheu a Disciplina: "+disciplinaEscolhida.getNomeDisciplina());
                System.out.println("Turmas disponíveis: ");
                System.out.println(turmaServico.mostrarTurmasDisponiveis(disciplinaEscolhida));
                System.out.println("Digite o Número da turma que deseja se matricular: (0)-Cancelar");
                String escolhaTurma = entrada.nextLine();

                Turma turmaEscolhida = turmaServico.buscarTurmaPorNumeroEDisciplina(Integer.parseInt(escolhaTurma), disciplinaEscolhida);
                if(turmaEscolhida != null){
                    turmaServico.matriculaAluno(aluno, turmaEscolhida);
                }else{
                    System.out.println("Turma não existente. Operação cancelada.");
                }
            }else{
                System.out.println("Disciplina inválida. Operação cancelada.");
            }
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

    public static void verComprovanteMatricula(Aluno aluno){
        System.out.println(turmaServico.turmasCadastradas(aluno));
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
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void loginProfessor(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void adicionarDisciplina(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Estas são as disciplinas já cadastradas no sistema:");
            System.out.println(turmaServico.mostrarTurmasDisponiveis());
            System.out.println("Deseja adicionar uma nova? (1)-Sim (0)-Não");
            String opcao = entrada.nextLine();
            if(opcao.equals("1")){
                System.out.println("Digite o nome do Componente Curricular: ");
                String nomeDisciplina = entrada.nextLine();
                System.out.println("Escolha a carga horária dessa Disciplina (30) ou (60): ");
                String cargaHoraria = entrada.nextLine();

                Disciplina disciplinaTeste = turmaServico.buscarDisciplinaPorNome(nomeDisciplina);
                if(disciplinaTeste != null){
                    System.out.println("A disciplina digitada já está cadastrada no sistema.\nOperação cancelada.");
                }else{
                    int horariaNumero;
                    if(cargaHoraria.equals("30")){
                        horariaNumero = 30;
                        turmaServico.criarDisciplina(nomeDisciplina, horariaNumero);
                    }else if(cargaHoraria.equals("60")){
                        horariaNumero = 60;
                        turmaServico.criarDisciplina(nomeDisciplina, horariaNumero);
                    }else{
                        System.out.println("A carga horária digitada não está disponível.");
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

    public static void atualizarDisciplina(){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Disciplinas cadastradas no sistema: ");
            System.out.println(turmaServico.mostrarTodasDisciplinas());
            System.out.println("Digite o ID daquela que deseja atualizar (0)-Cancelar");
            String opcao = entrada.nextLine();
            Disciplina disciplinaSolicitada = turmaServico.buscarDisciplinaPorId(Integer.parseInt(opcao));
            if(disciplinaSolicitada != null){
                System.out.println("Dados atuais da disciplina solicitada: ");
                System.out.println(disciplinaSolicitada.toString());
                System.out.println("Deseja atualizá-los? (1)-Sim (0)-Não");
                String opcao2 = entrada.nextLine();
                if(opcao2.equals("1")){
                    System.out.println("Digite o novo nome desse Componente Curricular: ");
                    String novoNome = entrada.nextLine();
                    System.out.println("Escolha a carga horária dessa Disciplina (30) ou (60): ");
                    String novaCargaHoraria = entrada.nextLine();

                    Disciplina disciplinaTeste = turmaServico.buscarDisciplinaPorNome(nomeDisciplina);
                    if(disciplinaTeste != null){
                        System.out.println("A disciplina digitada já está cadastrada no sistema.\nOperação cancelada.");
                    }else{
                        if(novaCargaHoraria.equals("30")){
                            disciplinaSolicitada.setNomeDisciplina(novoNome);
                            disciplinaSolicitada.setCargaHoraria(30);
                            turmaServico.atualizarDisciplina(disciplinaSolicitada);
                        }else if(novaCargaHoraria.equals("60")){
                            disciplinaSolicitada.setNomeDisciplina(novoNome);
                            disciplinaSolicitada.setCargaHoraria(60);
                            turmaServico.atualizarDisciplina(disciplinaSolicitada);
                        }else{
                            System.out.println("A carga horária digitada não está disponível.");
                        }
                    }            
                }else{
                    System.out.println("Operação cancelada.");
                }
            }else{
                System.out.println("ID solicitado não corresponde à uma disciplina. Operação cancelada.");
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    } 

    public static void excluirDisciplina(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void adicionarTurma(Professor professor){
        Scanner entrada = new Scanner(System.in);

        try{
            System.out.println("Disciplinas cadastradas no sistema: ");
            System.out.println(turmaServico.mostrarTodasDisciplinas());
            System.out.println("Digite o ID da disciplina na qual deseja adicionar uma turma: (0)-Cancelar");
            String idDisciplina = entrada.nextLine();
            if(idDisciplina.equals("0")){
                System.out.println("Operação cancelada.");
            }else{
                 Disciplina disciplinaSolicitada = turmaServico.buscarDisciplinaPorId(Integer.parseInt(idDisciplina));

                if(disciplinaSolicitada != null){
                    System.out.println("Dados da disciplina: "+disciplinaSolicitada.toString());
                    System.out.println("Turmas disponíveis da disciplina: ");
                    System.out.println(turmaServico.mostrarTurmasDisponiveis(disciplinaSolicitada));
                    System.out.println("deseja adicionar uma nova turma? (1)-Sim (0)-Não");
                    String opcao = entrada.nextLine();
                    if(opcao.equals("1")){
                        System.out.println("Por favor, digite o local da aula: (EX: 'Bloco 1, sala 3')");
                        String local = entrada.nextLine();
                        System.out.println("Por favor, digite o horário da aula: (EX: '09:45 - 11:55')");
                        String horario = entrada.nextLine();
                        turmaServico.criarTurma();

                    }else{
                        System.out.println("Operação cancelada.");
                    }
                }else{
                    System.out.println("Disciplina não encontrada. Operação cancelada.");
                }
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void atualizarTurma(Professor professor){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    public static void excluirTurma(){
        Scanner entrada = new Scanner(System.in);

        try{

        }catch(InputMismatchException e){
            e.printStackTrace();
        }finally{
            clearBuffer(entrada);
        }
    }

    // CLEAR BUFFER ///////////////////////////////////////////////////////////////////////////

    public static void clearBuffer(Scanner scanner){
        if(scanner.hasNextLine()){
            scanner.nextLine();
        }
    }
}
