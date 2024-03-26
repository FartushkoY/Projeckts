package de.telran.lection8.nestedclass;

public class Dog {

    private static final String DOG_INFO = "Dog info";

    private String name;

    private DogFood dogFood;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", dogFood=" + dogFood +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDogFood(DogFood dogFood) {
        this.dogFood = dogFood;
    }

    public static class DogFood {

        private String foodName;

        public DogFood(String foodName) {
            this.foodName = foodName;
            System.out.println(DOG_INFO);
//            System.out.println(name);
        }

        @Override
        public String toString() {
            return "DogFood{" +
                    "foodName='" + foodName + '\'' +
                    '}';
        }

        public static class FoodDetail {

        }
    }

}