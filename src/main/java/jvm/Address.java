package jvm;

import org.openjdk.jol.vm.VM;

import java.util.concurrent.TimeUnit;

public class Address {
    public static void main(String[] args) {
        Address test = new Address();
        System.out.println("The memory address is " + VM.current().addressOf(test));
        System.out.println("The memory address is " + Long.toHexString(VM.current().addressOf(test)));
        System.out.println(System.identityHashCode(test));
        test.helper();
    }

    public synchronized void helper() {
        try {
            System.out.println("hello");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
