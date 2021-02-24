package service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InitializeList {
    public List<Integer> initList(int numberForInitializeList) {
        return IntStream.range(0, 1_000_000)
                .map(n -> n = numberForInitializeList)
                .boxed()
                .collect(Collectors.toList());
    }
}
