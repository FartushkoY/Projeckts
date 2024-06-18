package de.telran.summary13.Refactoring;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/** The algorithm that counts income for voters in accordance with their prediction.
 * <p>Logic of the algorithm:
 * <p>1. If a player had voted for a team that lost, the money of a player is put to the winner's pool.
 * <p>2. If a player had voted for a team that won, he/she recieves an income according to this formula:
 * <p>income = normKoeff * stake * EXPONENTIAL_QUANTITY^-abs(result - prediction);
 * <p>where:
 * "normKoeff" - normalized koeff.,
 * "stake" - player's money put on goal count "prediction",
 * "result" - real goal count.*/

public class GainAlgorithm {

    private static final int EXPONENTIAL_QUANTITY = 3;
    private static final int MAX_GOAL_DIFFERENCE = 5;

    public static ArrayList<Bet> calculateIncomeForWinningBets(Match match, List<Bet> list) {
//        ArrayList<Bet> winingBets = new ArrayList<>();
//        for (Bet bet : list) {
//            if (bet.hasWon(match)) {
//                winingBets.add(bet);
//            }
//        }

        ArrayList<Bet> winingBets = list.stream().filter(bet -> bet.hasWon(match)).collect(Collectors.toCollection(ArrayList::new));


        int goalDifference = match.getGoalDifference();
        double[] koeff = getNormCoeffArray(goalDifference);

        double[] listKoeff = new double[winingBets.size()];
        // find listKoeff and total sum of listKoeff for normalization
        double sumKoeff = 0;
        for (int i = 0; i < winingBets.size(); i++) {
            Bet bet = winingBets.get(i);
            listKoeff[i] = koeff[Math.abs(bet.getCondition()) - 1] * bet.getStake();
            sumKoeff += listKoeff[i];
        }
        int pricepool = getPricePool(match, list);
        double normKoeff = (double) pricepool / sumKoeff;

        // set earned money for the list of bets
        for (int i = 0; i < winingBets.size(); i++) {
            Bet bet = winingBets.get(i);
            bet.setEarned(bet.getStake() + (int) (normKoeff * listKoeff[i]));
        }
        return winingBets;
    }

    private static double[] getNormCoeffArray(int goalDifference) {
        double[] normCoeffArray = new double[MAX_GOAL_DIFFERENCE];
        for (int i = 0; i < MAX_GOAL_DIFFERENCE; i++) {
            normCoeffArray[i] = Math.pow(EXPONENTIAL_QUANTITY, -Math.abs(Math.abs(goalDifference) - i - 1));
        }
        return normCoeffArray;
    }

    private static int getPricePool(Match match, List<Bet> list) {
        int pricepool = 0;
        for (Bet bet : list) {
            if (!bet.hasWon(match)) {
                pricepool += bet.getStake();
            }
        }
        return pricepool;
    }
}