package de.telran.homework_17_05_Tests;

import de.telran.lection13.TopKTask;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TopKTaskTest {
    private static List<TopKTask.Item> items = new ArrayList<>();
    private static TopKTask.Item item1 = new TopKTask.Item("Book", 100);
    private static TopKTask.Item item2 = new TopKTask.Item("Toy1", 50);
    private static TopKTask.Item item3 = new TopKTask.Item("Toy2", 50);
    private static TopKTask.Item item4 = new TopKTask.Item("Toy3", 12);
    private static TopKTask.Item item5 = new TopKTask.Item("Toy4", 32);
    private static TopKTask.Item item6 = new TopKTask.Item("Toy5", 23);
    private static TopKTask.Item item7 = new TopKTask.Item("Toy6", 50);
    private static TopKTask.Item item8 = new TopKTask.Item("Doll", 25);



    @Test
    public void topKWithPriorityQueue() {
        items = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8);
        List<TopKTask.Item> result = TopKTask.topKWithPriorityQueue(items, 3);
        List<TopKTask.Item> expected = Arrays.asList(item4, item6, item8);
        assertEquals(expected, result);

        items = Arrays.asList(item1, item1, item1, item1, item1);
        result = TopKTask.topKWithPriorityQueue(items, 3);
        expected = Arrays.asList(item1, item1, item1);
        assertEquals(expected, result);

        items = Arrays.asList(item1, item2, item3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> TopKTask.topKWithPriorityQueue(items, 4));

        items = Arrays.asList(item1, item2, item3);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> TopKTask.topKWithPriorityQueue(items, -4));

        items = Arrays.asList(item1, item2, item3);
        assertThrows(NullPointerException.class, () -> TopKTask.topKWithPriorityQueue(items, 0));

        items = null;
        assertThrows(NullPointerException.class, () -> TopKTask.topKWithPriorityQueue(items, 4));
    }
}