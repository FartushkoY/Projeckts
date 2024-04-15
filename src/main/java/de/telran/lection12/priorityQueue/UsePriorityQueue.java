package de.telran.lection12.priorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class UsePriorityQueue {

    static class ProjectManager {
        Queue<Task> tasks;
        int count = 0;

        public ProjectManager(Queue<Task> tasks) {
            this.tasks = tasks;
        }

        public void giveTasks() {
            Random random = new Random();
            for (int i = 0; i < 5; i++) {
                tasks.add(new Task("Task " + count++, random.nextInt(1, 10)));
            }
        }

    }

    static class Programmer {
        Queue<Task> tasks;

        public Programmer(Queue<Task> tasks) {
            this.tasks = tasks;
        }

        public void doTask() {
            if (!tasks.isEmpty()) {
                Task task = tasks.poll();
                System.out.println(this.toString() + " doing task " + task);
            }
        }

        @Override
        public String toString() {
            return "Programmer";
        }
    }

    static class Task {
        String description;
        Integer priority;

        public Task(String description, Integer priority) {
            this.description = description;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "description='" + description + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }

    public static void main(String[] args) {
        Queue<Task> taskQueue = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.priority - o1.priority;
            }
        });
        ProjectManager manager = new ProjectManager(taskQueue);
        Programmer programmer1 = new Programmer(taskQueue);
        Programmer programmer2 = new Programmer(taskQueue);

        manager.giveTasks();
        programmer1.doTask();
        programmer2.doTask();
        programmer1.doTask();
        programmer2.doTask();
        programmer2.doTask();
    }




}
