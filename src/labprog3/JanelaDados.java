package labprog3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaDados extends JFrame {

    private final List<Dados> dados;
    private final JList<Dados> lstDados = new JList<>(new DefaultListModel<>());
    private final JButton criarDados = new JButton("Criar Dados");
    private final JButton excluirDados = new JButton("Excluir Dados");
    private final JanelaInserirDados janelaInserir = new JanelaInserirDados();
    private JLabel dadoLatitude = new JLabel("Latitude");
    private JLabel dadoLongitute = new JLabel("Longitude");
    private JLabel dadoData = new JLabel("Data");
    private JLabel dadoDescricao = new JLabel("Descrição");

    public JanelaDados(List<Dados> sampleData) {
        super("Dados");
        this.dados = sampleData;
        lstDados.setModel(new DadosListModel(dados));
        add(new JScrollPane(lstDados), BorderLayout.WEST);
                
        JPanel info = new JPanel(new GridLayout(4,1));
        info.add(dadoLatitude);
        info.add(dadoLongitute);
        info.add(dadoData);
        info.add(dadoDescricao);
        add(new JScrollPane(info), BorderLayout.CENTER);
        
        JPanel botoes = new JPanel(new GridLayout(1, 4));
        botoes.add(criarDados);
        botoes.add(excluirDados);
        add(botoes, BorderLayout.SOUTH);

        lstDados.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Dados selecionada = lstDados.getSelectedValue();
                if(selecionada == null) return;
                String latitude = selecionada.getLatitude();
                String longitude = selecionada.getLongitude();
                String data = selecionada.getData();
                String descricao = selecionada.getDescricao();
                dadoLatitude.setText("Latitude: "+latitude);
                dadoLongitute.setText("Longitude: "+longitude);
                dadoData.setText("Data: "+data);
                dadoDescricao.setText("Descrição: "+descricao);
                
            }

        });
        criarDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaInserir.setLocationRelativeTo(null);
                janelaInserir.setVisible(true);
                janelaInserir.solicitaNovoAluno();
            }
        });
        excluirDados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstDados.isSelectionEmpty()) {
                    return;
                } else {
                    dados.remove(lstDados.getSelectedValue());
                    lstDados.clearSelection();
                    lstDados.updateUI();
                }
            }
        });

        janelaInserir.setJanelaDados(this);

    }
    void adicionaDados(Dados d) {
        dados.add(d);
        lstDados.updateUI();
        janelaInserir.setVisible(false);
    }
}
