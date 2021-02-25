package multithreading;

import java.util.List;
import java.util.concurrent.Callable;

public class CalculatorSumCallableImpl implements Callable<Integer> {
    private final List<Integer> list;

    public CalculatorSumCallableImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        return list.stream()
                .reduce(Integer::sum)
                .orElseThrow(() ->
                        new RuntimeException("Error calculate sum of numbers from list "
                                + list.toString()));
    }
}
