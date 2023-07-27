package fastutil;

import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import org.openjdk.jmh.annotations.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Fork(value = 2)
public class SetTest {

    @Param({"100000", "1000000", "10000000"})
    public int size;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Set<Integer> insertHashSet() {
        Set<Integer> set = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Set<Integer> insertIntHashSet() {
        Set<Integer> set = new IntOpenHashSet(size);
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }
}
