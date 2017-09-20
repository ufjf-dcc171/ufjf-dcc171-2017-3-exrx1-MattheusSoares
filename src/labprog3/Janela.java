/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labprog3;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Mattheus
 */
public class Janela extends JFrame {

    private final JLabel l1;
    //private final JLabel l2;
    private final JLabel l3;
    private final JTextField v1;
    //private final JTextField v2;

    public Janela() throws HeadlessException {
        super("Exemplo Janela");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        l1 = new JLabel("Texto:");
       // l2 = new JLabel("Segundo Valor");
        l3 = new JLabel("Texto invertido: ");
        v1 = new JTextField(20);
        //v2 = new JTextField(20);

        v1.addActionListener(new N1());
        //v2.addActionListener(new Resultado());

        add(l1);
        add(v1);
        //add(l2);
        //add(v2);
        add(l3);
    }

    private class N1 implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            StringBuffer buffer = new StringBuffer(v1.getText());
            buffer.reverse();
            l3.setText("Texto invertido: "+buffer);
            //v2.requestFocus();
        }
    }
/*
    private class Resultado implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int r = 0;
            r = Integer.parseInt(v1.getText()) + Integer.parseInt(v2.getText());
            l3.setText("Resultado: " + r);
        }
    }
*/
}
