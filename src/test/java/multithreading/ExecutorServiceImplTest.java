package multithreading;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExecutorServiceImplTest {
    private static final int SUM_POSITIVE_NUMBER = 1_000_000;
    private static final int SUM_NEGATIVE_NUMBER = -1_000_000;
    private static final int SUM_ZERO_NUMBER = 0;
    private static final int WRONG_RESULT = 12;
    private static List<Integer> listNumbers;
    private static InitializeList initializeList;

    @BeforeAll
    public static void beforeAll() {
        initializeList = new InitializeList();
        listNumbers = new ArrayList<>();
    }

    @Test
    public void checkCalculateSumOfPositiveValuesFromListOK() {
        listNumbers = initializeList.initList(1);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_POSITIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfZeroValuesFromListOK() {
        listNumbers = initializeList.initList(0);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_ZERO_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfNegativeValuesFromListOK() {
        listNumbers = initializeList.initList(-1);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_NEGATIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfValueNotEquals() {
        listNumbers = initializeList.initList(1);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertNotEquals(WRONG_RESULT, actual);
    }
}
