package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class AvaliacaoDao {
    
    private static Connection conexaoAvaliacao;

    public AvaliacaoDao(Connection conexaoAvaliacao){
        AvaliacaoDao.conexaoAvaliacao = conexaoAvaliacao;
    }

    public static void inserirAvaliacao(Avaliacao avaliacao) throws SQLException{
        String sql = "INSERT INTO avaliacao (fk_id_aluno, fk_id_turma, nota_1, nota_2, nota_3, nota_recuperacao) VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setInt(1, avaliacao.getAluno().getNumeroMatricula());
            preparedStatement.setInt(2, avaliacao.getTurma().getIdTurma());
            preparedStatement.setDouble(3, avaliacao.getNota1());
            preparedStatement.setDouble(4, avaliacao.getNota2());
            preparedStatement.setDouble(5, avaliacao.getNota3());
            preparedStatement.setDouble(6, avaliacao.getNotaRecuperacao());
        }
    }

    public static Avaliacao buscarAvaliacaoPorId(int id) throws SQLException{
        String sql = "SELECT * FROM avaliacao WHERE id_avaliacao = ?;";

        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return mapearResultSetParaAvaliacao(resultSet);
                }
            }
        }
        return null;
    }

    public static List<Avaliacao> listarAvaliacoesPorAluno(int matriculaAluno) throws SQLException{
        List<Avaliacao> avaliacoesAluno = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao WHERE fk_id_aluno = ?;";

        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setInt(1, matriculaAluno);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    avaliacoesAluno.add(mapearResultSetParaAvaliacao(resultSet));
                }
            }
        }
        return avaliacoesAluno;
    }

    public static List<Avaliacao> listarAvaliacoesPorTurma(int idTurma) throws SQLException{
        List<Avaliacao> avaliacoesTurma = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao WHERE fk_id_turma = ?;";

        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setInt(1, idTurma);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()){
                    avaliacoesTurma.add(mapearResultSetParaAvaliacao(resultSet));
                }
            }
        }
        return avaliacoesTurma;
    }

    public static void atualizarAvaliacao(Avaliacao avaliacao) throws SQLException{
        String sql = "UPDATE avaliacao SET nota_1 = ?, nota_2 = ?, nota_3 = ?, nota_recuperacao = ? WHERE id_avaliacao = ?;";
        
        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setDouble(1, avaliacao.getNota1());
            preparedStatement.setDouble(2, avaliacao.getNota2());
            preparedStatement.setDouble(3, avaliacao.getNota3());
            preparedStatement.setDouble(4, avaliacao.getNotaRecuperacao());
            preparedStatement.setInt(5, avaliacao.getIdAvaliacao());

            preparedStatement.executeUpdate();
        }
    }

    public static void excluirAvaliacao (int idAvaliacao) throws SQLException{
        String sql = "DELETE FROM avaliacao WHERE id_avaliacao = ?;";

        try(PreparedStatement preparedStatement = conexaoAvaliacao.prepareStatement(sql)){
            preparedStatement.setInt(1, idAvaliacao);

            preparedStatement.executeUpdate();
        }
    }

    public static Avaliacao mapearResultSetParaAvaliacao(ResultSet resultSet) throws SQLException{
        int id_avaliacao = resultSet.getInt("id_avaliacao");
        int id_aluno = resultSet.getInt("fk_id_aluno");
        int id_turma = resultSet.getInt("fk_id_turma");
        double nota1 = resultSet.getDouble("nota_1");
        double nota2 = resultSet.getDouble("nota_2");
        double nota3 = resultSet.getDouble("nota_3");
        double notaRecuperacao = resultSet.getDouble("nota_recuperacao");

        // falta negocio pra procuar
        return new Avaliacao(id_avaliacao, AlunoDao.buscarAlunoPorMat(id_aluno), TurmaDao.buscarTurmaPorId(id_turma), nota1, nota2, nota3, notaRecuperacao);
    }
}
