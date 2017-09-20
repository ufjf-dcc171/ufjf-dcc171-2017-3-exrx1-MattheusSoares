package labprog3;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class main {

    public static void main(String[] args) {

        /*        Aula09Exemplo01 janela = new Aula09Exemplo01();
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
         */
        
        
        JanelaDados janela = new JanelaDados(getSampleData());
        janela.setLocationRelativeTo(null);
        janela.setSize(800, 300);
        janela.setLocation(300, 100);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
    private static List<Dados> getSampleData(){
        Dados d1 = new Dados("Evento - 1","11","49", "01/01/1998","Furacão");
        Dados d2 = new Dados("Evento - 2","69","127", "21/10/2008","Terremoto");
       
        List<Dados> dados = new ArrayList<>();
        dados.add(d1);
        dados.add(d2);
        return dados;
    
    }

/*    private static List<Turma> getSampleData() {
        Aluno a1 = new Aluno("201335987", "José");
        Aluno a2 = new Aluno("201332222", "Maria");
        Aluno a3 = new Aluno("201311111", "João");

        Turma t1 = new Turma("DCC171");
        Turma t2 = new Turma("DCC111");

        t1.getAlunos().add(a1);
        t1.getAlunos().add(a3);
        t2.getAlunos().add(a1);
        t2.getAlunos().add(a2);
        t2.getAlunos().add(a3);

        List<Turma> turmas = new ArrayList<>();
        turmas.add(t1);
        turmas.add(t2);

        return turmas;
    }*/
}
