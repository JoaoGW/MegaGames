import entidades.Usuario;
import entidades.Desenvolvedor;
import entidades.Jogo;
import bancoDeDados.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.List;
import java.util.ArrayList;

public class Cad_gui extends JFrame implements ActionListener {
    // botoes para menu inicial
    private JButton btnCadastrar, btnListar, btnSair;

    // componentes para dados do cliente
    private JLabel lblNomeUsuario, lblNicknameUsuario, lblSenhaUsuario, lblTelefoneUsuario, lblJogoUsuario,
            lblNomeDesenv, lblCnpjDesenv, lblEmailDesenv,
            lblNomeJogo, lblPrecoJogo, lblAvaliacaoJogo;
            
    private JTextField txfNomeUsuario, txfNicknameUsuario, txfSenhaUsuario, txfTelefoneUsuario,
            txfNomeDesenv, txfCnpjDesenv, txfEmailDesenv,
            txfNomeJogo, txfPrecoJogo, txfAvaliacaoJogo;
            
    private JButton btnInserirJogo, btnInserirUsuario, btnNovo,
            // Botoes para saber o que cadastrar
            btnCadastrarJogo, btnCadastrarUsuario;
            
    private JComboBox<String> cbJogos;
    
    /*String qtde[] = {"0","1","2","3","4","5","6","7"};
        cbQtdDisc = new JComboBox(qtde);//Abre lista de zero a um*/
        
    // Paineis
    private JPanel pnMenuCadastro, pnCadastroJogo, pnCadastroUsuario; 

    // armazenador
    IPersistencia persistencia = null;

