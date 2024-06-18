package de.telran.summary13.Refactoring.game;

public class RockScissorsPaperGame {
    public static void main(String[] args) {

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");

        while (player1.getCountWins() < 5) {
            gameRound(player1, player2);
        }
        System.out.println(player1);
        System.out.println(player2);

    }

    public static void gameRound(Player player1, Player player2) {
        player1.makeRandomChoice();
        player2.makeRandomChoice();
        GameChoice choice1 = player1.getChoice();
        GameChoice choice2 = player2.getChoice();

        if (player1.getChoice() == player2.getChoice()) {
            System.out.println("No one wins: " + player1.getChoice() + " --- " + player2.getChoice());
        } else if ((choice1.ordinal() + 1) % 3 == choice2.ordinal()) {
            getResul(player1, player2);
        } else {
            getResul(player2, player1);
        }
    }


    private static void getResul(Player winner, Player looser) {
        winner.setCountWins(winner.getCountWins() + 1);
        looser.setCountLoosed(looser.getCountLoosed() + 1);
        System.out.println(winner.getName() + " winns: " + winner.getChoice() + " --- " + looser.getChoice());
    }
}
