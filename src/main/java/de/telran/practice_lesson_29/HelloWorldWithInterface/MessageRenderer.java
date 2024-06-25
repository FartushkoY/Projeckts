package de.telran.practice_lesson_29.HelloWorldWithInterface;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();

}
