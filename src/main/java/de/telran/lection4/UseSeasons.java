package de.telran.lection4;

import java.util.Arrays;
import java.util.SortedMap;

public class UseSeasons {
    public static void main(String[] args) {


        Season season = Season.AUTAMN;

        System.out.println(season);
        System.out.println(season.ordinal());
        Season[] seasons = Season.values();
        System.out.println(Arrays.toString(seasons));
        Season summer = Season.valueOf("SUMMER");
        System.out.println(summer);


        printSeasonMassage(season);

        String message = getSeasonMessage(season);
        System.out.println(message);


        }

//    private static String getSeasonMessage(Season season) {
//        String message = switch (season) {
//            case AUTAMN -> "Autumn message";
//            case SPRING -> "Spring message";
//            case SUMMER -> "Summer message";
//            case WINTER -> "Winter message";
//            };
//        return message;
//    }

//    Аналогичная, более короткая запись
    private static String getSeasonMessage(Season season) {
        return switch (season) {
            case AUTAMN -> {
                yield "Autumn message";
            }
            case SPRING -> "Spring message";
            case SUMMER -> "Summer message";
            case WINTER -> "Winter message";
        };
    }



    private static void printSeasonMassage(Season season) {
        switch (season) {
            case WINTER -> System.out.println("It's cold winter");
            case SPRING -> System.out.println("Spring is coming. Flowers are blooming");
            case AUTAMN -> System.out.println("It's rainy autumn");
            default -> System.out.println("Summer is the best season of year");
        }


//        записи аналогичны
//        switch (season) {
//            case WINTER:
//                System.out.println("It's cold winter");
//                break;
//            case SPRING:
//                System.out.println("Spring is coming. Flowers are blooming");
//                break;
//            case AUTAMN:
//                System.out.println("It's rainy autumn");
//                break;
//            default:
//                System.out.println("Summer is the best season of year");
//                break;
//        }


    }







}