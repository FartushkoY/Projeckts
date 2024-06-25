package de.telran.practice_lesson_29.HelloWorldWithInterface;

public class MessageProviderHelloWorld implements MessageProvider{
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
