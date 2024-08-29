package com.relax.array;

import java.util.Iterator;

/**
 * @Author relax
 * @Date 2024/8/29 15:28
 * @Description dynamic array implement
 * @Version 1.0
 **/
public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(4);
        print(array);

        array.remove(2);

        print(array);

        System.out.println(array.get(2));

        array.addLast(5);

        print(array);


    }

    private static void print(DynamicArray array) {
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            Integer element= iterator.next();
            System.out.print(element + " ");
        }
        System.out.println();
    }

}
