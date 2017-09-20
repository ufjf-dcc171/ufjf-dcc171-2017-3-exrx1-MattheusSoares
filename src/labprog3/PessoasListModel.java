package labprog3;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class PessoasListModel implements ListModel<Pessoa>{
    
    private final List<Pessoa> pessoas;
    private List<ListDataListener> dataListener = new ArrayList<>();
    
    public PessoasListModel(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int getSize() {
        return pessoas.size();
    }

    @Override
    public Pessoa getElementAt(int index) {
        return pessoas.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListener.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListener.remove(l);
    }


}
