package de.telran.lection5;

public class UseBox {
    public static void main(String[] args) {

//        Box box1 = new Box("toy", 5, true);
//
//        System.out.println(box1);
//        box1.empty();
//        System.out.println(box1);
//
//        String item= box1.getItem();
//        if (item != null) {
//            System.out.println(item.toUpperCase());               // NullPointerException, т к вызывается метод на стринге, не имеющей ссылки (null)
//        } else {                                                  //  необходима предварительная проверка на null
//            System.out.println("Item is null. Box is empty");
//        }
//
//        String someData = getSomeData();
//        if (someData != null && someData.length() != 0) {
//            System.out.println(someData.charAt(0));
//            //prosess data
//        } else {
//            //some other logic
//        }
//
//        int number = getSomeInt();
//        System.out.println(number);

        Cat cat = new Cat("Tom", "white", 3);
        Box box = new Box("toy", 5, true, cat);
        System.out.println(box);
        Box shallowCopyBox = box.shallowCopy();
        box.getCat().setName("Vasya");

        System.out.println("After changing name, shallowCopy:");
        System.out.println(box);
        System.out.println(shallowCopyBox);

        System.out.println("After changing name, deepCopy:");
        Box deepCopyBox = box.deepCopy();
        box.getCat().setName("Tom");
        System.out.println(box);
        System.out.println(deepCopyBox);


//        try {
//            Cat catClone = cat.clone();
//            System.out.println(catClone);
//        } catch (CloneNotSupportedException e) {
//            System.out.println("CloneNotSupportedException");
//        }

        try {

            System.out.println("After changing name, deep clone:");
            Box boxClone = box.clone();
            box.getCat().setName("New name");
            System.out.println(box);
            System.out.println(boxClone);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
        }

    }


    public static String getSomeData() {
        return "dsdgnagna";
    }

    public static int getSomeInt() {
        return 24;
    }
}
