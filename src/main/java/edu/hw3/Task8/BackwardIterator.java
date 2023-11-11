package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public final class BackwardIterator<T> implements Iterator<T> {
    private final List<T> list;
    private int currantIndex;

    public BackwardIterator(List<T> list) {
        this.list = list;
        this.currantIndex = list.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currantIndex >= 0;
    }

    @Override
    public T next() {
        return list.get(currantIndex--);
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {
        Iterator.super.forEachRemaining(action);
    }
}
