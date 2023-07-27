package fastutil;

import it.unimi.dsi.fastutil.doubles.Double2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Warmup(iterations = 1, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(batchSize = 1000)
@Fork(value = 2)
public class MapTest {
    @Param({"1000", "100000", "1000000", "10000000"})
    public int size;

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Map<Integer, Integer> insertMap() {
        Map<Integer, Integer> map = new HashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        return map;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public Map<Integer, Integer> insertOpenMap() {
        Map<Integer, Integer> map = new Int2IntOpenHashMap(size);
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        return map;
    }
}
