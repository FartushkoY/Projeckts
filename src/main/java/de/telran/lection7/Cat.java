package de.telran.lection7;

import java.util.List;

public class Cat {

    private  String name;
    private List<Kitten> kittens;

    public Cat(String name) {
        this.name = name;
    }

    public Cat(String name, List<Kitten> kittens) {
        this.name = name;
        this.kittens = kittens;
    }

    public class Kitten {
        private  String kittenName;

        public Kitten(String kittenName) {
            this.kittenName = kittenName;
        }

        @Override
        public String toString() {
            return "Kitten{" +
                    "name='" + kittenName + '\'' +
                    '}' + " Mother name: " + name;
        }
    }



}
