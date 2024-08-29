package com.relax.binary.search;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author relax
 * @Date 2024/8/16 16:08
 * @Description binary search test
 * @Version 1.0
 **/
public class BinarySearchTest {


    private BasicVersion basicVersion = new BasicVersion();

    @Test
    @DisplayName("basic version testing")
    public void test01() {
        int[] a = {1, 6, 9, 10};
//        assertEquals(1, basicVersion.binarySearch(a, 13));
        System.out.println(basicVersion.binarySearch(a, 10));
    }


    @Test
    @DisplayName("left most version testing")
    public void test02() {
        int[] a = {1, 6, 6, 6, 9, 10};
        System.out.println(basicVersion.binarySearchLeftMost(a, 6));
    }

}
