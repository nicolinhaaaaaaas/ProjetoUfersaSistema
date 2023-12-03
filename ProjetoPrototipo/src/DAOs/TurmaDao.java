package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class TurmaDao {
    
    private static Connection conexaoTurma;

    public TurmaDao(Connection conexaoTurma){
        TurmaDao.conexaoTurma = conexaoTurma;
    }

    public static void inserirTurma(Turma turma) throws SQLException{
        String sql = "INSERT INTO turma (nome_turma, horario, local_turma, fk_id_professor) VALUES (?,?,?,?,?);";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setString(1, turma.getNome());
            preparedStatement.setString(2, turma.getHorario());
            preparedStatement.setString(3, turma.getLocal());
            preparedStatement.setInt(4, turma.getProfessor().getIdProfessor());
        }
    }

    public static Turma buscarTurmaPorId(int id) throws SQLException{
        String sql = "SELECT * FROM turma WHERE id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaTurma(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Turma> listarTodasturmas() throws SQLException{
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM turma;";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql);
        
            ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    turmas.add(mapearResultSetParaTurma(resultSet));
                }
            }
        return turmas;
    }

    public static void atualizarturma(Turma turma) throws SQLException{
        String sql = "UPDATE turma SET nome_turma = ?, horario = ?, local = ?, fk_id_professor = ? WHERE id_turma = ?;";
        
        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setString(1, turma.getNome());
            preparedStatement.setString(2, turma.getHorario());
            preparedStatement.setString(3, turma.getLocal());
            preparedStatement.setInt(4, turma.getProfessor().getIdProfessor());
            preparedStatement.setInt(5, turma.getIdTurma());

            preparedStatement.executeUpdate();
        }
    }

    public static Turma mapearResultSetParaTurma(ResultSet resultSet) throws SQLException{
        int id_turma = resultSet.getInt("id_turma");
        String nome_turma = resultSet.getString("nome_turma");
        String horario = resultSet.getString("horario");
        String local_turma = resultSet.getString("local_turma");
        int id_professor = resultSet.getInt("fk_id_professor");

        // falta fazer um negocio de buscar o turma
        return new Turma(id_turma, nome_turma, horario, local_turma, ProfessorDao.buscarProfessorPorId(id_professor));
    }
}
