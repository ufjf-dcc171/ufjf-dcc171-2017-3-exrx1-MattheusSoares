
package labprog3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;


public class TurmaListModel implements ListModel<Turma>{
    private final List<Turma> turmas;
    private final List<ListDataListener> dataListener;

    public TurmaListModel(List<Turma> turmas) {
        this.turmas = turmas;
        this.dataListener = new ArrayList<>();
    }
    @Override
    public int getSize() {
        return turmas.size();
    }
    @Override
    public Turma getElementAt(int index) {
        return turmas.get(index);
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
