package org.geoffchiang.lametric.model;

public class TextFrame extends Frame {

    private final String text;
    private final String icon;

    public TextFrame(int index, String text, String icon) {
        super(index);
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }
}
