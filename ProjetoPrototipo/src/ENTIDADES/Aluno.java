package ProjetoPrototipo.src.ENTIDADES;

public class Aluno {
    private int numeroMatricula;
    private String nome;
    private String email;
    private String senha;

    public Aluno(int numeroMatricula, String nome, String email, String senha){
        this.numeroMatricula = numeroMatricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Aluno(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }
    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String toString(){
        String saida = "";
        saida += "Nº Matrícula: "+this.numeroMatricula;
        saida += "\tNome: "+this.nome;
        saida += "\tLogin: "+this.email;
        saida += "\tSenha: "+this.senha+"\n";
        return saida;
    }
    
}
