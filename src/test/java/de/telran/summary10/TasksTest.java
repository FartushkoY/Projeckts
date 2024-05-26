package de.telran.summary10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static de.telran.summary10.Tasks.findSecondMax;
import static de.telran.summary10.Tasks.findSecondMaxWithStream;
import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {
    @Test
    public void findDublicatesTest() {

        List<String> expected = Collections.emptyList();
        List<String> actual = Tasks.findDublicates(null);
        assertEquals(expected.toString(), actual.toString());


        expected = Collections.emptyList();
        actual = Tasks.findDublicates("");
        assertEquals(expected.toString(), actual.toString());


        expected = Collections.emptyList();
        actual = Tasks.findDublicates("one cat hello world oneA login: admin password cat ");
        assertEquals(expected.toString(), actual.toString());


        expected = Arrays.asList("hello");
        actual = Tasks.findDublicates("one cat hello hello world oneA login: hello admin admin password cat ");
        assertEquals(expected.toString(), actual.toString());

        expected = Arrays.asList("hello", "admin");
        actual = Tasks.findDublicates("hello Hello one cat  world oneA login: hello admin admin password cat ");
        assertEquals(expected.toString(), actual.toString());

        expected = Arrays.asList("hello");
        actual = Tasks.findDublicates("one cat  world oneA login: hello admin password cat hello, hello");
        assertEquals(expected.toString(), actual.toString());


        expected = Collections.emptyList();
        actual = Tasks.findDublicates("one cat hello1 hello1 world oneA login: hello admin password cat ");
        assertEquals(expected.toString(), actual.toString());

        expected = Collections.emptyList();
        actual = Tasks.findDublicates("12345 12345");
        assertEquals(expected.toString(), actual.toString());


    }


    @Test
    void testfindSecondMax() {
        assertThrows(IllegalArgumentException.class, () -> findSecondMax(null));
        int[] array = {-10, -11};
        assertEquals(-11, findSecondMax(array));

        array = new int[]{1, 2, 3, 3};
        assertEquals(3, findSecondMax(array));

        array = new int[]{1, 1, 1, 1, 1, 1};
        assertEquals(1, findSecondMax(array));


        assertThrows(IllegalArgumentException.class, () -> findSecondMax(new int[]{1}));
    }


    @Test
    void testfindSecondMaxWithStream() {
        assertThrows(IllegalArgumentException.class, () -> findSecondMaxWithStream(null));
        int[] array = {-10, -11};
        assertEquals(-11, findSecondMaxWithStream(array));

        array = new int[]{1, 2, 3, 3};
        assertEquals(3, findSecondMaxWithStream(array));

        array = new int[]{1, 1, 1, 1, 1, 1};
        assertEquals(1, findSecondMaxWithStream(array));


        assertThrows(IllegalArgumentException.class, () -> findSecondMaxWithStream(new int[]{1}));
    }

}