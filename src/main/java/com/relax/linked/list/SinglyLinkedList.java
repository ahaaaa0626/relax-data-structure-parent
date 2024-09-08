package com.relax.linked.list;

/**
 * @Author relax
 * @Date 2024/9/8 11:19
 * @Description 简单链表
 * @Version 1.0
 **/
public class SinglyLinkedList {

    Node head;

    public void remove(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw  illegalIndex(index);
        }

        if (index == 0){
            if (this.head != null) {
                this.head = this.head.next;
                return;
            } else {
                throw illegalIndex(index);
            }
        }

        Node preNode = findNode(index - 1);

        preNode.next = node.next;

    }

    public void insert(int value, int index) {
        Node node = this.head;
        if (index == 0) {
            addFirst(value);
            return;
        }

        Node prev = findNode(index - 1); // 找到上一个节点
        if (prev == null) { // 找不到
            throw illegalIndex(index);
        }
        prev.next = new Node(value, prev.next);
    }

    private Node findNode(int index) {

        Node node = this.head;
        for (int position = 1; node != null; position++, node = node.next) {
            if (position == index) {
                return node;
            }
        }
        return null;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index [%d] 不合法%n", index));
    }

    public int getNode(int index) {
        Node node = findNode(index);
        if (node != null) {
            return node.value;
        }
        throw illegalIndex(index);
    }

    public void addFirst(int value) {
        this.head = new Node(value, this.head);
    }

    public void addLast(int value) {
        Node node = this.head;
        if (node == null) {
            addFirst(value);
            return;
        }

        while (node.next != null) {
            node = node.next;
        }

        Node newNode = new Node(value, null);
        node.next = newNode;

    }

    public void loop() {
        Node node = this.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
