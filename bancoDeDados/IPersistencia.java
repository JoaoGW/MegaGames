package bancoDeDados;

import entidades.Usuario;
import entidades.Jogo;
import entidades.Desenvolvedor;

import java.util.List;


/**
 * Escreva a descrição da interface IPersistencia aqui.
 * 
 * @author (seu nome aqui) 
 * @version (um número da versão ou data aqui)
 */

public interface IPersistencia{
    public void gravarDadosUsuario(Usuario usuario) throws Exception;
    public void gravarDadosJogo(Jogo jogo) throws Exception;
    public void gravarDadosDesenvolvedor(Desenvolvedor desenvolvedor) throws Exception;
    public void mostrarDados() throws Exception;
    public List<String> obterJogosDB() throws Exception;
    public Integer obterIdDesenvolvedor(String cnpj) throws Exception;
    public Integer obterIdJogo(String nome) throws Exception;
    public void inserirJogoBibliotecaDev(Integer idDesenvolvedor, Integer idJogo) throws Exception;
}
