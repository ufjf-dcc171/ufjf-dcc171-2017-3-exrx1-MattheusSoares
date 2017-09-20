
package labprog3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


public class AlunoListModel implements ListModel<Aluno>{
    private final List<Aluno> alunos;
    private final List<ListDataListener> dataListener;

    public AlunoListModel(List<Aluno> alunos) {
        this.alunos = alunos;
        this.dataListener = new ArrayList<>();
    }
    @Override
    public int getSize() {
        return alunos.size();
    }
    @Override
    public Aluno getElementAt(int index) {
        return alunos.get(index);
    }
    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListener.add(l);
    }
    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListener.remove(l);
    }
}
