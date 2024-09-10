package com.relax.linked.list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Author relax
 * @Date 2024/9/8 11:25
 * @Description 单向链表测试
 * @Version 1.0
 **/
public class SinglyLinkedListTest {



    @Test
    @DisplayName("singly linked list testing")
    public void test1() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addLast(30);
        linkedList.addLast(40);

//        linkedList.insert(50, 10);
        linkedList.loop();
        System.out.println("------");

        linkedList.remove(3);
        linkedList.loop();
        System.out.println("------");
        linkedList.remove(4);
        linkedList.loop();
        System.out.println("------");

//        System.out.println(linkedList.getNode(6));


    }

}
