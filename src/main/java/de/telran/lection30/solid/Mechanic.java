package de.telran.lection30.solid;

public class Mechanic {

    public void service(Car car) {
        commonService(car);
        specialService(car);
        washingService(car);



    }


    private void commonService(Car car) {
        System.out.println("Common service for " + car);

    }

//    private void specialService(Car car) {
//        if (car instanceof Tesla) {
//            System.out.println("Installing new batteries for " + car);
//        } else if (car instanceof Mercedes) {
//            System.out.println("Servicing mercedes " + car);
//        } else {
//            System.out.println("Default actions");
//        }
//    }

    private void specialService(Car car){
        car.getCarService().service(car);
    }


    private void washingService(Car car) {
        System.out.println("Washing the car " + car);
    }

    public static void main(String[] args) {
        Mechanic mechanic = new Mechanic();
        Car mercedes = new Mercedes();
        Car tesla = new Tesla();
        Car newTesla = new TeslaNewVersion();

        mechanic.service(mercedes);
        mechanic.service(tesla);
        mechanic.service(newTesla);
    }
}
