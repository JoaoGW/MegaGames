package entidades;

/**
 * @author 
 * Classe para representar uma pessos
 */
public class Pessoa {
   
    private NomePessoa nome;
    private String telefone;

    public Pessoa(String nome, String telefone) {
        this.nome = new NomePessoa(nome);
        this.telefone = telefone;
    }
    
    public Pessoa(String nome) {
        this.nome = new NomePessoa(nome);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome.getNome();
    }
    
    /**
     * @param _nome the nome to set
     */
    protected void setNome(String nome) {
        this.nome.setNome(nome);
    }
    
    /**
     * @return the idade
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * @param idade the idade to set
     */
    protected void setIdade(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Retorna os dados como string
     */
    public String toString(){
        return("\n\nNome: " + getNome() + "\nTelefone: " + getTelefone());
    }
    
}
