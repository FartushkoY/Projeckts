package de.telran.lection17;

import java.util.Optional;

public class OptionalWithFlatMap {
    private static String noData;

    public static void main(String[] args) {

        Insurance insurance = new Insurance("insurance");
        Car car = new Car(insurance);

//        String name = car.getInsurance().get().getName().get(); //небезопасный вариант в случае null

        String name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        insurance = new Insurance();
        car = new Car(insurance);
        name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        car = new Car();
        name = car.getInsurance().flatMap(Insurance::getName).orElse("no insurance");
        System.out.println(name);

        Optional<Optional<String>> optional = Optional.of(Optional.of("Data"));
//        Optional<String> optionalString = optional.map(e -> e).get();  //не подходит
        String data = optional.flatMap(e -> e).orElse(noData);
        System.out.println(data);

    }

    static class Car {
        public Car() {
            this.insurance = Optional.empty();
        }

        private Optional<Insurance> insurance;

        public Car(Insurance insurance) {
            this.insurance = Optional.of(insurance);
        }

        public Optional<Insurance> getInsurance() {
            return insurance;
        }
    }

    static class Insurance {

        public Insurance() {
            this.name = Optional.empty();
        }

        private Optional<String> name;

        public Insurance(String name) {
            this.name = Optional.of(name);
        }

        public Optional<String> getName() {
            return name;
        }
    }



}
