package labprog3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaTurmas extends JFrame {

    private final List<Turma> turmas;
    private final JList<Turma> lstTurmas = new JList<>(new DefaultListModel<>());
    private final JList<Aluno> lstAlunos = new JList<>(new DefaultListModel<>());
    private final JButton criarTurma = new JButton("Criar Turma");
    private final JButton excluirTurma = new JButton("Excluir Turma");
    private final JButton criarAluno = new JButton("Criar Aluno");
    private final JButton excluirAluno = new JButton("Excluir Aluno");
    private final JanelaAluno janelaAluno = new JanelaAluno();

    public JanelaTurmas(List<Turma> sampleData) {
        super("Turmas");
        this.turmas = sampleData;
        lstTurmas.setModel(new TurmaListModel(turmas));
        add(new JScrollPane(lstTurmas), BorderLayout.WEST);
        add(new JScrollPane(lstAlunos), BorderLayout.CENTER);

        JPanel botoes = new JPanel(new GridLayout(1, 4));
        botoes.add(criarTurma);
        botoes.add(excluirTurma);
        botoes.add(criarAluno);
        botoes.add(excluirAluno);
        add(botoes, BorderLayout.SOUTH);

        lstTurmas.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                Turma selecionada = lstTurmas.getSelectedValue();

                if (selecionada != null) {
                    lstAlunos.setModel(new AlunoListModel(selecionada.getAlunos()));
                } else {
                    lstAlunos.setModel(new DefaultListModel<>());
                }
            }

        });
        criarTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cod = JOptionPane.showInputDialog("Código da nova turma: ");
                if (!cod.isEmpty() && cod != null) {
                    Turma t = new Turma(cod);
                    turmas.add(t);
                    lstTurmas.updateUI();
                }
            }
        });
        excluirTurma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstTurmas.isSelectionEmpty()) {
                    return;
                } else {
                    turmas.remove(lstTurmas.getSelectedValue());
                    lstTurmas.clearSelection();
                    lstTurmas.updateUI();
                }
            }
        });
        
        janelaAluno.setJanelaTurmas(this);
        
        criarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                janelaAluno.setLocationRelativeTo(null);
                janelaAluno.setVisible(true);
                janelaAluno.solicitaNovoAluno();
            }
        });
    }

    void adicionaAluno(Aluno a) {
        lstTurmas.getSelectedValue().getAlunos().add(a);
        lstTurmas.updateUI();
        lstAlunos.updateUI();
        janelaAluno.setVisible(false);
    }

}
