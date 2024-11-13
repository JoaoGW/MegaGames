package entidades;


/**
 * Escreva uma descrição da classe Desenvolvedores aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Desenvolvedor extends Pessoa{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String cnpj;
    private String email;

    /**
     * Construtor para objetos da classe Desenvolvedores
     */
    public Desenvolvedor(String nome, String cnpj, String email){
        super(nome);
        this.cnpj = cnpj;
        this.email = email;
    }

    public String getCnpj(){
        return cnpj;
    }
    
    private void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public String getEmail(){
        return email;
    }
    
    private void setEmail(String email){
        this.email = email;
    }
    
    public String toString(){
        return (super.toString() + "\nCNPJ: " + getCnpj() + "\nE-mail: " + getEmail());
    }
}
