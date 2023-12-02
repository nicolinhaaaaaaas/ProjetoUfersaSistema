package ProjetoPrototipo.src.ENTIDADES;

public class Matricula {
    private int idMatricula;
    private Aluno aluno;
    private Turma turma;

    public Matricula(int idMatricula, Aluno aluno, Turma turma){
        this.idMatricula = idMatricula;
        this.aluno = aluno;
        this.turma = turma;
    }

    public Matricula(Aluno aluno, Turma turma){
        this.aluno = aluno;
        this.turma = turma;
    }

    public int getIdMatricula() {
        return idMatricula;
    }
    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
