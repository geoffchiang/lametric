package org.geoffchiang.lametric.model;

import java.util.ArrayList;
import java.util.List;

public class Frames {

    private final List<Frame> frames;

    public Frames() {
        this.frames = new ArrayList<>();
    }

    public void add(Frame frame) {
        frames.add(frame);
    }
}
