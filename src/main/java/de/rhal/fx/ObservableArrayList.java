package de.rhal.fx;

import javafx.collections.ModifiableObservableListBase;

import java.util.ArrayList;

public class ObservableArrayList <D> extends ModifiableObservableListBase<D> {
    private ArrayList<D> list = new ArrayList<>();
    @Override
    public D get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected void doAdd(int index, D element) {
        list.add(index, element);
    }

    @Override
    protected D doSet(int index, D element) {
        return list.set(index, element);
    }

    @Override
    protected D doRemove(int index) {
        return list.remove(index);
    }
}
