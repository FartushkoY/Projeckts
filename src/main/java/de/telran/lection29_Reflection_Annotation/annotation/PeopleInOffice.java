package de.telran.lection29_Reflection_Annotation.annotation;

import java.lang.reflect.Field;

public class PeopleInOffice {
    @Name("Tom")
    String person1;

    @Name(value = "Jane", department = "Sales", count = 2)
    String person2;

    @Name(value = "Mark", department = "IT")
    String person3;


    public static void main(String[] args) throws NoSuchFieldException {
        PeopleInOffice peopleInOffice = new PeopleInOffice();
        System.out.println(peopleInOffice.person1);
        System.out.println(peopleInOffice.person2);
        System.out.println(peopleInOffice.person3);

        Injector.inject(peopleInOffice);

//        Class<? extends PeopleInOffice> peopleInOfficeClass = peopleInOffice.getClass();
//        Field field = peopleInOfficeClass.getDeclaredField("person1");
//        Name annotation = field.getAnnotation(Name.class);
//        String value = annotation.value();
//        peopleInOffice.person1 = value;
//        System.out.println(value);
//        System.out.println(annotation.department());
//        System.out.println(annotation.count());

        System.out.println(peopleInOffice.person1);
        System.out.println(peopleInOffice.person2);
        System.out.println(peopleInOffice.person3);
    }


    static class Injector {
        public static void inject(Object instance) {
            Field[] fields = instance.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Name.class)) {
                    Name annotation = field.getAnnotation(Name.class);
                    field.setAccessible(true); // should work on private fields
                    try {
                        field.set(instance, annotation.value());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
