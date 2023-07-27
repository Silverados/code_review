package jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.annotations.Mode;

import java.io.IOException;

public class JmhTest1 {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    // value:次数  warmUps:热身
    @Fork(value = 1, warmups = 2)
    public void init() {}
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }
}
