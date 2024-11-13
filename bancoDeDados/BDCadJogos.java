package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 * Escreva uma descrição da classe BDCadFilmes aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class BDCadJogos{
    Connection con;
    Statement st;
    String strConexao = "jdbc:mysql://localhost:3306/"; // + Nome do Banco = CadJogos

    BDCadJogos(String nomeDB) throws Exception{
        String url = this.strConexao + nomeDB;
        this.con = conectarDB(url, "root", "root");
        this.st = con.createStatement();
    }

    /**
     * Method conectarDB
     *
     * @param url - string de conexao
     * @param nomeDB - nome do banco de dados 
     * @param user - usuario do banco de dados
     * @param password - senha do usuario
     * @return The return value
     */
    private Connection conectarDB(String url, String user, String password) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            return DriverManager.getConnection(url,user, password);
        }
        catch(Exception e) {
            throw new Exception(e.getMessage());
        }       
    }

    public void gravarDadosDesenvolvedorDB(String nome, String cnpj, String email)  throws Exception {
        try{
            String SQL = ("INSERT INTO desenvolvedores (nome, cnpj, email)" + "VALUES ('" + nome + "', '" + cnpj + "', '" + email + "')");
            st.execute(SQL);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }          
    }
    
    public Integer obterIdDesenvolvedorDB(String cnpj) throws Exception {
        String SQL = ("SELECT id FROM desenvolvedores WHERE cnpj = '" + cnpj + "'");
        try (ResultSet rs = st.executeQuery(SQL)) {
            if (rs.next()) {
                return rs.getInt("id"); // Retorna o ID encontrado
            } else {
                return null; // Desenvolvedor não encontrado
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public void gravarDadosJogoDB(String nome, float preco, float avaliacao, Integer idDesenvolvedor)  throws Exception {
        try{
            String SQL = ("INSERT INTO jogos (nome, preco, avaliacao, iddesenvolvedor) " + "VALUES ('" + nome + "', " + preco + ", " + avaliacao + ", " + idDesenvolvedor + ")");
            st.execute(SQL);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }          
    }
    
    public void gravarDadosUsuarioDB(String nome, String nickname, String senha, String telefone, Integer idJogo)  throws Exception {
        try{
            String SQL = ("INSERT INTO usuarios (nome, nickname, senha, telefone, idJogo) " + "VALUES ('"+ nome + "','"+ nickname + "','" + senha + "','" + telefone + "'," + idJogo + ")");
            st.execute(SQL);
        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    public List<String> obterJogosDB() throws Exception {
        List<String> listaJogos = new ArrayList<>();
        
        try{
            String SQL = ("SELECT nome FROM jogos ORDER BY nome ASC");
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()){
                listaJogos.add(rs.getString("nome"));
            }

        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
        
        return listaJogos;
    }
    
    public Integer obterIdJogoDB(String nome) throws Exception {
        String SQL = ("SELECT id FROM jogos WHERE nome = '" + nome + "'");
        try (ResultSet rs = st.executeQuery(SQL)) {
            if (rs.next()) {
                return rs.getInt("id"); // Retorna o ID do jogo se já existir
            } else {
                return null; // Jogo não encontrado
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    
    public void inserirJogoBibliotecaDevDB(Integer idDesenvolvedor, Integer idJogo) throws Exception {
        try {
            String SQL = ("INSERT INTO bibliotecasdev (desenvolvedores, jogos) VALUES (" + idDesenvolvedor + ", " + idJogo + ")");
            st.execute(SQL);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    
    public void obterDadosUsuarioDB() throws Exception { //Listar em uma tabela
        /*List<String> dados = new ArrayList<>();
        
        try{
            String SQL = ("SELECT nome, nickname, senha, telefone, idJogo FROM usuarios");
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next())
                String linha = rs.getString("nome") + rs.getInt("valorCalc")+"\t"+rs.getInt("valorForn")+"\t"+rs.getString("status")+"\t"+rs.getInt("tentativa");

        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }          */
    }
}
