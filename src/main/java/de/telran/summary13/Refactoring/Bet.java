package de.telran.summary13.Refactoring;

public class Bet {
    private Integer stake;
    private Integer earned;
    private Integer condition;

    public Integer getStake() {
        return stake;
    }


    public void setStake(Integer stake) {
        this.stake = stake;
    }

    public Integer getEarned() {
        return earned;
    }

    public void setEarned(Integer earned) {
        this.earned = earned;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public boolean hasWon(Match match) {
        return match.getGoalDifference() * condition > 0;
    }


}
