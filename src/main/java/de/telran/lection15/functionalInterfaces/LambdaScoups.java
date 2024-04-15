package de.telran.lection15.functionalInterfaces;

import de.telran.lection14.Playable;

public class LambdaScoups {
    public static void main(String[] args) {

        String data = "Main data";
        int counter = 0; // must be effectively final

        Playable footballPlayer = new Playable() {

            String data = "Anonymous data";

            @Override
            public void play() {
                System.out.println(data);
                System.out.println(counter);
            }
        };

        footballPlayer.play();

        Playable chessPlayer = () -> {
            String data2 = "Lambda Data";
            System.out.println(data2);
        };

        chessPlayer.play();


    }
}
