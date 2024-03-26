package de.telran.lection4.game;

public class RockScissorsPaperGame {
    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();

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

        if (choice1 == choice2) {
            System.out.println("No one wins: " + choice1 + " --- " + choice2);
        } else {
            if ((choice1.ordinal() + 1) % 3 == choice2.ordinal()) {
                firstWins(player1, player2);
            } else {
                secondWins(player1, player2);
            }

            //        switch (choice1){
//            case SCISSORS -> {
//                switch (choice2) {
//                    case ROCK -> {
//                        secondWins(player1, player2);
//                    }
//                    case PAPER -> {
//                        firstWins(player1, player2);
//                    }
//                }
//            }
//        }

        }
    }

    private static void firstWins(Player player1, Player player2) {
        player1.setCountWins(player1.getCountWins() + 1);
        player2.setCountLoosed(player2.getCountLoosed() + 1);
        System.out.println("First wins: " + player1.getChoice() + " --- " + player2.getChoice());
    }

    private static void secondWins(Player player1, Player player2) {
        player1.setCountLoosed(player1.getCountLoosed() + 1);
        player2.setCountWins(player2.getCountWins() + 1);
        System.out.println("Second wins: " + player1.getChoice() + " --- " + player2.getChoice());
    }

}
