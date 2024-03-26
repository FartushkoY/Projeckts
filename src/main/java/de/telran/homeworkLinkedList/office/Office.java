package de.telran.homeworkLinkedList.office;

public class Office {

    public static void main(String[] args) {
        JobActions.Task workTask1 = new JobActions.Task("manager", "сообщает название заданий");
        JobActions.Task workTask2 = new JobActions.Task("worker", "делает задания");
        JobActions.Task workRestTask3 = new JobActions.Task("lazyWorker", "бездействует");
        JobActions.Task restTask1 = new JobActions.Task("manager", "пьет кофе");
        JobActions.Task restTask2 = new JobActions.Task("worker", "курит");


        JobActions manager = new JobActions() {
            @Override
            public void doTask() {
                System.out.println(workTask1);
            }

            @Override
            public void haveRest() {
                System.out.println(restTask1);

            }
        };

        JobActions worker = new JobActions() {
            @Override
            public void doTask() {
                System.out.println(workTask2);
            }

            @Override
            public void haveRest() {
                System.out.println(restTask2);

            }
        };

        JobActions lazyWorker = new JobActions() {
            @Override
            public void doTask() {
                System.out.println(workRestTask3);
            }

            @Override
            public void haveRest() {
                System.out.println(workRestTask3);
            }
        };

        manager.doTask();
        manager.haveRest();
        worker.doTask();
        worker.haveRest();
        lazyWorker.doTask();
        lazyWorker.haveRest();
    }
}
