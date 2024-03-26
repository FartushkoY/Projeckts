package de.telran.homeworkLinkedList.office;

public interface JobActions {
    void doTask();
    void haveRest();

    class Task {
        private String name;
        private String description;


        public Task(String name, String description) {
            this.name = name;
            this.description = description;
        }

        @Override
        public String toString() {
            return name + " " + description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


}
