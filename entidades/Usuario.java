package entidades;

/**
 * Escreva uma descrição da classe Aluno aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Usuario extends Pessoa {
    // atributos (variaveis de instancia)
    private String nickname;
    private String senha;
    private Integer idJogo;

    /**
     * Construtor para objetos da classe Aluno
     * @param nome
     * @param idade
     * @param rg
     * @param ra
     * @param curso
     * @param disciplinas
     */
    public Usuario(String nome, String telefone, String nickname, String senha, Integer jogo) {
        // inicializa variáveis de instância
        super(nome, telefone);
        setNickname(nickname);
        setSenha(senha);
        setJogo(jogo);
    }
    
    /**
     * @return the ra
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param ra the ra to set
     */
    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * @return the curso
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param curso the curso to set
     */
    private void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * @return the curso
     */
    public int getIdJogo() {
        return idJogo;
    }

    /**
     * @param curso the curso to set
     */
    private void setJogo(int idJogo) {
        this.idJogo = idJogo;
    }
    
    /**
     * toString
     *
     * @return String, dados de uma pessoa (incluindo altura, peso e imc)
     */
    public String toString(){
        return (super.toString() + "\nNickname: " + getNickname()  + "\nSenha: " + getSenha() + "\nJogo: " + getIdJogo());
    }
}
