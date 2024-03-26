package de.telran.homework.gameUpdate;

import java.util.Scanner;

import static de.telran.homework.gameUpdate.RockScissorsPaperGame.gameRound;

public class GameAction {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player();
        Player myPlayer = new Player();

        while (myPlayer.getCountLoosed() < 3) {
            System.out.println("Make your choice:");
            System.out.println("0 - ROCK");
            System.out.println("1 - SCISSORS");
            System.out.println("2 - PAPER");
            int choise = scanner.nextInt();
            myPlayer.setChoice(GameChoice.values()[choise]);
            gameRound(myPlayer, player1);
        }
        System.out.println("Wins: " + myPlayer.getCountWins() + "; losses: " + myPlayer.getCountLoosed());
    }
}
