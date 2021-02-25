package multithreading_2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinImpl extends RecursiveTask<Integer> {
    private static final int THRESHOLD = Runtime.getRuntime().availableProcessors();
    private final List<Integer> list;

    public ForkJoinImpl(List<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer compute() {
        if (list.size() > THRESHOLD) {
            return ForkJoinTask.invokeAll(createSubtasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        }
        return processing(list);
    }

    private Collection<ForkJoinImpl> createSubtasks() {
        List<ForkJoinImpl> subtasks = new ArrayList<>();
        List<Integer> partOne = list.subList(0, list.size() / 2);
        List<Integer> partTwo = list.subList(list.size() / 2, this.list.size());
        subtasks.add(new ForkJoinImpl(partOne));
        subtasks.add(new ForkJoinImpl(partTwo));
        return subtasks;
    }

    private Integer processing(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::valueOf)
                .sum();
    }
}
