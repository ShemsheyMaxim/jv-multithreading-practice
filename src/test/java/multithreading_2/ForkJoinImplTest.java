package multithreading_2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForkJoinImplTest {
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
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_POSITIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfZeroValuesFromListOK() {
        listNumbers = List.of(0, 0, 0, 0);
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_ZERO_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfNegativeValuesFromListOK() {
        listNumbers = List.of(-1, -2, -3, -4);
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_NEGATIVE_NUMBER, actual);
    }

    public void checkCalculateSumOfValueNotEquals() {
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertNotEquals(WRONG_RESULT, actual);
    }
}