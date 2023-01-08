public class Pessoa {
    private String nome;
    private String sexo;
    private int idade;

    public Pessoa (String nome, String sexo, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSexo(){
        return this.sexo;
    }

    public void setSeco(String sexo){
        this.sexo = sexo;
    }

    public int getIdade(){
        return this.idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void fazerAniver(){
        this.idade = idade + 1;
    }
    
}
