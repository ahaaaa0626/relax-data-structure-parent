package com.relax.linked.list;

import java.util.Iterator;

/**
 * @Author relax
 * @Date 2024/9/8 11:19
 * @Description 双向带哨兵链表
 * @Version 1.0
 **/
public class DubboSentinelLinkedList implements Iterable<Integer> {

    private Node head;
    private Node tail;

    public DubboSentinelLinkedList() {
        this.head = new Node(null, -1, null);
        this.tail = new Node(null, -2, null);

        head.next = tail;
        tail.pre = head;
    }

    public void addFirst(int value) {
        this.head.next = new Node(this.head, value, this.head.next);
        this.head.next.next.pre = this.head.next;
    }

    public void addLast(int value) {
        this.tail.pre = new Node(this.tail.pre, value, this.tail);
        this.tail.pre.pre.next =  this.tail.pre;
    }

    private Node findNode(int index) {

        Node node = this.head;
        for (int position = 0; node != null; position++, node = node.next) {
            if (position == index) {
                return node;
            }
        }
        return null;
    }

    public void insert(int value, int index) {
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(prev, value, prev.next);
        prev.next.next.pre = prev.next;
    }

    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node removed = prev.next;
        if (removed == tail) {
            throw illegalIndex(index);
        }
        Node next = removed.next;
        prev.next = next;
    }

    public int getNode(int index) {
        Node node = findNode(index);
        if (node != null) {
            return node.value;
        }
        throw illegalIndex(index);
    }


    public void loop() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

        System.out.println("=================");
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() { // 是否有下一个元素
                return p != null;
            }

            @Override
            public Integer next() { // 返回当前值, 并指向下一个元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }

    private class NodeIterator implements Iterator<Integer> {
        Node p = head.next;

        @Override
        public boolean hasNext() { // 是否有下一个元素
            return p != null;
        }

        @Override
        public Integer next() { // 返回当前值, 并指向下一个元素
            int v = p.value;
            p = p.next;
            return v;
        }
    }


    private static class Node {
        Node pre;
        int value;
        Node next;

        public Node(Node pre, int value, Node next) {
            this.pre = pre;
            this.value = value;
            this.next = next;
        }
    }
}
