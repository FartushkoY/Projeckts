package de.telran.lection1.house;

public class House {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", 2, "white");
        Cat cat2 = new Cat("Vasya", 1, "black");
//        cat1.sayHello();
//        cat2.sayHello();

//        System.out.println(cat1.isHungry());
//        cat1.feed();
//        System.out.println(cat1.isHungry());

//        Robot.printTotalRobotCount();
//
//        Robot robot1 = new Robot("Valuum cleaner", "Robot cleaner");
//        Robot robot2 = new Robot("Washing mashine", "Robot to wash something");
//        robot1.printCurrentRobotInfo();
//        robot2.printCurrentRobotInfo();
//
////        robot1.printTotalRobotCount();
////        robot2.printTotalRobotCount();
//        Robot.printTotalRobotCount();

        Dog dog = new Dog("Jack", 1, "grey");
//        dog.bark();
//        dog.sayHello();
//        dog.feed();

//        Animal animal = dog;
//        animal.displayAnimalInfo();
//        animal = cat1;
//        animal.displayAnimalInfo();

//        Animal animal = new Animal("Jack", "grey", 1);

        Human human = new Human("Harry", 30);
//        human.feedAnimal(dog);
//        human.feedAnimal(dog, cat1, cat2);


        cat2.play(dog);
        System.out.println("------------------");
        dog.play(cat1);
        System.out.println("------------------");
        human.play(cat1);
        System.out.println("------------------");
        dog.play(human);
        System.out.println("------------------");
        human.walkAnimal(dog);
        System.out.println("Is " + dog.getName() + " hungry? " + dog.isHungry());

        human.walkAnimal(dog);
        human.walkAnimal(cat1);

        Robot robotHelfer =new Robot("Smarty", "helfer", 1);
        Mouse mouse = new Mouse("Jarry", 1, "white");
        robotHelfer.walkAnimal(cat2);
        robotHelfer.catchMouse(mouse);
        cat2.catchMouse(mouse);

        cat2.grow();
        human.grow();
        dog.grow();
        mouse.grow();



    }
}
