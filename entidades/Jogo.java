package entidades;


/**
 * Escreva uma descrição da classe Jogo aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Jogo extends Texto{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private float preco;
    private float avaliacao;
    int idDesenvolvedor;

    /**
     * Construtor para objetos da classe Jogo
     */
    public Jogo(String nome, float preco, float avaliacao, int idDesenvolvedor){
        super(nome);
        setNome(super.getTxt());
        this.preco = preco;
        this.avaliacao = avaliacao;
        this.idDesenvolvedor = idDesenvolvedor;
    }
    
    public String getNome(){
        return nome;
    }
    
    private void setNome(String nome){
        this.nome = nome;
    }

    public float getPreco(){
        return preco;
    }
    
    private void setPreco(float preco){
        this.preco = preco;
    }
    
    public float getAvaliacao(){
        return avaliacao;
    }
    
    private void setAvaliacao(float avaliacao){
        this.avaliacao = avaliacao;
    }
    
    public int getIdDesenvolvedor(){
        return idDesenvolvedor;
    }
    
    private void setIdDesenvolvedor(int idDesenvolvedor){
        this.idDesenvolvedor = idDesenvolvedor;
    }
    
    public String toString(){
        return (super.toString() + "\nPreco: " + getPreco() + "\nAvaliacao: " + getAvaliacao());
    }
}
