package de.telran.practice_lesson_29.HelloWorldWithInterface;

public class MessageRendererNew implements MessageRenderer{

    private MessageProvider messageProvider;
    @Override
    public void render() {
        System.out.println("********");
        System.out.println("** " + messageProvider.getMessage() + " **");
        System.out.println("********");
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;

    }

    @Override
    public MessageProvider getMessageProvider() {
        return messageProvider;
    }
}
