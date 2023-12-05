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
        String sql = "INSERT INTO turma (numero_turma, horario, local_turma, participantes, fk_id_professor, fk_id_disciplina) VALUES (?,?,?,?,?,?);";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, turma.getNumeroTurma());
            preparedStatement.setString(2, turma.getHorario());
            preparedStatement.setString(3, turma.getLocal());
            preparedStatement.setInt(4, turma.getParticipantes());
            preparedStatement.setInt(5, turma.getProfessor().getIdProfessor());
            preparedStatement.setInt(6, turma.getDisciplina().getIdDisciplina());
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

    public static Turma buscarTurmaPorNumeroEDisciplina(int numero, Disciplina disciplina) throws SQLException{
        String sql = "SELECT * FROM turma WHERE numero_turma = ? AND fk_id_disciplina = ?;";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, numero);
            preparedStatement.setInt(2, disciplina.getIdDisciplina());

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaTurma(resultSet;)
                }
            }
        }
        return null;
    }

    public static List<Turma> listarTodasTurmas() throws SQLException{
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

    public static List<Turma> listarTurmasPorDisciplina(int idDisciplina) throws SQLException{
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM turma WHERE fk_id_disciplina = ?;";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, idDisciplina);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    turmas.add(mapearResultSetParaTurma(resultSet));
                }
            }
        }
        return turmas;
    }   

    public static void mudarNumeroParticipantes(Turma turma) throws SQLException{
        String sql = "UPDATE turma SET participantes = ? WHERE id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, turma.getParticipantes());
            preparedStatement.setInt(2, turma.getIdTurma());

            preparedStatement.executeUpdate();
        }
    }

    public static void atualizarTurma(Turma turma) throws SQLException{
        String sql = "UPDATE turma SET numero_turma = ?, horario = ?, local = ?, fk_id_professor = ?, fk_id_disciplina WHERE id_turma = ?;";
        
        try(PreparedStatement preparedStatement = conexaoTurma.prepareStatement(sql)){
            preparedStatement.setInt(1, turma.getNumeroTurma());
            preparedStatement.setString(2, turma.getHorario());
            preparedStatement.setString(3, turma.getLocal());
            preparedStatement.setInt(4, turma.getProfessor().getIdProfessor());
            preparedStatement.setInt(5, turma.getDisciplina().getIdDisciplina());
            preparedStatement.setInt(6, turma.getIdTurma());

            preparedStatement.executeUpdate();
        }
    }

    public static Turma mapearResultSetParaTurma(ResultSet resultSet) throws SQLException{
        int id_turma = resultSet.getInt("id_turma");
        int numero_turma = resultSet.getInt("numero_turma");
        String horario = resultSet.getString("horario");
        String local_turma = resultSet.getString("local_turma");
        int id_professor = resultSet.getInt("fk_id_professor");
        int id_disciplina = resultSet.getInt("fk_id_disciplina");
        int participantes = resultSet.getInt("participantes")

        // falta fazer um negocio de buscar o turma
        return new Turma(id_turma, numero_turma, horario, local_turma, ProfessorDao.buscarProfessorPorId(id_professor), DisciplinaDao.buscarDisciplinaPorId(id_disciplina), participantes);
    }
}
