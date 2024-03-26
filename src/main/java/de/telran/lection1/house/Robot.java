package de.telran.lection1.house;

public class Robot extends Creature implements Walking, Mousetrap{
    private static int robotCount = 0;

    private static final int ROBOT_DEFAULT_VERSION = 1;

    private String name = "Name";

    private String description;

    private int version;

    public Robot(String name, String description, int version) {
        super(name);
        this.description = description;
        this.version = version;
        robotCount++;
    }

    public Robot(String name, String description) {
        super(name);
        this.description = description;
        this.version = ROBOT_DEFAULT_VERSION;
        robotCount++;
    }

    public static void printTotalRobotCount(){
//        System.out.println(this.name); impossible
        System.out.println("Total robot number = " + robotCount);
    }

    public void printCurrentRobotInfo() {
        System.out.println(name + ", description: " + description + ", version: " + version);
        System.out.println("Total robot number = " + robotCount);
    }

    public void sayHello() {
        System.out.println("Hello! I'm Robot. My name is " + super.getClass().getName());
    }

    @Override
    public void catchMouse(Mouse mouse) {
        System.out.println(getName() + " catch Mouse " + mouse.getName());
    }

    @Override
    public void walkAnimal(Animal animal) {
        System.out.println(getName() + " walking with " + animal.getName());
        animal.setHungry(true);
    }
}
