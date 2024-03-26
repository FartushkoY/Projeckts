package de.telran.summary3;

public class TwoDimensionExamples {

    public static void main(String[] args) {

        String[][] stringArray = new String[3][];
        stringArray[0] = new String[2];
        stringArray[1] = new String[3];
        stringArray[2] = new String[4];
        stringArray[0][0] = "A";
        stringArray[0][1] = "A";
        stringArray[1][0] = "B";
        stringArray[1][1] = "B";
        stringArray[1][2] = "B";
        stringArray[2][0] = "C";
        stringArray[2][1] = "C";
        stringArray[2][2] = "C";
        stringArray[2][3] = "C";

//        print2DArray(stringArray);

//        List<List<List<String>>> stringListOfLists = new ArrayList<>();
//        stringListOfLists.add(new ArrayList<>());
//        stringListOfLists.add(new ArrayList<>());
//        stringListOfLists.add(new ArrayList<>());
//        stringListOfLists.get(0).add(new ArrayList<>());
//        stringListOfLists.get(0).get(0).add("A");
//        stringListOfLists.get(0).get(1).add("A");
//        stringListOfLists.get(1).add(new ArrayList<>());
//        stringListOfLists.get(1).get(0).add("B");
//        stringListOfLists.get(1).get(1).add("B");
//        stringListOfLists.get(1).get(2).add("B");
//        stringListOfLists.get(2).add(new ArrayList<>());
//        stringListOfLists.get(2).get(0).add("C");
//        stringListOfLists.get(2).get(1).add("C");
//        stringListOfLists.get(2).get(2).add("C");
//        stringListOfLists.get(2).get(3).add("C");

//        System.out.println(stringListOfLists);








    }


//    private static void print2DArray(List<List<List<String>>> listOfLists) {
//        for (int i = 0; i < listOfLists.size(); i++) {
//            for (int j = 0; j < listOfLists[i].get()length; j++) {
//                System.out.print(listOfLists[i][j] + " ");
//            }
//            System.out.println("\n");
//
//        }
//    }


    private static void print3DArray(String[][] array2D) {
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println("\n");

        }
    }
}
