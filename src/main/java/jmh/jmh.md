# JMH
Java Microbenchmark Harness

## 注解

### Benchmark
标记基准测试的方法

### BenchmarkMode
- Mode.Throughput
- Mode.AverageTime
- Mode.SampleTime
- Mode.SingleShotTime
- All

### State

- Scope.Benchmark:
- Scope.Group:
- Scope.Thread:

### Warmup
- iterations: 预热的次数
- time: 预热的时间
- timeUnit: 时间单位
- batchSize: 批处理大小，每次操作调用几次方法


### Fork
启动几个线程进行测试

### Param
测试变量的多个取值，用在字段上。使用这个注解需要定义@State注解

### Threads


