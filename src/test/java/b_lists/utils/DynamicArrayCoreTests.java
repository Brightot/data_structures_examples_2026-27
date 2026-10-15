package b_lists.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests size(), get() and add() logic
 */
public class DynamicArrayCoreTests {
    @Test
    void size_PopulatedList() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);
        int expectedResult = 1;
        int result = myList.size();

        assertEquals(expectedResult, result);
    }

    @Test
    void size_EmptyList() {
        DynamicArray myList = new DynamicArray();
        int expectedResult = 0;
        int result = myList.size();

        assertEquals(expectedResult, result);
    }

    @Test
    void size_PopulatedList_MultipleElements() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);
        myList.add(10);
        myList.add(3);
        int expectedResult = 3;
        int result = myList.size();

        assertEquals(expectedResult, result);
    }

    @Test
    void get_PopulatedList() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);
        int expectedResult = 5;
        int result = myList.get(0);

        assertEquals(expectedResult, result);
    }

    @Test
    void get_AccessBeforeList() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    myList.get(-1);
                }, "Incorrect (or no) exception thrown"
        );
    }

    @Test
    void get_AccessBeyondEndOfList() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    myList.get(2);
                }, "Incorrect (or no) exception thrown"
        );
    }

    @Test
    void get_AccessAfterEndOfList() {
        DynamicArray myList = new DynamicArray();
        myList.add(5);

        assertThrows(IndexOutOfBoundsException.class,
                () -> {
                    myList.get(1);
                }, "Incorrect (or no) exception thrown"
        );
    }

    // Add tests
    @Test
    void add_EmptyList() {
        DynamicArray myList = new DynamicArray();
        int value = 5;
        myList.add(value);

        // Confirm size changed
        int expectedResult = 1;
        int result = myList.size();
        assertEquals(expectedResult, result);

        // Confirm contents updated correctly
        int expectedValue = value;
        result = myList.get(0);
        assertEquals(expectedValue, result);
    }

    @Test
    void add_PopulatedList() {
        DynamicArray myList = new DynamicArray();
        // Populate list before test begins:
        int[] dataset = {1, 2, 3, 4};
        for (int i = 0; i < dataset.length; i++) {
            myList.add(dataset[i]);
        }

        int startSize = dataset.length;

        // Add element to end of populated list
        int value = 5;
        myList.add(value);

        // Confirm size changed
        int expectedResult = startSize + 1;
        int result = myList.size();
        assertEquals(expectedResult, result);

        // Confirm contents updated correctly
        int expectedValue = value;
        // Retrieve from end position
        result = myList.get(myList.size() - 1);
        assertEquals(expectedValue, result);

        // Confirm all other original values are still correct
        for (int i = 0; i < dataset.length; i++) {
            assertEquals(dataset[i], myList.get(i));
        }
    }

    @Test
    void add_PopulatedList_RequiresExpansion() {
        DynamicArray myList = new DynamicArray();
        // Populate list before test begins:
        int[] dataset = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < dataset.length; i++) {
            myList.add(dataset[i]);
        }

        int startSize = dataset.length;

        // Add element to end of populated list
        int value = 5;
        myList.add(value);

        // Confirm size changed
        int expectedResult = startSize + 1;
        int result = myList.size();
        assertEquals(expectedResult, result);

        // Confirm contents updated correctly
        int expectedValue = value;
        // Retrieve from end position
        result = myList.get(myList.size() - 1);
        assertEquals(expectedValue, result);

        // Confirm all other original values are still correct
        for (int i = 0; i < dataset.length; i++) {
            assertEquals(dataset[i], myList.get(i));

        }
    }
}
