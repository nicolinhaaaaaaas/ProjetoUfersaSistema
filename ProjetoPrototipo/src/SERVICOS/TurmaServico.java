package ProjetoPrototipo.src.SERVICOS;

import java.util.InputMismatchException;

import ProjetoPrototipo.src.DAOs.DisciplinaDao;
import ProjetoPrototipo.src.DAOs.MatriculaDao;
import ProjetoPrototipo.src.DAOs.TurmaDao;
import ProjetoPrototipo.src.ENTIDADES.*;

public class TurmaServico {
    
    public void matriculaAluno(Aluno aluno, Turma turma){
        try{
            if(turma.getParticipantes() < 30){
                Matricula novaMatricula = new Matricula(aluno, turma);
                int participantesAtuais = turma.getParticipantes() + 1;
                turma.setParticipantes(participantesAtuais);
                System.out.println("Matrícula concluída!");
                System.out.println(novaMatricula.toString());
            }else{
                System.out.println("Turma chegou ao limite de participantes. Desculpe.");
            }
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public String turmasCadastradas(Aluno aluno){
        String turmasPorAluno = "";
        for(Matricula matricula : MatriculaDao.listarMatriculasPorAluno(aluno.getNumeroMatricula())){
            turmasPorAluno += matricula.toString();
        }
        return turmasPorAluno;
    }

    public void cancelarMatricula(Aluno aluno, Turma turma){
        MatriculaDao.excluirMatricula(aluno.getNumeroMatricula(), turma.getDisciplina().getIdDisciplina());
        System.out.println("Matrícula cancelada com sucesso!");
        int participantes = turma.getParticipantes() - 1;
        turma.setParticipantes(participantes);
        mudarParticipantes(turma);
    }

    public void criarTurma(String horario, String local, Professor professor, Disciplina disciplina){
        try{
            int numeroTurma = TurmaDao.listarTurmasPorDisciplina(disciplina.getIdDisciplina()).size() + 1;
            Turma novaTurma = new Turma(numeroTurma, horario, local, professor, disciplina, 0);
            TurmaDao.inserirTurma(novaTurma);
            System.out.println("Turma adicionada com sucesso!");
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public String mostrarTurmasDisponiveis(Disciplina disciplina){
        String turmasDisponiveis = "";
        for(Turma turma : TurmaDao.listarTurmasPorDisciplina(disciplina.getIdDisciplina())){
            turmasDisponiveis += turma.toString();
        }
        return turmasDisponiveis;
    }

    public Turma buscarTurmaPorNumeroEDisciplina(int numero, Disciplina disciplina){
        Turma turmaSolicitada = TurmaDao.buscarTurmaPorNumeroEDisciplina(numero, disciplina);
        if(turmaSolicitada != null){
            return turmaSolicitada;
        }else{
            return null;
        }
    }

    public String mostrarAlunosPorTurma(Turma turma){
        String alunosPorTurma = "";
        for(Matricula matricula : MatriculaDao.listarMatriculasPorTurma(turma.getIdTurma())){
            alunosPorTurma += matricula.toString();
        }
        return alunosPorTurma;
    }

    public void mudarParticipantes(Turma turma){
        try{
            TurmaDao.mudarNumeroParticipantes(turma);
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public void criarDisciplina(String nomeDisciplina, int cargaHoraria){
        try{
            Disciplina novaDisciplina = new Disciplina(nomeDisciplina, cargaHoraria);
            DisciplinaDao.inserirDisciplina(novaDisciplina);
            System.out.println("Disciplina cadastrada com sucesso!");
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public Disciplina buscarDisciplinaPorNome(String nomeDisciplina){
        Disciplina disciplinaSolicitada = DisciplinaDao.buscarDisciplinaPorNome(nomeDisciplina);
        if(disciplinaSolicitada != null){
            return disciplinaSolicitada;
        }else{
            return null;
        }
    }

    public Disciplina buscarDisciplinaPorId(int id){
        Disciplina disciplinaSolicitada = DisciplinaDao.buscarDisciplinaPorId(id);
        if(disciplinaSolicitada != null){
            return disciplinaSolicitada;
        }else{
            return null;
        }
    }

    public String mostrarTodasDisciplinas(){
        String disciplinasDisponiveis = "";
        for(Disciplina disciplina : DisciplinaDao.listarTodasDisciplinas()){
            disciplinasDisponiveis += disciplina.toString();
        }
        return disciplinasDisponiveis;
    }

    public void atualizarDisciplina(Disciplina disciplina){
        try{
            DisciplinaDao.atualizarDisciplina(disciplina);
            System.out.println("Dados da disciplina atualizados!");
            System.out.println(disciplina.toString());
        }catch(InputMismatchException e){
            e.printStackTrace();
        }
    }

    public void apagarDisciplina(){

    }
}
