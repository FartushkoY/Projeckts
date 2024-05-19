package de.telran.summary9;

import de.telran.homework_06_05.CheckLoginPassword;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void testGetCoincidence() {
        int[] result = Task.getCoincidence(new int[]{1, 2, 5, 5, 8, 9, 7, 10}, new int[]{1, 0, 6, 15, 6, 4, 7, 0});
        int[] expected = new int[]{1, 7};
        assertArrayEquals(expected, result);

        result = Task.getCoincidence(new int[]{1, 2, 5, 5, 8, 9, 10}, new int[]{0, 6, 15, 6, 4, 7, 0});
        expected = new int[]{};
        assertArrayEquals(expected, result);

        result = Task.getCoincidence(new int[]{}, new int[]{0, 6, 15, 6, 4, 7, 0});
        expected = new int[]{};
        assertArrayEquals(expected, result);

        assertThrows(NullPointerException.class, () -> Task.getCoincidence(null, new int[]{0, 6, 15, 6, 4, 7, 0}));
    }


    @Test
    public void getUniqueArray() {
        int[] result = Task.getUniqueArray(new int[]{0, 3, -2, 4, 3, 2});
        int[] expected = new int[]{0, 3, -2, 4, 2};
        assertArrayEquals(expected, result);

        result = Task.getUniqueArray(new int[]{0, 3, 0, 4, 5, 2});
        expected = new int[]{0, 3, 4, 5, 2};
        assertArrayEquals(expected, result);

        result = Task.getUniqueArray(new int[]{0, 3, 2, 4, 5, 2});
        expected = new int[]{0, 3, 2, 4, 5};
        assertArrayEquals(expected, result);

        result = Task.getUniqueArray(new int[]{});
        expected = new int[]{};
        assertArrayEquals(expected, result);

        assertThrows(NullPointerException.class, () -> Task.getUniqueArray(null));
    }
}