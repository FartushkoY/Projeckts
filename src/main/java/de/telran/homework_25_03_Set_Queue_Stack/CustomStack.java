package de.telran.homework_25_03_Set_Queue_Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * На основе библиотечного класса LinkedList реализовать такую структуру данных, как стек:
 *         Создать класс CustomStack с методами push(), pop(), peek(). Протестировать работу класса.
 */
public class CustomStack {
    private LinkedList<String> linkedList = new LinkedList<>();

    public void pushCS(String string) {
        linkedList.add(string);
    }

    @Override
    public String toString() {
        return "CustomStack{" +
                linkedList +
                '}';
    }

    public String peekCS(){
        return linkedList.getFirst();
    }

    public String popCS() {
        return linkedList.removeFirst();
    }


    public static void main(String[] args) {

        CustomStack customStack = new CustomStack();
        customStack.pushCS("A");
        customStack.pushCS("B");
        customStack.pushCS("C");
        customStack.pushCS("D");
        customStack.pushCS("E");
        System.out.println(customStack);

        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");



        Stack<LinkedList> stack = new Stack<>();
        stack.push(list);

        System.out.println(stack);

        System.out.println(customStack.peekCS());
        System.out.println(customStack);

        System.out.println(customStack.popCS());
        System.out.println(customStack.popCS());
        System.out.println(customStack.popCS());
        System.out.println(customStack);
    }
}
