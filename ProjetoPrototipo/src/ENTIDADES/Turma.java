package ProjetoPrototipo.src.ENTIDADES;

public class Turma {
    private int idTurma;
    private String horario;
    private String local;
    private Professor professor;
    private Disciplina disciplina;

    public Turma(int idTurma, String horario, String local, Professor professor, Disciplina disciplina){
        this.idTurma = idTurma;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Turma( String horario, String local, Professor professor, Disciplina disciplina){
        this.horario = horario;
        this.local = local;
        this.professor = professor;
        this.disciplina = disciplina;
    }
    
    public int getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
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
    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public String toString(){
        String saida = "";
        saida += "ID da Turma: "+this.idTurma;
        saida += "\tComponente Curricular: "+disciplina.getNomeDisciplina();
        saida += "\tLocal: "+this.local;
        saida += "\tHorário: "+this.horario;
        saida += "\nProfessor Responsável: "+this.professor.getNomeProfessor()+"\n";
        return saida;
    }

    
}
