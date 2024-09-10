package com.relax.linked.list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * @Author relax
 * @Date 2024/9/8 11:25
 * @Description 单向链表测试
 * @Version 1.0
 **/
public class SinglySentinelLinkedListTest {

    static SinglySentinelLinkedList sentinelLinkedList;


    @BeforeAll
    public static void init(){
        sentinelLinkedList = new SinglySentinelLinkedList();
        sentinelLinkedList.addFirst(1);
        sentinelLinkedList.addFirst(2);
        sentinelLinkedList.addFirst(3);
    }


    @Test
    @DisplayName("loop")
    public void test1() {
        sentinelLinkedList.loop();
    }


    @Test
    @DisplayName("insert")
    public void test2() {
        sentinelLinkedList.insert(10, 0);
        sentinelLinkedList.insert(12, 4);
        sentinelLinkedList.insert(11, 3);
        sentinelLinkedList.loop();
//        sentinelLinkedList.insert(10, 0);
    }


    @Test
    @DisplayName("remove")
    public void test3() {
        sentinelLinkedList.remove( 0);
        sentinelLinkedList.loop();
    }




}
