package jmh;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Fork(1)
@Warmup(iterations = 5, time = 10, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 10, timeUnit = TimeUnit.MILLISECONDS)
public class ReflectionBenchmark {

    @Benchmark
    public void measureReflectionTime() throws Exception {
        // 反射操作的示例，这里以调用方法为例
        MyClass myObject = new MyClass();
        Method method = MyClass.class.getMethod("myMethod");
        method.invoke(myObject);
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }

    // 被反射调用的类和方法
    public static class MyClass {
        public void myMethod() {
            // 方法体
        }
    }
}