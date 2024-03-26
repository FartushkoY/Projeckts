package de.telran.practice_lesson_6;

public class LinkedListIntSingly {
    private Node head;


    private int size;

    public void add(int element) {
        Node newNode = new Node();
        newNode.setData(element);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size++;
    }


    public void addFirst(int element) {
        Node newNode = new Node();
        newNode.setData(element);
        if (head == null) {
            head = newNode;
        } else {
            Node node = head;

            while (node.getNext() != null) {
                node = node.getNext();
            }
            node.setNext(newNode);

        }
        size++;
    }


    public void show() {
        Node node = head;
        StringBuilder outStr = new StringBuilder("[");
        while (node != null && node.getNext() != null) {
            outStr.append(node.getData() + ",");
            node = node.getNext();
        }
        outStr.append(((node != null) ? node.getData() : "") + "]");
        System.out.println(outStr);
    }
//        if(node.getNext() != null) {     запись, аналогичная предыдущей
//            node = node.getNext();
//        } else node = node;


    public int getSize() {
        return size;
    }

    public void delete(int element) {
        if (head == null) {
            return;
        }
        Node node = head;
        Node preNode = null;
        while (node.getNext() != null) {
            if (node.getData() == element) {
                if (preNode == null) {
                    head = node.getNext();
                } else {
                    preNode.setNext(node.getNext());
                }
                size--;
                return;
            }
            preNode = node;
            node = node.getNext();
            if (node.getNext() == null) {
                preNode.setNext(null);
                size--;
            }
        }

    }

    public void insert(int index, int element) {
        Node newNode = new Node();
        newNode.setData(element);
        if (head == null) {
            head = newNode;
            return;
        }
        if (index == size - 1) {
            add(element);
        }

        Node node = head;
        Node prevNode = null;
        //первый вариант
        for (int i = 0; i < size; i++) {
            if (index == i) {
                if (prevNode != null) {
                    prevNode.setNext(newNode);
                    newNode.setNext(node);
                    size++;
                    return;
                }
            }
            prevNode = node;
            node = node.getNext();

        }
    }


}
