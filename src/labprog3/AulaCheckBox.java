package labprog3;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AulaCheckBox extends JFrame {
    private final JTextField texto = new JTextField(50);
    private final JCheckBox chkNegrito = new JCheckBox();
    private final JCheckBox chkItalico = new JCheckBox();
    
    
    public AulaCheckBox() throws HeadlessException{
        super("CHECKBOX");
        setLayout(new FlowLayout(FlowLayout.CENTER));
        texto.setText("Universidade Federal de Juiz de Fora");
        texto.setFont(new Font(Font.SERIF, Font.PLAIN,14));
        
        add(texto);
        add(chkNegrito);
        add(chkItalico);
        
        
        TrocaFonte trocaFonte = new TrocaFonte();
        chkNegrito.addItemListener(trocaFonte);
        chkItalico.addItemListener(trocaFonte);
        

    
    
    }
    
    private class TrocaFonte implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            Font fonte;
            if(chkNegrito.isSelected() && chkItalico.isSelected()){
                fonte = new Font(Font.SERIF,Font.BOLD+Font.ITALIC,14);
            }else if (chkItalico.isSelected()){
                fonte = new Font(Font.SERIF,Font.ITALIC,14);
            }else if (chkNegrito.isSelected()){
                fonte = new Font(Font.SERIF,Font.BOLD,14);
            }else{
                fonte = new Font(Font.SERIF,Font.PLAIN,14);
            }
            texto.setFont(fonte);
        }
       
    }
    
    
}
