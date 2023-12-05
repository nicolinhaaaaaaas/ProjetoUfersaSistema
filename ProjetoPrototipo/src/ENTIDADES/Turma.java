package ProjetoPrototipo.src.ENTIDADES;

public class Turma {
    private int idTurma;
    private int numeroTurma;
    private String horario;
    private String local;
    private Professor professor;
    private Disciplina disciplina;
    private int participantes;

    public Turma(int idTurma, int numeroTurma, String horario, String local, Professor professor, Disciplina disciplina, int participantes){
        this.idTurma = idTurma;
        this.numeroTurma = numeroTurma;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
        this.disciplina = disciplina;
        this.participantes = participantes;
    }

    public Turma(int numeroTurma, String horario, String local, Professor professor, Disciplina disciplina, int participantes){
        this.numeroTurma = numeroTurma;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
        this.disciplina = disciplina;
        this.participantes = participantes;
    }
    
    public int getNumeroTurma() {
        return numeroTurma;
    }
    public void setNumeroTurma(int numeroTurma) {
        this.numeroTurma = numeroTurma;
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
    public int getParticipantes() {
        return participantes;
    }
    public void setParticipantes(int participantes) {
        this.participantes = participantes;
    }
    
    
    public String toString(){
        String saida = "";
        saida += "Nº da Turma: "+this.numeroTurma;
        saida += "\tComponente Curricular: "+disciplina.getNomeDisciplina();
        saida += "\tLocal: "+this.local;
        saida += "\tHorário: "+this.horario;
        saida += "\tParticipantes: "+this.participantes+" / 30";
        saida += "\nProfessor Responsável: "+this.professor.getNomeProfessor()+"\n";
        return saida;
    }

    

    
}
