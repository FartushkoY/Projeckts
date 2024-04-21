package de.telran.lection16;

import java.util.*;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(23, 0, 11, 32, 65, 77, 12, 12, 87, 0);
//        List<Integer> integerList = Collections.emptyList();

//        List<Integer> result = integerList.stream().filter(integer -> integer %2 == 0).toList();   // неизменяемый список
        List<Integer> result = integerList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());  // изменяемый список
        result.add(6);

        Set<Integer> resultSet = integerList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toSet());
        System.out.println(resultSet);
        resultSet = integerList.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toCollection(TreeSet::new));
//        result = integerList.stream().filter(integer -> integer %2 == 0).collect(Collectors.toCollection(LinkedHashSet::new));

        Optional<Integer> first = integerList.stream().sorted().findFirst();
        Integer firstInteger = first.orElse(-1);
        System.out.println(firstInteger);
        Integer resultWithGet = first.get(); // возвращает данные из Optional, если они есть и выбрасывает ошибку, если их нет
        System.out.println(resultWithGet);

        Optional<Integer> any = integerList.stream().sorted().findAny();
        System.out.println(any.get());

        boolean isPresent = integerList.stream().anyMatch(integer -> integer == 33);
        System.out.println(isPresent);

        boolean all11 = integerList.stream().allMatch(integer -> integer == 11);
        System.out.println(all11);

        Optional<Integer> max = integerList.stream().max(Integer::compareTo);  // O(n)
//       max = integerList.stream().sorted(Comparator.reverseOrder()).findFirst();  // O(n log n)
        System.out.println(max.get());

        integerList.stream().filter(integer -> integer %2 == 0).forEach(System.out::println);
        long numberCount = integerList.stream().filter(integer -> integer %2 == 0).count();
        System.out.println(numberCount);





    }

}
