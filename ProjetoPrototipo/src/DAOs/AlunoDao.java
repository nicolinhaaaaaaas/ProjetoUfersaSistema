package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class AlunoDao {
    private static Connection conexaoAluno;

    public AlunoDao(Connection conexaoAluno){
        AlunoDao.conexaoAluno = conexaoAluno;
    }

    public static void inserirAluno(Aluno aluno) throws SQLException{
        String sql = "INSERT INTO aluno (numero_matricula, nome_aluno, email_aluno, senha_aluno) VALUES (?,?,?,?);";

        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql)){
            preparedStatement.setInt(1, aluno.getNumeroMatricula());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setString(3, aluno.getEmail());
            preparedStatement.setString(4, aluno.getSenha());
        }
    }

    public static Aluno buscarAlunoPorMat(int matricula) throws SQLException{
        String sql = "SELECT * FROM aluno WHERE numero_matricula = ?;";

        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql)){
            preparedStatement.setInt(1, matricula);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaAluno(resultSet);
                }
            }
        }
        return null;
    }

    public static Aluno buscarAlunoPorLoginSenha(String email, String senha) throws SQLException{
        String sql = "SELECT * FROM aluno WHERE email_aluno = ? AND senha_aluno = ?;";

        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql)){
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaAluno(resultSet);
                }
            }
        }
        return null;
    }

    public static boolean verificarLoginDisponivel(String email) throws SQLException{
        String sql = "SELECT * FROM aluno WHERE email_aluno = ?;";

        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql)){
            preparedStatement.setString(1, email);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return true;
                } else{
                    return false;
                }
            }
        }
    }

    public static List<Aluno> listarTodosAlunos() throws SQLException{
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno;";

        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql);
        
            ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    alunos.add(mapearResultSetParaAluno(resultSet));
                }
            }
        return alunos;
    }

    public static void atualizarAluno(Aluno aluno) throws SQLException{
        String sql = "UPDATE aluno SET nome_aluno = ?, email_aluno = ?, senha_aluno = ? WHERE numero_matricula = ?;";
        
        try(PreparedStatement preparedStatement = conexaoAluno.prepareStatement(sql)){
            preparedStatement.setString(1, aluno.getNome());
            preparedStatement.setString(2, aluno.getEmail());
            preparedStatement.setString(3, aluno.getSenha());
            preparedStatement.setInt(4, aluno.getNumeroMatricula());

            preparedStatement.executeUpdate();
        }
    }

    public static Aluno mapearResultSetParaAluno(ResultSet resultSet) throws SQLException{
        int matricula = resultSet.getInt("numero_matricula");
        String nome = resultSet.getString("nome_aluno");
        String email = resultSet.getString("email_aluno");
        String senha = resultSet.getString("senha_aluno");

        return new Aluno(matricula, nome, email, senha);
    }

}
