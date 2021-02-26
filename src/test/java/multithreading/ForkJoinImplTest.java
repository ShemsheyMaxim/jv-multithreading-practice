package multithreading;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ForkJoinImplTest {
    private static final int SUM_POSITIVE_NUMBER = 1_000_000;
    private static final int SUM_NEGATIVE_NUMBER = -1_000_000;
    private static final int SUM_ZERO_NUMBER = 0;
    private static final int WRONG_RESULT = 12;
    private static List<Integer> listNumbers;
    private static InitializeList initializeList;

    @BeforeAll
    public static void beforeAll() {
        listNumbers = new ArrayList<>();
        initializeList = new InitializeList();
    }

    @Test
    public void checkCalculateSumOfPositiveValuesFromListOK() {
        listNumbers = initializeList.initList(1);
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_POSITIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfZeroValuesFromListOK() {
        listNumbers = initializeList.initList(0);
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_ZERO_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfNegativeValuesFromListOK() {
        listNumbers = initializeList.initList(-1);
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertEquals(SUM_NEGATIVE_NUMBER, actual);
    }

    @Test
    public void checkCalculateSumOfValueNotEquals() {
        ForkJoinImpl forkJoin = new ForkJoinImpl(listNumbers);
        int actual = forkJoin.compute();
        assertNotEquals(WRONG_RESULT, actual);
    }
}
