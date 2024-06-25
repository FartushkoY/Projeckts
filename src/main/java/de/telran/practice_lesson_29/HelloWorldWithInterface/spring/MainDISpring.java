package de.telran.practice_lesson_29.HelloWorldWithInterface.spring;

import de.telran.practice_lesson_29.HelloWorldWithInterface.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDISpring {

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("spring/app-context.xml");

        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
