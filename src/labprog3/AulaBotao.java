package labprog3;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class AulaBotao extends JFrame {
    
    
    private final JButton botao1;
    private final JButton botao2;
    
    public AulaBotao() throws HeadlessException {
        super("Exemplo Botão");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        botao1 = new JButton("Clique");
        botao2 = new JButton("Clique");
                
        add(botao1);
        add(botao2);
        
        Clique c = new Clique();
        botao1.addActionListener(c);
        botao2.addActionListener(c);
    }
    private class Clique implements ActionListener {
        
        private int i1=0;
        private int i2=0;
        
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == botao1){
                i1++;
                JOptionPane.showMessageDialog(null, "Botao 1 Clicado "+i1+" Vezes","Click",JOptionPane.INFORMATION_MESSAGE);
            }else if(e.getSource() == botao2){
                i2++;
                JOptionPane.showMessageDialog(null, "Botao 2 Clicado "+i2+" Vezes","Click",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
}

