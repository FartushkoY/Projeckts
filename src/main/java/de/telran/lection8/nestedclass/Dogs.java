package de.telran.lection8.nestedclass;
import de.telran.lection8.nestedclass.Dog.DogFood;

public class Dogs {
    public static void main(String[] args) {
        Dog dog = new Dog("Jack");

       // Dog.DogFood dogFood = new Dog.DogFood("bone");      // если не импортировать, запись будет более сложной
       DogFood dogFood = new Dog.DogFood("bone");   // можно так, но нужно сделать импорт соответствующего класса
                                                        // (de.telran.lection8.nestedclass.Dog.DogFood;)

        dog.setDogFood(dogFood);
        System.out.println(dog);


    }
}
