package de.telran.lection14;

import de.telran.lection8.anonymousclass.FootballPlayer;

public class SportGround {
    public static void main(String[] args) {
        Playable footballPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("I play football");
            }
        };

        Playable badmintonPlayer = () -> System.out.println("I play badminton");
        Playable cheesPlayer = () -> {
            System.out.println("I play chess");
            System.out.println("I won!");
        };

        footballPlayer.play();
        badmintonPlayer.play();
        cheesPlayer.play();

    }
}