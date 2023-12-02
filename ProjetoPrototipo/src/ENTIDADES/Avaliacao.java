package ProjetoPrototipo.src.ENTIDADES;

public class Avaliacao {
    private int idAvaliacao;
    private Aluno aluno;
    private Turma turma;
    private double nota1;
    private double nota2;
    private double nota3;
    private double notaRecuperacao;

    public Avaliacao(int idAvaliacao, Aluno aluno, Turma turma, double nota1, double nota2, double nota3, double notaRecuperacao){
        this.idAvaliacao = idAvaliacao;
        this.aluno = aluno;
        this.turma = turma;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaRecuperacao = notaRecuperacao;
    }

    public Avaliacao(Aluno aluno, Turma turma, double nota1, double nota2, double nota3, double notaRecuperacao){
        this.aluno = aluno;
        this.turma = turma;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.notaRecuperacao = notaRecuperacao;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }
    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
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
    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }
    public double getNotaRecuperacao() {
        return notaRecuperacao;
    }
    public void setNotaRecuperacao(double notaRecuperacao) {
        this.notaRecuperacao = notaRecuperacao;
    }

}
