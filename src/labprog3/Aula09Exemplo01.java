package labprog3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Aula09Exemplo01 extends JFrame {

    private JPanel principal = new JPanel();
    private JComboBox<String> layouts = new JComboBox<>(new String[]{"Absolute", "FlowLayout","BorderLayout","GridLayout", "GridBagLayout", "HorizontalBox", "VerticalBox"});
    private JLabel lbl01 = new JLabel("Etiqueta 01");
    private JLabel lbl02 = new JLabel("Etiqueta 02");
    private JLabel lbl03 = new JLabel("Etiqueta 03");
    private JLabel lbl04 = new JLabel("Etiqueta 04");
    private JTextField txt01 = new JTextField("Texto 01");
    private JTextField txt02 = new JTextField("Texto 02");
    private JTextField txt03 = new JTextField("Texto 03");
    private JTextField txt04 = new JTextField("Texto 04");

    public Aula09Exemplo01() throws HeadlessException {
        super("Exemplos de Layout");

        configuraLayoutAbsoluto();
        add(layouts, BorderLayout.NORTH);
        add(principal, BorderLayout.CENTER);
        layouts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(
                layouts.getSelectedIndex());
                principal.setPreferredSize(null);

                switch (layouts.getSelectedIndex()) {
                    case 0:
                        configuraLayoutAbsoluto();
                        break;
                    case 1:
                        configuraFlowLayout();
                        break;
                    case 2:
                        configuraBorderLayout();
                        break;
                    case 3:
                        configuraGridLayout();
                        break;
                    case 4:
                        configuraGridBagLayout();
                        break;
                    case 5:
                        configuraHorizontalBoxLayout();
                        break;
                    case 6:
                        configuraVerticalBoxLayout();
                        break;
                    default:
                        configuraFlowLayout();
                }
                pack();
                
            }
        });

    }

    private void configuraFlowLayout() {
        principal.setLayout(new FlowLayout());
        principal.add(lbl01);
        principal.add(txt01);
        principal.add(lbl02);
        principal.add(txt02);
        principal.add(lbl03);
        principal.add(txt03);
        principal.add(lbl04);
        principal.add(txt04);
    }

    private void configuraBorderLayout() {
        principal.setSize(400,300);
        principal.setPreferredSize(new Dimension(400,300));
        principal.removeAll();
        principal.setLayout(new BorderLayout());
        principal.add(lbl01, BorderLayout.NORTH);
        principal.add(txt01, BorderLayout.WEST);
        principal.add(txt02, BorderLayout.CENTER);
        principal.add(lbl03, BorderLayout.EAST);
        principal.add(txt03, BorderLayout.SOUTH);
    }

    private void configuraLayoutAbsoluto() {
        principal.setLayout(null);
        principal.setPreferredSize(new Dimension(400,300));
        lbl01.setSize(100, 30);
        lbl02.setSize(100, 30);
        lbl03.setSize(100, 30);
        lbl04.setSize(100, 30);
        txt01.setSize(200, 30);
        txt02.setSize(txt01.getSize());
        txt03.setSize(txt01.getSize());
        txt04.setSize(txt01.getSize());
        lbl01.setLocation(10, 10);
        txt01.setLocation(120, 10);
        lbl02.setLocation(10, 50);
        txt02.setLocation(120, 50);
        lbl03.setLocation(10, 90);
        txt03.setLocation(120, 90);
        lbl04.setLocation(10, 130);
        txt04.setLocation(120, 130);

        principal.add(lbl01);
        principal.add(txt01);
        principal.add(lbl02);
        principal.add(txt02);
        principal.add(lbl03);
        principal.add(txt03);
        principal.add(lbl04);
        principal.add(txt04);
    }

    private void configuraGridLayout() {
        principal.setLayout(new GridLayout(4,2));
        principal.add(lbl01);
        principal.add(txt01);
        principal.add(lbl02);
        principal.add(txt02);
        principal.add(lbl03);
        principal.add(txt03);
        principal.add(lbl04);
        principal.add(txt04);
    }

    private void configuraGridBagLayout() {
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        principal.setLayout(gbl);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        principal.add(lbl01);
        gbl.setConstraints(lbl01, gbc);
        
        principal.add(lbl02);
        gbc.gridy = 1;
        gbl.setConstraints(lbl02, gbc);
        
        principal.add(lbl03);
        gbc.gridy = 2;
        gbl.setConstraints(lbl03, gbc);
        
        principal.add(lbl04);
        gbc.gridy = 3;
        gbl.setConstraints(lbl04, gbc);
        
        principal.add(txt01);
        gbc.ipady = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 2;
        gbl.setConstraints(txt01, gbc);

        principal.add(txt02);
        gbc.gridy++;
        gbl.setConstraints(txt02, gbc);

        principal.add(txt03);
        gbc.gridy++;
        gbl.setConstraints(txt03, gbc);

        principal.add(txt04);
        gbc.gridy++;
        gbl.setConstraints(txt04, gbc);
        

    }

    private void configuraHorizontalBoxLayout() {
        Box horizontal = Box.createHorizontalBox();
        horizontal.add(lbl01);
        horizontal.add(txt01);
        horizontal.add(lbl02);
        horizontal.add(txt02);
        horizontal.add(lbl03);
        horizontal.add(txt03);
        horizontal.add(lbl04);
        horizontal.add(txt04);
        principal.add(horizontal);
    }
    private void configuraVerticalBoxLayout() {
        Box vertical = Box.createVerticalBox();
        vertical.add(lbl01);
        vertical.add(txt01);
        vertical.add(lbl02);
        vertical.add(txt02);
        vertical.add(lbl03);
        vertical.add(txt03);
        vertical.add(lbl04);
        vertical.add(txt04);
        principal.add(vertical);
    }

}
