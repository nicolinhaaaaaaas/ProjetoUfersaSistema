package ProjetoPrototipo.src.ENTIDADES;

public class Turma {
    private int idTurma;
    private String nome;
    private String horario;
    private String local;
    private Professor professor;

    public Turma(int idTurma, String nome, String horario, String local, Professor professor){
        this.idTurma = idTurma;
        this.nome = nome;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
    }

    public Turma(String nome, String horario, String local, Professor professor){
        this.nome = nome;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
    }
    
    public int getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
}
