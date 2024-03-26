package de.telran.summary2;

public class Book {

    private String name = "Name";

    public void printBookInfo() {
        String info = "Info";
        int x = 10;

        innerMethod(info, x);
    }

    private void innerMethod(String info, int x) {
//        innerMethod(info, x);       // будет зацикливание до момента переполнения памяти (стека)
        System.out.println(info + " " + x);
        System.out.println(this.name);

    }


    public static void main(String[] args) {
        Book book = new Book();

        book.printBookInfo();
    }

}
