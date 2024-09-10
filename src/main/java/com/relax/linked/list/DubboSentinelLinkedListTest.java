package com.relax.linked.list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author relax
 * @Date 2024/9/8 11:25
 * @Description 单向链表测试
 * @Version 1.0
 **/
public class DubboSentinelLinkedListTest {

    static DubboSentinelLinkedList sentinelLinkedList;


    @BeforeAll
    public static void init(){
        sentinelLinkedList = new DubboSentinelLinkedList();
//        sentinelLinkedList.addFirst(1);
//        sentinelLinkedList.addFirst(2);
//        sentinelLinkedList.addFirst(3);
        sentinelLinkedList.addLast(1);
        sentinelLinkedList.addLast(2);
        sentinelLinkedList.addLast(3);
    }


    @Test
    @DisplayName("loop")
    public void test1() {
        sentinelLinkedList.loop();
    }


    @Test
    @DisplayName("insert")
    public void test2() {
        sentinelLinkedList.insert(10, 1);
        sentinelLinkedList.loop();
//        sentinelLinkedList.insert(10, 0);
    }


    @Test
    @DisplayName("remove")
    public void test3() {
        sentinelLinkedList.loop();
        sentinelLinkedList.remove( 2);
        sentinelLinkedList.loop();
    }




}
