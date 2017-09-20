/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author 12265041670
 */
public class JanelaListaPessoa extends JFrame {

    private final JLabel lblNome = new JLabel("Nome: ");
    private final JTextField txtNome = new JTextField(10);
    private final JLabel lblIdade = new JLabel("Idade");
    private final JTextField txtIdade = new JTextField(10);
    private final JButton btnExcl = new JButton("Excluir");
    private final DefaultListModel modelo = new DefaultListModel();
    private final JList lstLista = new JList(modelo);

    public JanelaListaPessoa() throws HeadlessException {
        super("Lista");
        setLayout(new BorderLayout(5, 5));
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new BorderLayout(5, 5));
        pnlEntrada.add(lblNome, BorderLayout.WEST);
        pnlEntrada.add(txtNome, BorderLayout.CENTER);

        JPanel pnlEntrada2 = new JPanel();
        pnlEntrada2.setLayout(new BorderLayout(5, 5));
        pnlEntrada2.add(lblIdade, BorderLayout.WEST);
        pnlEntrada2.add(txtIdade, BorderLayout.CENTER);

        JPanel pnlEntrada3 = new JPanel(new FlowLayout());
        pnlEntrada3.add(pnlEntrada);
        pnlEntrada3.add(pnlEntrada2);

        add(pnlEntrada3, BorderLayout.NORTH);
        add(btnExcl, BorderLayout.SOUTH);
        add(new JScrollPane(lstLista), BorderLayout.CENTER);
        lstLista.setVisibleRowCount(10);

        for (int i = 0; i < 3; i++) {
            Pessoa p = new Pessoa();
            p.setNome("Pessoa " + i + " ");
            p.setIdade(i + 10);
            modelo.addElement(p);

        }

        txtNome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.requestFocus();
            }
        });

        txtIdade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNome.getText().isEmpty()) {
                    txtNome.requestFocus();
                    return;
                }
                Integer idade = Integer.parseInt(txtIdade.getText());
                String nome = txtNome.getText();
                Pessoa p = new Pessoa();
                p.setNome(nome);
                p.setIdade(idade);
                modelo.addElement(p);
                txtNome.setText("");
                txtIdade.setText("");
                txtIdade.requestFocus();

            }
        });

        btnExcl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List selecionados = lstLista.getSelectedValuesList();
                for (Object selecionado : selecionados) {
                    modelo.removeElement(selecionado);
                }
            }
        });
    }

}
