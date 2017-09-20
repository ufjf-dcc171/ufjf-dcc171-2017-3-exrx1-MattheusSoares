package labprog3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class JanelaInserirDados  extends JFrame {

    private final JLabel lblCodigo = new JLabel("Código");
    private final JLabel lblLatitude = new JLabel("Latitude");
    private final JLabel lblLongitude = new JLabel("Longitude");
    private final JLabel lblData = new JLabel("Data");
    private final JLabel lblDesc = new JLabel("Descrição");

    
    private final JTextField txtCodigo = new JTextField(30);
    private final JTextField txtLatitude = new JTextField(30);
    private final JTextField txtLongitude = new JTextField(30);
    private final JTextField txtData = new JTextField(30);
    private final JTextField txtDesc = new JTextField(30);

    
    private final JButton matricular = new JButton("Salvar");
    private JanelaDados janelaDados;

    public JanelaInserirDados() throws HeadlessException {
        super("Criar novos dados");
        setResizable(false);
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        JPanel principal = new JPanel(new GridLayout(5,2));

        principal.add(lblCodigo);
        principal.add(txtCodigo);
        
        principal.add(lblLatitude);
        principal.add(txtLatitude);
        
        principal.add(lblLongitude);
        principal.add(txtLongitude);
                
        principal.add(lblData);
        principal.add(txtData);
        
        principal.add(lblDesc);
        principal.add(txtDesc);
        
        add(principal, BorderLayout.CENTER);
        add(matricular, BorderLayout.SOUTH);

        matricular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCodigo.getText().isEmpty() && !txtLatitude.getText().isEmpty() && !txtLongitude.getText().isEmpty()
                         && !txtData.getText().isEmpty() && !txtDesc.getText().isEmpty()) {
                    Dados d = new Dados();
                    d.setCodigo(txtCodigo.getText());
                    d.setLatitude(txtLatitude.getText());
                    d.setLongitude(txtLongitude.getText());
                    d.setData(txtData.getText());
                    d.setDescricao(txtDesc.getText());
                    janelaDados.adicionaDados(d);
                    
                }
            }
        });
    }

    public void setJanelaDados(JanelaDados janela) {
        this.janelaDados = janela;
    }

    void solicitaNovoAluno() {
        setLocationRelativeTo(null);
        setVisible(true);
        txtCodigo.setText("");
        txtCodigo.requestFocus();
        txtLatitude.setText("");
        txtLongitude.setText("");
        txtData.setText("");
        txtDesc.setText("");

    }
}
