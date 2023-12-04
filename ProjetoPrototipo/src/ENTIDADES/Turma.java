package ProjetoPrototipo.src.ENTIDADES;

public class Turma {
    private int idTurma;
    private String horario;
    private String local;
    private Professor professor;

    public Turma(int idTurma, String horario, String local, Professor professor){
        this.idTurma = idTurma;
        this.horario = horario;
        this.local = local;
        this.professor = professor;
    }

    public Turma( String horario, String local, Professor professor){
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
    
    public String toString(){
        String saida = "";
        saida += "ID da Turma: "+this.idTurma;
        saida += "\tComponente Curricular: "+this.nome;
        saida += "\tLocal: "+this.local;
        saida += "\tHorário: "+this.horario;
        saida += "\nProfessor Responsável: "+this.professor.getNomeProfessor()+"\n";
        return saida;
    }
}
