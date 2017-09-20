package labprog3;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AtividadeJokenpo extends JFrame {

    private final Random IA = new Random();
    private int IAChoice;
    private int MatchIA = 0;
    private int MatchPlayer = 0;
    private final JLabel mensagem;
    private final JRadioButton Pedra;
    private final JRadioButton Papel;
    private final JRadioButton Tesoura;
    private final JButton Jokenpo = new JButton("Jokenpo");
    private final JLabel space = new JLabel("                                                        ");
    private final JLabel resultado = new JLabel("");
    private final JLabel IAChoiceTXT = new JLabel("");

    private final Font TXT = new Font(Font.SERIF, Font.PLAIN, 14);

    public AtividadeJokenpo() throws HeadlessException {
        super("RadioButton Text");
        setLayout(new FlowLayout());
        mensagem = new JLabel("Escolha um para jogar, e clique no botão depois");
        mensagem.setFont(TXT);

        Pedra = new JRadioButton("Pedra", false);
        Papel = new JRadioButton("Papel", false);
        Tesoura = new JRadioButton("Tesoura", false);

        ButtonGroup JKP = new ButtonGroup();

        JKP.add(Pedra);
        JKP.add(Papel);
        JKP.add(Tesoura);

        add(mensagem);
        add(Pedra);
        add(Papel);
        add(Tesoura);
        add(Jokenpo);
        add(IAChoiceTXT);
        add(space);
        add(resultado);

        Jokenpo.addActionListener(new Play());

    }

    private class Play implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            IAChoice = IA.nextInt(3) + 1;

            if (Pedra.isSelected()) {
                if (IAChoice == 1) {
                    IAChoiceTXT.setText("IA = Pedra");
                    resultado.setText("Empate");
                } else if (IAChoice == 2) {
                    IAChoiceTXT.setText("IA = Papel");
                    resultado.setText("IA Ganhou");
                    MatchIA++;
                } else if (IAChoice == 3) {
                    IAChoiceTXT.setText("IA = Tesoura");
                    resultado.setText("Player Ganhou");
                    MatchPlayer++;
                }
            }
            if (Papel.isSelected()) {
                if (IAChoice == 1) {
                    IAChoiceTXT.setText("IA = Pedra");
                    resultado.setText("Player Ganhou");
                    MatchPlayer++;
                } else if (IAChoice == 2) {
                    IAChoiceTXT.setText("IA = Papel");
                    resultado.setText("Empate");
                } else if (IAChoice == 3) {
                    IAChoiceTXT.setText("IA = Tesoura");
                    resultado.setText("IA Ganhou");
                    MatchIA++;
                }
            }
            if (Tesoura.isSelected()) {
                if (IAChoice == 1) {
                    IAChoiceTXT.setText("IA = Pedra");
                    resultado.setText("IA Ganhou");
                    MatchIA++;
                } else if (IAChoice == 2) {
                    IAChoiceTXT.setText("IA = Papel");
                    resultado.setText("Player Ganhou");
                    MatchPlayer++;
                } else if (IAChoice == 3) {
                    IAChoiceTXT.setText("IA = Tesoura");
                    resultado.setText("Empate");
                }
            }

            if (MatchIA == 7) {
                resultado.setText("IA ganhou a partida - Player: "+MatchPlayer+" IA: "+MatchIA);
                Jokenpo.setEnabled(false);

            } else if (MatchPlayer == 7) {
                resultado.setText("Player ganhou a partida - Player: "+MatchPlayer+" IA: "+MatchIA);
                Jokenpo.setEnabled(false);

            }

        }
    }
}
