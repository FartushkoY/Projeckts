package de.telran.summary13.Refactoring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class GainAlgorithmTest {

    private static final int MAX_GOAL_DIFFERENCE = 5;
    private List<Bet> betList;
    private List<Bet> betListResult;
    private Match match;

    @BeforeEach
    public void setup() {
        match = new Match();
        betList = createTestBetList();
    }

    @Test
    public void testAtLeastOneWinnerGetsNotNull() {
        for (int goalDifference = -MAX_GOAL_DIFFERENCE + 5; goalDifference < MAX_GOAL_DIFFERENCE + 1 + 5;
             goalDifference++) {
            if (goalDifference == 0) {
                continue;
            }
            match.setGoalsA(goalDifference);
            match.setGoalsB(0);
            int winnerMoney = 0;
            betListResult = GainAlgorithm.calculateIncomeForWinningBets(match, betList);
            for (Bet bet : betListResult) {
                winnerMoney = bet.getEarned();
                if (winnerMoney > 0) {
                    break;
                }
            }
            assertTrue(winnerMoney > 0);
        }
    }

    @Test
    public void testGainMaxProfitForVictoryBet() {
        for (int goalDifference = -MAX_GOAL_DIFFERENCE; goalDifference < MAX_GOAL_DIFFERENCE + 1;
             goalDifference++) {
            if (goalDifference == 0) {
                continue;
            }
            match.setGoalsA(goalDifference);
            match.setGoalsB(0);
            int winnerMoney = 0;
            betListResult = GainAlgorithm.calculateIncomeForWinningBets(match, betList);
            for (Bet bet : betListResult) {
                if (hasPredictedCorrectly(goalDifference, bet)) {
                    winnerMoney = bet.getEarned();
                    break;
                }
            }
            for (Bet bet : betListResult) {
                assertTrue(winnerMoney >= bet.getEarned());
            }
        }
    }

    @Test
    public void testAllBetsWonInTheOutputList() {
        for (int goalDifference = -MAX_GOAL_DIFFERENCE - 5; goalDifference < MAX_GOAL_DIFFERENCE + 1 + 5;
             goalDifference++) {
            if (goalDifference == 0) {
                continue;
            }
            match.setGoalsA(goalDifference);
            match.setGoalsB(0);
            betListResult = GainAlgorithm.calculateIncomeForWinningBets(match, betList);
            for (Bet bet : betListResult) {
                assertTrue(bet.hasWon(match));
            }
        }
    }

    @Test
    public void testBalanceForPricePoolBetweenLosersAndWinners() {
        for (int goalDifference = -MAX_GOAL_DIFFERENCE - 5; goalDifference < MAX_GOAL_DIFFERENCE + 1 + 5; goalDifference++) {
            if (goalDifference == 0) {
                continue;
            }
            match.setGoalsA(goalDifference);
            match.setGoalsB(0);
            int balance = 0;
            int totalgain = 0;
            for (Bet bet : betList) {
                if (!bet.hasWon(match)) {
                    balance += bet.getStake();
                }
            }
            betListResult = GainAlgorithm.calculateIncomeForWinningBets(match, betList);
            for (Bet bet : betListResult) {
                totalgain += bet.getEarned() - bet.getStake();
            }
            assertTrue(totalgain <= balance);
        }
    }

    private List<Bet> createTestBetList() {
        betList = new ArrayList<>();
        int stake = 10;
        int betsCount = 10;
        for (int i = 0; i < betsCount + 1; i++) {
            if (i == MAX_GOAL_DIFFERENCE) {
                continue;
            }
            Bet bet = new Bet();
            bet.setCondition(i - MAX_GOAL_DIFFERENCE);
            bet.setStake(stake);
            betList.add(bet);
        }
        return betList;
    }

    private boolean hasPredictedCorrectly(int goalDifference, Bet bet) {
        return bet.getCondition() == goalDifference;
    }
}
