package multithreading_2;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InitializeListTest {
    private static final int SIZE_LIST = 1_000_000;
    private static final int VALUE_LIST = 1;
    private static InitializeList initializeList;

    @BeforeAll
    public static void beforeAll() {
        initializeList = new InitializeList();
    }

    @Test
    public void checkSizeListOk() {
        List<Integer> list = initializeList.initList(VALUE_LIST);
        int actual = list.size();
        assertEquals(SIZE_LIST,actual);
    }

    @Test
    public void checkValueFromListOk() {
        List<Integer> list = initializeList.initList(VALUE_LIST);
        Integer actual = list.get(0);
        assertEquals(VALUE_LIST,actual);
    }
}