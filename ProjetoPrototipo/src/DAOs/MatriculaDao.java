package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class MatriculaDao {

    private static Connection conexaoMatricula;

    public MatriculaDao(Connection conexaoMatricula){
        MatriculaDao.conexaoMatricula = conexaoMatricula;
    }

    public static void inserirMatricula(Matricula matricula) throws SQLException{
        String sql = "INSERT INTO matricula (fk_id_aluno, fk_id_turma) VALUES (?, ?, ?);";

        try(PreparedStatement preparedStatement = conexaoMatricula.prepareStatement(sql)){
            preparedStatement.setInt(1, matricula.getAluno().getNumeroMatricula());
            preparedStatement.setInt(2, matricula.getTurma().getIdTurma());
        }
    }

    public static Matricula buscarMatriculaPorId(int id) throws SQLException{
        String sql = "SELECT * FROM matricula WHERE id_matricula = ?;";

        try(PreparedStatement preparedStatement = conexaoMatricula.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaMatricula(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Matricula> listarMatriculasPorAluno(int matriculaAluno) throws SQLException{
        List<Matricula> matriculasAluno = new ArrayList<>();
        String sql = "SELECT * FROM matricula WHERE fk_id_aluno = ?;";

        try(PreparedStatement preparedStatement = conexaoMatricula.prepareStatement(sql)){
            preparedStatement.setInt(1, matriculaAluno);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    matriculasAluno.add(mapearResultSetParaMatricula(resultSet));
                }
            }
        }
        return matriculasAluno;
    }

    public static List<Matricula> listarMatriculasPorTurma(int idTurma) throws SQLException{
        List<Matricula> matriculasTurma = new ArrayList<>();
        String sql = "SELECT * FROM matricula WHERE fk_id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoMatricula.prepareStatement(sql)){
            preparedStatement.setInt(1, idTurma);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    matriculasTurma.add(mapearResultSetParaMatricula(resultSet));
                }
            }
        }
        return matriculasTurma;
    }

    public static void excluirMatricula (int idAluno, int idDisciplina) throws SQLException{
        String sql = "DELETE FROM matricula WHERE fk_id_aluno = ? AND fk_id_disciplina = ?;";

        try(PreparedStatement preparedStatement = conexaoMatricula.prepareStatement(sql)){
            preparedStatement.setInt(1, idAluno);
            preparedStatement.setInt(2, idDisciplina);

            preparedStatement.executeUpdate();
        }
    }

    public static Matricula mapearResultSetParaMatricula(ResultSet resultSet) throws SQLException{
        int id_matricula = resultSet.getInt("id_matricula");
        int id_aluno = resultSet.getInt("fk_id_aluno");
        int id_turma = resultSet.getInt("fk_id_turma");

        // falta coisa de buscar
        return new Matricula(id_matricula, AlunoDao.buscarAlunoPorMat(id_aluno), TurmaDao.buscarTurmaPorId(id_turma));
    }
}
