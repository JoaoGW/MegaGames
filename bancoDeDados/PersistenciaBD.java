package bancoDeDados;

import entidades.Usuario;
import entidades.Jogo;
import entidades.Desenvolvedor;

import java.util.List;
import java.util.ArrayList;

/**
 * Escreva uma descrição da classe PersistenciaBD aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class PersistenciaBD implements IPersistencia{
    BDCadJogos cadJogosDB;

    /**
     * Construtor para objetos da classe PersistenciaBD
     */
    public PersistenciaBD() throws Exception{
        try{
            this.cadJogosDB = new BDCadJogos("megagames");
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void gravarDadosUsuario(Usuario usuario) throws Exception{
        try{
            this.cadJogosDB.gravarDadosUsuarioDB(usuario.getNome(), usuario.getNickname(), usuario.getSenha(), usuario.getTelefone(), usuario.getIdJogo());
        } catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void gravarDadosJogo(Jogo jogo) throws Exception {
        try{
            this.cadJogosDB.gravarDadosJogoDB(jogo.getNome(), jogo.getPreco(), jogo.getAvaliacao(), jogo.getIdDesenvolvedor());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public Integer obterIdDesenvolvedor(String cnpj) throws Exception {
        Integer idDesenvolvedor;
        try{
            idDesenvolvedor = this.cadJogosDB.obterIdDesenvolvedorDB(cnpj);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return idDesenvolvedor;
    }
    
    public void gravarDadosDesenvolvedor(Desenvolvedor desenvolvedor) throws Exception {
        try{
            this.cadJogosDB.gravarDadosDesenvolvedorDB(desenvolvedor.getNome(), desenvolvedor.getCnpj(), desenvolvedor.getEmail());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public void mostrarDados() throws Exception {
        try{
            this.cadJogosDB.obterDadosUsuarioDB();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    public List<String> obterJogosDB() throws Exception {
        List<String> listaJogos = new ArrayList<>();
        try{
            listaJogos = this.cadJogosDB.obterJogosDB();
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return listaJogos;
    }
    
    public Integer obterIdJogo(String nome) throws Exception {
        Integer IdJogo;
        try{
            IdJogo = this.cadJogosDB.obterIdJogoDB(nome);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return IdJogo;
    }
    
    public void inserirJogoBibliotecaDev(Integer idDesenvolvedor, Integer idJogo) throws Exception {
        try{
            this.cadJogosDB.inserirJogoBibliotecaDevDB(idDesenvolvedor, idJogo);
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
