package de.telran.practice_lesson_29.HelloWorldWithInterface;

public class Main {

    public static void main(String[] args) {
        MessageProvider messageProvider = new MessageProviderHelloWorld();
        MessageProvider messageProvider2 = new MessageProviderImplement();
        MessageRenderer messageRenderer = new MessageRendererSOUT();

        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
        messageRenderer.setMessageProvider(messageProvider2);
        messageRenderer.render();


        MessageRenderer messageRenderer2 = new MessageRendererNew();
        messageRenderer2.setMessageProvider(messageProvider);
        messageRenderer2.render();
        messageRenderer2.setMessageProvider(messageProvider2);
        messageRenderer2.render();

    }
}
