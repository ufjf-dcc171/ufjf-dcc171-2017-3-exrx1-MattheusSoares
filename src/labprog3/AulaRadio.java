package labprog3;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AulaRadio extends JFrame {

    private final JLabel mensagem;
    private final JRadioButton rbPlano;
    private final JRadioButton rbNegrito;
    private final JRadioButton rbItalico;
    private final JRadioButton rbNegritoItalico;

    private final Font fPlana = new Font(Font.SERIF, Font.PLAIN, 20);
    private final Font fNegrito = new Font(Font.SERIF, Font.BOLD, 20);
    private final Font fItalico = new Font(Font.SERIF, Font.ITALIC, 20);
    private final Font fNegritoItalico = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
    
    
    
    
    public AulaRadio() throws HeadlessException {
        super("RadioButton Text");
        setLayout(new FlowLayout());
        mensagem  = new JLabel("Universidade Federal de Juiz de Fora");
        mensagem.setFont(fPlana);
        add(mensagem);
        rbPlano = new JRadioButton("Plano", true);
        rbNegrito = new JRadioButton("Negrito", false);
        rbItalico = new JRadioButton("Italico", false);
        rbNegritoItalico = new JRadioButton("Negrito e Italico", false);
        add(rbPlano);
        add(rbNegrito);
        add(rbItalico);
        add(rbNegritoItalico);

        ButtonGroup bgEstilo = new ButtonGroup();

        bgEstilo.add(rbPlano);
        bgEstilo.add(rbNegrito);
        bgEstilo.add(rbItalico);
        bgEstilo.add(rbNegritoItalico);

        
        
        
        rbPlano.addItemListener(new EstiloRadio(fPlana));
        rbNegrito.addItemListener(new EstiloRadio(fNegrito));
        rbItalico.addItemListener(new EstiloRadio(fItalico));
        rbNegritoItalico.addItemListener(new EstiloRadio(fNegritoItalico));
    }
    
    
    private class EstiloRadio implements ItemListener{
        private  Font fonte;
        public EstiloRadio(Font fonte){
            this.fonte = fonte;
        }

        public void itemStateChanged(ItemEvent e) {
            mensagem.setFont(fonte);
            
        }        
    }

}


