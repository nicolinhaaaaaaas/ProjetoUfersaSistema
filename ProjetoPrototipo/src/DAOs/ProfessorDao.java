package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class ProfessorDao {

    private static Connection conexaoProfessor;

    public ProfessorDao(Connection conexaoProfessor){
        ProfessorDao.conexaoProfessor = conexaoProfessor;
    }

    public static void inserirProfessor(Professor professor) throws SQLException{
        String sql = "INSERT INTO professor (nome_professor, email_professor, senha_professor) VALUES (?,?,?,?);";

        try(PreparedStatement preparedStatement = conexaoProfessor.prepareStatement(sql)){
            preparedStatement.setString(1, professor.getNomeProfessor());
            preparedStatement.setString(2, professor.getEmailProfessor());
            preparedStatement.setString(3, professor.getSenhaProfessor());
        }
    }

    public static Professor buscarProfessorPorId(int id) throws SQLException{
        String sql = "SELECT * FROM Professor WHERE id_professor = ?;";

        try(PreparedStatement preparedStatement = conexaoProfessor.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaProfessor(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Professor> listarTodosprofessores() throws SQLException{
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor;";

        try(PreparedStatement preparedStatement = conexaoProfessor.prepareStatement(sql);
        
            ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    professores.add(mapearResultSetParaProfessor(resultSet));
                }
            }
        return professores;
    }

    public static void atualizarProfessor(Professor professor) throws SQLException{
        String sql = "UPDATE professor SET nome_professor = ?, email_professor = ?, senha_professor = ? WHERE id_professor = ?;";
        
        try(PreparedStatement preparedStatement = conexaoProfessor.prepareStatement(sql)){
            preparedStatement.setString(1, professor.getNomeProfessor());
            preparedStatement.setString(2, professor.getEmailProfessor());
            preparedStatement.setString(3, professor.getSenhaProfessor());
            preparedStatement.setInt(4, professor.getIdProfessor());

            preparedStatement.executeUpdate();
        }
    }
    

    public static Professor mapearResultSetParaProfessor(ResultSet resultSet) throws SQLException{
        int id = resultSet.getInt("id_professor");
        String nome = resultSet.getString("nome_professor");
        String email = resultSet.getString("email_professor");
        String senha = resultSet.getString("senha_professor");

        return new Professor(id, nome, email, senha);
    }
}
