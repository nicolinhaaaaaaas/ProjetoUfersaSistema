package ProjetoPrototipo.src.ENTIDADES;

public class Professor {
    private int idProfessor;
    private String nomeProfessor;
    private String emailProfessor;
    private String senhaProfessor;

    public Professor(int idProfessor, String nomeProfessor, String emailProfessor, String senhaProfessor){
        this.idProfessor = idProfessor;
        this.nomeProfessor = nomeProfessor;
        this.emailProfessor = emailProfessor;
        this.senhaProfessor = senhaProfessor;
    }
    
    public Professor(String nomeProfessor, String emailProfessor, String senhaProfessor){
        this.nomeProfessor = nomeProfessor;
        this.emailProfessor = emailProfessor;
        this.senhaProfessor = senhaProfessor;
    }

    public int getIdProfessor() {
        return idProfessor;
    }
    public void setIdProfessor(int idProfessor) {
        this.idProfessor = idProfessor;
    }
    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
    public String getEmailProfessor() {
        return emailProfessor;
    }
    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }
    public String getSenhaProfessor() {
        return senhaProfessor;
    }
    public void setSenhaProfessor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }
}
