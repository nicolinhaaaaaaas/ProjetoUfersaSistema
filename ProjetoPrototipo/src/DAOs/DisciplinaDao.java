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

    public
}
