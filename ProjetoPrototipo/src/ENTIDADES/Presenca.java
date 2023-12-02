package ProjetoPrototipo.src.ENTIDADES;
import java.util.*;

public class Presenca {
    private int idPresenca;
    private Aluno aluno;
    private Turma turma;
    private Date data;
    private boolean presente;

    public Presenca(int idPresenca, Aluno aluno, Turma turma, Date data, boolean presente){
        this.idPresenca = idPresenca;
        this.aluno = aluno;
        this.turma = turma;
        this.data = data;
        this.presente = presente;
    }

    public Presenca(Aluno aluno, Turma turma, Date data, boolean presente){
        this.aluno = aluno;
        this.turma = turma;
        this.data = data;
        this.presente = presente;
    }

    public int getIdPresenca() {
        return idPresenca;
    }
    public void setIdPresenca(int idPresenca) {
        this.idPresenca = idPresenca;
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public boolean isPresente() {
        return presente;
    }
    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
