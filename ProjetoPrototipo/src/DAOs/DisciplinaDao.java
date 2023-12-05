package ProjetoPrototipo.src.DAOs;

import java.sql.*;
import java.util.*;

import ProjetoPrototipo.src.ENTIDADES.*;

public class DisciplinaDao {
    
    private static Connection conexaoDisciplina;

    public DisciplinaDao(Connection conexaoDisciplina){
        DisciplinaDao.conexaoDisciplina = conexaoDisciplina;
    }

    public static void inserirDisciplina(Disciplina disciplina) throws SQLException{

    }

    public static Disciplina buscarDisciplinaPorId(int id) throws SQLException{

    }

    public static Disciplina buscarDisciplinaPorNome(String nome) throws SQLException{

    }

    public static List<Disciplina> listarTodasDisciplinas() throws SQLException{ 

    }

    public static void atualizarDisciplina(Disciplina disciplina){

    }

    public static void excluirDisciplina(){

    }

    public static Turma mapearResultSetParaDisciplina(ResultSet resultSet) throws SQLException{
        int id_Disciplina = resultSet.getInt("id_disciplina");
        String nome_disciplina = resultSet.getString("nome_disciplina");
        int carga_horaria = resultSet.getInt("carga_horaria");

        // falta fazer um negocio de buscar o turma
        return new Disciplina(id_Disciplina, nome_disciplina, carga_horaria);
    }
}
