package com.shika;

import com.shika.singleton.SingleTon1;
import org.junit.Test;

public class SingleTon1Test {
    @Test
    public void getInstance() throws Exception {
        SingleTon1 singleTon = SingleTon1.getInstance();
        System.out.println(singleTon);
    }

}