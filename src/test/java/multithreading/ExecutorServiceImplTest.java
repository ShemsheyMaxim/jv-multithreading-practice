package multithreading;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ExecutorServiceImplTest {
    private static final int SUM_POSITIVE_NUMBER = 10;
    private static final int SUM_NEGATIVE_NUMBER = -10;
    private static final int SUM_ZERO_NUMBER = 0;
    private static final int WRONG_RESULT = 12;
    private static List<Integer> listNumbers;

    @BeforeAll
    public static void beforeAll() {
        listNumbers = new ArrayList<>();
    }

    @Test
    public void checkCalculateSumOfPositiveValuesFromListOK() {
        listNumbers = List.of(1, 2, 3, 4);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_POSITIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfZeroValuesFromListOK() {
        listNumbers = List.of(0, 0, 0, 0);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_ZERO_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfNegativeValuesFromListOK() {
        listNumbers = List.of(-1, -2, -3, -4);
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertEquals(SUM_NEGATIVE_NUMBER, actual);
    }

    public void checkCalculateSumOfValueNotEquals() {
        ExecutorServiceImpl executorService = new ExecutorServiceImpl(listNumbers);
        int actual = executorService.execute();
        assertNotEquals(WRONG_RESULT, actual);
    }
}
