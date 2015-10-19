package org.geoffchiang.lametric.model;

public class GoalDataFrame extends Frame {

    private final GoalData goalData;
    private final String icon;

    public GoalDataFrame(int index, int start, int current, int goal, String unit, String icon) {
        super(index);
        this.goalData = new GoalData(start, current, goal, unit);
        this.icon = icon;
    }

    public static class GoalData {
        private final int start;
        private final int current;
        private final int goal;
        private final String unit;

        public GoalData(int start, int current, int goal, String unit) {
            this.start = start;
            this.current = current;
            this.goal = goal;
            this.unit = unit;
        }
    }

}
