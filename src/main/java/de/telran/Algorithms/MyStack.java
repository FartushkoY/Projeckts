package de.telran.Algorithms;

public class MyStack {


    private static class Link {

        private final int value;
        private final Link next;

        public Link(int value, Link next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Link getNext() {
            return next;
        }
    }

    private Link head = null;

    public boolean isEmpty() {
        return head == null;
    }

    public void push(int v) {
        Link nextHead = new Link(v, head);
        head = nextHead;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Error");
            return -1;
        } else {
            int result = head.getValue();
            head = head.getNext();
            return result;
        }
    }

    public String print() {
        StringBuilder result = new StringBuilder();
        if (isEmpty()) {
            result.append("<empty>");
        } else {
            result.append(" -> ").append(head.value);
            Link current = head.getNext();
            while (current != null) {
                result.append(", ").append(current.getValue());
                current = current.getNext();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println(stack.print());

        stack.push(20);
        System.out.println(stack.print());

        stack.push(30);
        System.out.println(stack.print());

        stack.push(40);
        System.out.println(stack.print());

        stack.pop();
        stack.pop();
        System.out.println(stack.print());

        stack.pop();
        System.out.println(stack.print());
    }
}

