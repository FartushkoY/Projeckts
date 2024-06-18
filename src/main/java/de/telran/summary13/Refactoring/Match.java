package de.telran.summary13.Refactoring;

public class Match {
    private Integer goalsA = 0;
    private Integer goalsB = 0;

    public int getGoalDifference(){
        return goalsA - goalsB;
    }

    public void setGoalsA(Integer goalsA) {
        this.goalsA = goalsA;
    }

    public void setGoalsB(Integer goalsB) {
        this.goalsB = goalsB;
    }
}
