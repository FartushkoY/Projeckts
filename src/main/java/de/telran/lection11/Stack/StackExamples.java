package de.telran.lection11.Stack;

import java.util.Stack;

public class StackExamples {

    public static void main(String[] args) {

        // LIFO
        Stack<Integer> stack =new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.peek());
        int position = stack.search(3);
        System.out.println(position);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }
}