    /**
     * Cad_gui Construtor
     *
     */
    public Cad_gui(String titulo) {

        super(titulo);
        setSize(320, 84);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel inicial
        JPanel pnMenu = new JPanel();
        // Botoes iniciais
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);
        btnListar = new JButton("Listar");
        btnListar.addActionListener(this);
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);

        // Insere botoes no painel inicial
        pnMenu.add(btnCadastrar);
        pnMenu.add(btnListar);
        pnMenu.add(btnSair);

        // Paine de cadastro de usuario
        pnCadastroUsuario = new JPanel();
        pnCadastroUsuario.setLayout(new GridLayout(5, 2, 0, 3));

        // Labels Usuario
        lblNomeUsuario = new JLabel("Nome ", JLabel.RIGHT);
        lblNicknameUsuario = new JLabel("Nickname ", JLabel.RIGHT);
        lblSenhaUsuario = new JLabel("Senha ", JLabel.RIGHT);
        lblTelefoneUsuario = new JLabel("Telefone ", JLabel.RIGHT);
        lblJogoUsuario = new JLabel("Jogo ", JLabel.RIGHT);
        
        // Painel de cadastro de jogos
        pnCadastroJogo = new JPanel();
        pnCadastroJogo.setLayout(new GridLayout(6, 2, 0, 4));
        
        // Labels Desenvolvedores
        lblNomeDesenv = new JLabel("Nome do Desenvolvedor ", JLabel.RIGHT);
        lblCnpjDesenv = new JLabel("CNPJ do Desenvolvedor ", JLabel.RIGHT);
        lblEmailDesenv = new JLabel("E-mail do Dev ", JLabel.RIGHT);
        
        // Labels Jogo
        lblNomeJogo = new JLabel("Nome ", JLabel.RIGHT);
        lblPrecoJogo = new JLabel("Preco ", JLabel.RIGHT);
        lblAvaliacaoJogo = new JLabel("Avaliacao ", JLabel.RIGHT);

        // TextFields Usuario
        txfNomeUsuario = new JTextField(10);
        txfNicknameUsuario = new JTextField(10);
        txfSenhaUsuario = new JTextField(10);
        txfTelefoneUsuario = new JTextField(10);
        
        //Combobox Usuario
        cbJogos = new JComboBox<>();
        
        
        // TextFields Desenvolvedores
        txfNomeDesenv = new JTextField(10);
        txfCnpjDesenv = new JTextField(10);
        txfEmailDesenv = new JTextField(10);
        
        // TextFields Jogo
        txfNomeJogo = new JTextField(10);
        txfPrecoJogo = new JTextField(10);
        txfAvaliacaoJogo = new JTextField(10);
        
        // botoes
        btnInserirJogo = new JButton("Inserir jogo");
        btnInserirJogo.addActionListener(this);
        btnInserirUsuario = new JButton("Inserir usuario");
        btnInserirUsuario.addActionListener(this);
        btnNovo = new JButton("Novo");
        btnNovo.addActionListener(this);
        btnNovo.setEnabled(false);
        
        // Botoes para escolher o que se quer cadastrar
        btnCadastrarJogo = new JButton("Cadastrar Jogo");
        btnCadastrarJogo.addActionListener(this);
        btnCadastrarUsuario = new JButton("Cadastrar Usuario");
        btnCadastrarUsuario.addActionListener(this);
        
        // Painel de escolha de cadastro
        pnMenuCadastro = new JPanel();
        
        pnMenuCadastro.add(btnCadastrarJogo);
        pnMenuCadastro.add(btnCadastrarUsuario);
        
        
        // Adiciona os componentes do cadastro de usuario
        pnCadastroUsuario.add(lblNomeUsuario);
        pnCadastroUsuario.add(txfNomeUsuario);

        pnCadastroUsuario.add(lblNicknameUsuario);
        pnCadastroUsuario.add(txfNicknameUsuario);

        pnCadastroUsuario.add(lblSenhaUsuario);
        pnCadastroUsuario.add(txfSenhaUsuario);

        pnCadastroUsuario.add(lblTelefoneUsuario);
        pnCadastroUsuario.add(txfTelefoneUsuario);
        
        pnCadastroUsuario.add(lblJogoUsuario);
        pnCadastroUsuario.add(cbJogos);
        
        // Adiciona os componentes do cadastro de jogo
        pnCadastroJogo.add(lblNomeDesenv);
        pnCadastroJogo.add(txfNomeDesenv);
        
        pnCadastroJogo.add(lblCnpjDesenv);
        pnCadastroJogo.add(txfCnpjDesenv);

        pnCadastroJogo.add(lblEmailDesenv);
        pnCadastroJogo.add(txfEmailDesenv);

        pnCadastroJogo.add(lblNomeJogo);
        pnCadastroJogo.add(txfNomeJogo);
        
        pnCadastroJogo.add(lblPrecoJogo);
        pnCadastroJogo.add(txfPrecoJogo);
        
        pnCadastroJogo.add(lblAvaliacaoJogo);
        pnCadastroJogo.add(txfAvaliacaoJogo);

        // Painel principal
        JPanel pnPrincipal = new JPanel();
        // adiciona os dois paineis de componentes no pinel principal
        pnPrincipal.add(pnMenu);
        pnPrincipal.add(pnMenuCadastro);
        pnPrincipal.add(pnCadastroUsuario);
        pnPrincipal.add(pnCadastroJogo);
        pnPrincipal.add(btnInserirJogo);
        pnPrincipal.add(btnInserirUsuario);
        pnPrincipal.add(btnNovo);
        setContentPane(pnPrincipal);
        
        
        pnMenuCadastro.setVisible(false);
        pnCadastroUsuario.setVisible(false);
        pnCadastroJogo.setVisible(false);
        btnInserirJogo.setVisible(false);
        btnInserirUsuario.setVisible(false);
        btnNovo.setVisible(false);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * actionPerformed, processa os eventos
     *
     * @param e ActionEvent, armazena eventos
     */
    public void actionPerformed(ActionEvent e) {
        
        try{
            persistencia = new PersistenciaBD();
        } catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        if ((e.getSource() == btnInserirJogo) || e.getSource() == btnInserirUsuario || (e.getSource() == txfTelefoneUsuario)) {
            try{
                if(e.getSource() == btnInserirJogo){
                    String nome = txfNomeJogo.getText();
                    float preco = Float.parseFloat(txfPrecoJogo.getText());
                    float avaliacao = Float.parseFloat(txfAvaliacaoJogo.getText());
                    String nomeDev = txfNomeDesenv.getText();
                    String cnpjDev = txfCnpjDesenv.getText();
                    String emailDev = txfEmailDesenv.getText();
                    
                    Desenvolvedor desenvolvedor = new Desenvolvedor(nomeDev, cnpjDev, emailDev);
                    
                    // 1. Tentar obter o ID do desenvolvedor pelo CNPJ
                    Integer idDesenvolvedor = persistencia.obterIdDesenvolvedor(cnpjDev);
                    
                    // 2. Se o desenvolvedor não existir, inseri-lo e obter o ID
                    if (idDesenvolvedor == null) {
                        persistencia.gravarDadosDesenvolvedor(desenvolvedor);
                        idDesenvolvedor = persistencia.obterIdDesenvolvedor(cnpjDev);
                    }
                    
                    // 3. Tentar obter o ID do jogo pelo nome
                    Integer idJogo = persistencia.obterIdJogo(nome);
                    
                    Jogo jogo = new Jogo(nome, preco, avaliacao, idDesenvolvedor);
            
                    // 4. Se o jogo não existir, inseri-lo e obter o ID
                    if (idJogo == null) {
                        persistencia.gravarDadosJogo(jogo);
                        idJogo = persistencia.obterIdJogo(nome);
                    }
            
                    // 5. Inserir o jogo na tabela intermediária BibliotecasDev
                    persistencia.inserirJogoBibliotecaDev(idDesenvolvedor, idJogo);
                    
                    JOptionPane.showMessageDialog(null, "Jogo inserido!");
                    
                    btnNovo.setEnabled(true);
                } else if(e.getSource() == btnInserirUsuario){
                    String nome = txfNomeUsuario.getText();
                    String nickname = txfNicknameUsuario.getText();
                    String senha = txfSenhaUsuario.getText();
                    String telefone = txfTelefoneUsuario.getText();
                    String jogoSelecionado = cbJogos.getSelectedItem().toString();
                    
                    // 1. Verifica se "Selecione um jogo" está selecionado
                    if(jogoSelecionado.equals("Selecione um jogo")) {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um jogo antes de continuar.");
                        return; // Interrompe o fluxo de execução
                    }
                    
                    Integer idJogo = persistencia.obterIdJogo(jogoSelecionado);
                    
                    // Apenas para garantir
                    if (idJogo == null) {
                        JOptionPane.showMessageDialog(null, "O jogo selecionado não existe no banco de dados.");
                        return; // Interrompe o fluxo de execução
                    }
                    
                    Usuario u = new Usuario(nome, nickname, senha, telefone, idJogo);
                    persistencia.gravarDadosUsuario(u);
                    
                    JOptionPane.showMessageDialog(null, "Usuario inserido!");
                    
                    btnNovo.setEnabled(true);
                }

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage());
                JOptionPane.showMessageDialog(null, "Dados invalidos!!");
            }
            
        } else if(e.getSource() == btnNovo){
            limparCampos();
            btnNovo.setEnabled(false);
            
        } else if(e.getSource() == btnCadastrar){
            pnMenuCadastro.setVisible(true);
            setSize(320, 130);
            
        } else if(e.getSource() == btnCadastrarJogo || e.getSource() == btnCadastrarUsuario){
            btnNovo.setVisible(true);
            setSize(320, 310);
            // Insere os jogos ja cadastrados na comboBox
            carregarNomeJogosDB();
            
            if(e.getSource() == btnCadastrarJogo){
                btnCadastrarJogo.setEnabled(false);
                pnCadastroUsuario.setVisible(false);
                pnCadastroJogo.setVisible(true);
                btnCadastrarUsuario.setEnabled(true);
                btnInserirUsuario.setVisible(false);
                btnInserirJogo.setVisible(true);
                
            } else if(e.getSource() == btnCadastrarUsuario){
                btnCadastrarUsuario.setEnabled(false);
                pnCadastroJogo.setVisible(false);
                pnCadastroUsuario.setVisible(true);
                btnCadastrarJogo.setEnabled(true);
                btnInserirJogo.setVisible(false);
                btnInserirUsuario.setVisible(true);
                
            }
            
        }else if(e.getSource() == btnListar){
            /*if(cad.getQtd() > 0){
                JOptionPane.showMessageDialog(null, cad);
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro vazio.");
            }*/

        } else if(e.getSource() == btnSair){
            System.exit(0);
        }
    }

    /**
     * limparCampos
     *
     */
    public void limparCampos(){
        txfNomeUsuario.setText("");
        txfNicknameUsuario.setText("");
        txfSenhaUsuario.setText("");
        txfTelefoneUsuario.setText("");
        
        txfNomeDesenv.setText("");
        txfCnpjDesenv.setText("");
        txfEmailDesenv.setText("");
        
        txfNomeJogo.setText("");
        txfPrecoJogo.setText("");
        txfAvaliacaoJogo.setText("");
    }
    
    private void carregarNomeJogosDB(){
        List<String> listaJogos = new ArrayList<>();
        cbJogos.removeAllItems();
        try{
            listaJogos = persistencia.obterJogosDB();
            listaJogos.add(0, "Selecione um jogo");
            for(String jogo : listaJogos){
                cbJogos.addItem(jogo);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            JOptionPane.showMessageDialog(this, "Erro ao carregar jogos do banco de dados.");
        }
    }
}
