package ProjetoPrototipo.src.ENTIDADES;

public class Disciplina {
    private int idDisciplina;
    private String nomeDisciplina;
    private int cargaHoraria;

    public Disciplina(int idDisciplina, String nomeDisciplina, int cargaHoraria){
        this.idDisciplina = idDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public Disciplina(String nomeDisciplina, int cargaHoraria){
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }
    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String toString(){
        String saida = "";
        saida += "ID: "+this.idDisciplina;
        saida += "\tComponente curricular: "+this.nomeDisciplina;
        saida += "\tCarga horária: "+this.cargaHoraria+" Horas\n";
        return saida;
    }
}


