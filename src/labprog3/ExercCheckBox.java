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

public class ExercCheckBox extends JFrame {

    private final JLabel valorT = new JLabel("                 Valor: R$");
    private final JLabel dolarT = new JLabel("                 Cotação: U$");
    private final JLabel tributo = new JLabel("Tributos:");
    private final JLabel icms = new JLabel("                       ICMS:");
    private final JTextField valor = new JTextField(15);
    private final JTextField dolar = new JTextField(15);
    private final JCheckBox chkTributo = new JCheckBox();
    private final JCheckBox chkICMS = new JCheckBox();
    private final JButton calcular = new JButton("Calcular");
    private final JLabel resultado = new JLabel("");



    public ExercCheckBox() throws HeadlessException {
        super("Atividade");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(tributo);
        add(chkTributo);
        add(icms);
        add(chkICMS);
        add(valorT);
        add(valor);
        add(dolarT);
        add(dolar);
        add(calcular);
        add(resultado);
        
        Calcular c = new Calcular();
        calcular.addActionListener(c);

    }

    private class Calcular implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Double calculo = null;
            if(chkICMS.isSelected() && chkTributo.isSelected()){
                calculo = Double.parseDouble(valor.getText()) * Double.parseDouble(dolar.getText()) ;
                calculo = calculo + calculo * 0.78;
            }else if (chkTributo.isSelected()){
                calculo = Double.parseDouble(valor.getText()) * Double.parseDouble(dolar.getText()) ;
                calculo = calculo + calculo * 0.18;
            }else{
                calculo = Double.parseDouble(valor.getText()) * Double.parseDouble(dolar.getText()) ;
            }
            resultado.setText("      Resultado Final: R$"+ calculo);
        }
    }
    

}
