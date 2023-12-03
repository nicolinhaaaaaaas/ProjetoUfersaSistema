package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;
import java.sql.Date;

import ProjetoPrototipo.src.ENTIDADES.*;

public class PresencaDao {
    
    private static Connection conexaoPresenca;

    public PresencaDao(Connection conexaoPresenca){
        PresencaDao.conexaoPresenca = conexaoPresenca;
    }

    public static void inserirPresenca(Presenca presenca) throws SQLException{
        String sql = "INSERT INTO presenca (fk_id_aluno, fk_id_turma, data_presenca, presente) VALUES (?, ?, ?, ?)";

        try(PreparedStatement preparedStatement = conexaoPresenca.prepareStatement(sql)){
            preparedStatement.setInt(1, presenca.getAluno().getNumeroMatricula());
            preparedStatement.setInt(2, presenca.getTurma().getIdTurma());
            preparedStatement.setDate(3, presenca.getData());
            preparedStatement.setBoolean(4, presenca.isPresente());
        }
    }

    public static Presenca buscarPresencaPorId(int id) throws SQLException{
        String sql = "SELECT * FROM presenca WHERE id_presenca = ?;";

        try(PreparedStatement preparedStatement = conexaoPresenca.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaPresenca(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Presenca> listarPresencasPorAlunoETurma(int matriculaAluno, int idTurma) throws SQLException{
        List<Presenca> presencasAlunoPorTurma = new ArrayList<>();
        String sql = "SELECT * FROM presenca WHERE fk_id_aluno = ? AND fk_id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoPresenca.prepareStatement(sql)){
            preparedStatement.setInt(1, matriculaAluno);
            preparedStatement.setInt(2, idTurma);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    presencasAlunoPorTurma.add(mapearResultSetParaPresenca(resultSet));
                }
            }
        }
        return presencasAlunoPorTurma;
    }

    public static List<Presenca> listarPresencasPorTurma(int idTurma) throws SQLException{
        List<Presenca> presencasPorTurma = new ArrayList<>();
        String sql = "SELECT * FROM presenca WHERE fk_id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoPresenca.prepareStatement(sql)){
            preparedStatement.setInt(1, idTurma);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    presencasPorTurma.add(mapearResultSetParaPresenca(resultSet));
                }
            }
        }
        return presencasPorTurma;
    }

    public static void excluirPresenca(int idPresenca) throws SQLException{
        String sql = "DELETE FROM presenca WHERE id_presenca = ?;";

        try(PreparedStatement preparedStatement = conexaoPresenca.prepareStatement(sql)){
            preparedStatement.setInt(1, idPresenca);

            preparedStatement.executeUpdate();
        }
    }

    public static Presenca mapearResultSetParaPresenca(ResultSet resultSet) throws SQLException{
        int id_presenca = resultSet.getInt("id_presenca");
        int id_aluno = resultSet.getInt("fk_id_aluno");
        int id_turma = resultSet.getInt("fk_id_turma");
        Date data = resultSet.getDate("data_presenca");
        boolean presente = resultSet.getBoolean("presente");
        
        // falta coisa pra buscar
        return new Presenca(id_presenca, AlunoDao.buscarAlunoPorMat(id_aluno), TurmaDao.buscarTurmaPorId(id_turma), data, presente);
    }
}
