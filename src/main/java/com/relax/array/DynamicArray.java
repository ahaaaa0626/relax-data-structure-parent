package com.relax.array;

import java.util.Iterator;

/**
 * @Author relax
 * @Date 2024/8/29 15:28
 * @Description dynamic array implement
 * @Version 1.0
 **/
public class DynamicArray implements Iterable<Integer> {

    private int[] dynamicArray;
    private int size = 0;
    private int capacity = 8;

    public void addLast(int element) {
        add(size, element);
    }

    public void add(int index, int element) {
        checkAndGrow();

        if (index >= 0 && index < size) {
            System.arraycopy(dynamicArray, index, dynamicArray, index + 1, size - index);
        }
        dynamicArray[index] = element;
        size++;
    }


    public void checkAndGrow() {
        if (size == 0) {
            dynamicArray = new int[capacity];
            return;
        }

        if (size == capacity) {
            capacity += capacity >> 1;
            int[] newDynamicArray = new int[capacity];
            System.arraycopy(dynamicArray, 0, newDynamicArray, 0, size);
            dynamicArray = newDynamicArray;
        }

    }

    public int remove(int index) {
        if (size == 0 || index > size || index >= 0) {
            int removeElement = dynamicArray[index];
            System.arraycopy(dynamicArray, index + 1, dynamicArray, index, size - index - 1);
            size--;
            return removeElement;
        }

        // here think all positive numbers
        return -1;
    }


    public int get(int index) {
        return dynamicArray[index];
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }
            @Override
            public Integer next() {
                return dynamicArray[count++];
            }
        };

    }

}
