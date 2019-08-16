package com.shika;

import org.junit.Test;

public class ReplaceSpaceTest {
    @Test
    public void replaceSpace() throws Exception {
        String s = "1 2 3 4 a s ";
        String s1 = ReplaceSpace.replaceSpace(new StringBuffer(s));
        System.out.println(s1);
    }

}