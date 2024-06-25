package de.telran.practice_lesson_29.HelloWorldWithInterface;

public class MessageProviderImplement implements MessageProvider{
    @Override
    public String getMessage() {
        return "new text";
    }
}
