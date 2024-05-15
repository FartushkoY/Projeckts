package de.telran.practice_lesson_19.jackson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class MainJson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper(); // jaсkson подключен
        Person person = new Person("Вася", "Пупкин",
                new Address(7, "Н", "Бассейная"));

        String json = om.writeValueAsString(person);
        System.out.println("Write object - "+json);
        //представьте что строка поступила снаружи
        json = "{\"firstName\":\"Вася\",\"lastName\":\"Пупкин\",\"address\":{\"countryCode\":7,\"city\":\"Н\",\"street\":\"Бассейная\",\"number\":99}}";
        Person read = om.readValue(json, Person.class);
        System.out.printf("Read person: %s\n", read);
    }
}
