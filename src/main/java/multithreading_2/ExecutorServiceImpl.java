package multithreading_2;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import org.apache.commons.collections4.ListUtils;

public class ExecutorServiceImpl {
    private static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors();
    private final List<Integer> list;

    public ExecutorServiceImpl(List<Integer> list) {
        this.list = list;
    }

    public int execute() {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<List<Integer>> listOfSubLists = ListUtils.partition(list,
                list.size() / THREAD_POOL_SIZE);
        List<CalculatorSumCallableImpl> callables = listOfSubLists.stream()
                .map(CalculatorSumCallableImpl::new)
                .collect(Collectors.toList());
        try {
            List<Future<Integer>> futures = executorService.invokeAll(callables);
            executorService.shutdown();
            int sum = 0;
//            futures.stream().mapToInt(Future::get).sum();
            for (Future<Integer> future : futures) {
                sum += future.get();
            }
            return sum;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("Error with invoke all of subLists.");
        }
    }
}
