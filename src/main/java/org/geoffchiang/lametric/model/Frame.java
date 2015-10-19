package org.geoffchiang.lametric.model;

public abstract class Frame {

    private final int index;

    protected Frame(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
