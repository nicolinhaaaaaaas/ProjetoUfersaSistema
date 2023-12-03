package ProjetoPrototipo.src.SERVICOS;

import java.sql.SQLException;
import java.util.*;
import ProjetoPrototipo.src.DAOs.AlunoDao;
import ProjetoPrototipo.src.ENTIDADES.*;

public class AlunoServico {
    
    public void cadastrarAluno(String nome, String email, String senha) throws SQLException{
        try{
            Aluno novoAluno = new Aluno(nome, email, senha);
            System.out.println("Cadastro bem sucedido!");
            AlunoDao.inserirAluno(novoAluno);
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public boolean verificarLogin(String email) throws SQLException{
        if(AlunoDao.verificarLoginDisponivel(email) == true){
            return true;
        }else{
            return false;
        }
    }

    public Aluno loginAluno(String email, String senha) throws SQLException{
        try{
            if(AlunoDao.listarTodosAlunos().isEmpty()){
                System.out.println("Não há alunos cadastrados no sistema.");
            }
            else{
                Aluno alunoLogin = AlunoDao.buscarAlunoPorLoginSenha(email, senha);
                if(alunoLogin != null){
                    return alunoLogin;
                }else{
                    return null;
                }
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
        return null;
    }

    public Aluno getAlunoPorMat(int matricula) throws SQLException{
        Aluno alunoSolicitado = AlunoDao.buscarAlunoPorMat(matricula);
        if(alunoSolicitado != null){
            return alunoSolicitado;
        }else{
            return null;
        }
    }

    public void atualizarAluno(Aluno alunoAtualizado) throws SQLException{
        try{
            AlunoDao.atualizarAluno(alunoAtualizado);
            System.out.println("Dados do aluno atualizados!");
            System.out.println(alunoAtualizado.toString());
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public void apagarAluno(int matricula){
        
    }
}
