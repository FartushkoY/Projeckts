package de.telran.lection8.methodlocalclass;
import java.util.Arrays;
import java.util.List;

public class ProcessData {

    public static void main(String[] args) {

        ProcessData processData = new ProcessData();
        processData.process(Arrays.asList("A", "B", "C", "D"));

    }


    public void process(List<String> dataList) {

        String stringValue = "effectively final var"; // effectively final, т е переменную нельзя изменять из внутреннего класса
//        stringValue = "new value";

        class Data {
            String element1;
            String element2;

            public Data(String element1, String element2) {
                this.element1 = element1;
                this.element2 = element2;
            }

            void print() {
                System.out.println(stringValue);
            }

            @Override
            public String toString() {
                return "Data{" +
                        "element1='" + element1 + '\'' +
                        ", element2='" + element2 + '\'' +
                        '}';
            }
        }

        Data data1 = new Data(dataList.get(0), dataList.get(1));
        Data data2 = new Data(dataList.get(2), dataList.get(3));
        System.out.println(data1);
        System.out.println(data2);
        data1.print();

        // do something with data1, data2
    }

    public void process2(){
        class Data {

        }
//        Data data1 = new Data("a", "b");
    }


}