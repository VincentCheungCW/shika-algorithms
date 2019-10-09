package com.shika;

import org.junit.Test;

public class FibonacciTest {
    @Test
    public void fibonacci() throws Exception {
        int fibonacci = Fibonacci.fibonacci(15);
        System.out.println(fibonacci);

        Fibonacci fibonacci2 = new Fibonacci();
        int i = fibonacci2.fibonacci2(15);
        System.out.println(i);

        System.out.println(Fibonacci.fibonacci3(15));
    }

}