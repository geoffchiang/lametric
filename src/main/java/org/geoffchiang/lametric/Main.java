package org.geoffchiang.lametric;

import org.geoffchiang.lametric.model.ChartFrame;
import org.geoffchiang.lametric.model.Frames;
import org.geoffchiang.lametric.model.GoalDataFrame;
import org.geoffchiang.lametric.model.TextFrame;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    private static final String LAMETRIC_DEVICE_ID = "insert your device id - should be start with com.lametric.";
    private static final String ACCESS_TOKEN = "insert your access token";

    public static void main(String[] args) {
        Frames frames = new Frames();
        frames.add(new TextFrame(0, "Pacman", "i294"));
        frames.add(new GoalDataFrame(1, 0, 60, 100, "", "i555"));
        frames.add(new ChartFrame(2, Arrays.asList(50, 300, 200, 25, 175, 75, 325, 125)));

        try {
            new PushToLaMetric(LAMETRIC_DEVICE_ID, ACCESS_TOKEN).push(frames);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
