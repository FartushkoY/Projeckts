package de.telran.lection8.anonymousclass;

public class SportGround {
    public static void main(String[] args) {

        String info = "info message";
//        info = "new info";

        Playable footballPlayer = new FootballPlayer();
        footballPlayer.play();

        Playable tennisPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("I play tennis");
//                info = "new info";
                System.out.println(info);
            }
        };

        tennisPlayer.play();

        Playable chessPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("I play chess");
            }
        };

        chessPlayer.play();
        chessPlayer.play();

        new Playable(){
            @Override
            public void play() {
                System.out.println("I play badminton");
            }
        }.play();



    }


}