/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog3;

import java.awt.BorderLayout;
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
public class JanelaLista extends JFrame{
    private final JLabel lblNumero = new JLabel("Número");
    private final JTextField txtNumero = new JTextField(10);
    private final JButton btnExcl = new JButton("Excluir");
    private final DefaultListModel modelo = new DefaultListModel();
    private final JList lstLista = new JList(modelo);
    
    public JanelaLista() throws HeadlessException{
        super("Lista");
        setLayout(new BorderLayout(5,5));
        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new BorderLayout(5, 5));
        pnlEntrada.add(lblNumero, BorderLayout.WEST);
        pnlEntrada.add(txtNumero, BorderLayout.CENTER);
        add(pnlEntrada, BorderLayout.NORTH);
        add(btnExcl, BorderLayout.SOUTH);
        add(new JScrollPane(lstLista), BorderLayout.CENTER);
        lstLista.setVisibleRowCount(10);
        /*
        for(int i=0; i<30; i++){
            modelo.addElement(10*i);
        }
        */
        txtNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelo.addElement(Integer.parseInt(txtNumero.getText()));
                txtNumero.setText("");
                txtNumero.requestFocus();
            }
        });
        
        btnExcl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List selecionados = lstLista.getSelectedValuesList();
                for(Object selecionado: selecionados){
                    modelo.removeElement(selecionado);
                }
            }
        });
    }

    
}
