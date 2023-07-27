package fastutil;

import it.unimi.dsi.fastutil.ints.IntArrayList;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 5)
public class ArrayListTest {

    @Param({"500000", "5000000", "50000000"})
    public int size;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<Integer> insertArrayList() {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<Integer> insertIntArrayList() {
        List<Integer> list = new IntArrayList(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public List<Integer> insertIntArrayList2() {
        IntArrayList list = new IntArrayList(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}
