package de.telran.practice_lesson_29.HelloWorldWithInterface.factory;

import de.telran.practice_lesson_29.HelloWorldWithInterface.MessageProvider;
import de.telran.practice_lesson_29.HelloWorldWithInterface.MessageProviderHelloWorld;
import de.telran.practice_lesson_29.HelloWorldWithInterface.MessageRenderer;

public class MainFactory {

    public static void main(String[] args) {

        MessageRenderer messageRenderer = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();

    }
}
