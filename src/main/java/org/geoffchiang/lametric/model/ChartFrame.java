package org.geoffchiang.lametric.model;

import java.util.List;

public class ChartFrame extends Frame {

    public final List<Integer> chartData;

    public ChartFrame(int index, List<Integer> chartData) {
        super(index);
        this.chartData = chartData;
    }

    public List<Integer> getChartData() {
        return chartData;
    }
}
