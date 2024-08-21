package com.relax.recursion;

import org.springframework.util.StopWatch;

import java.util.LinkedList;

/**
 * @Author relax
 * @Date 2024/8/21 11:26
 * @Description TODO
 * @Version 1.0
 **/
public class TowerOfHanoi {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        LinkedList<Integer> a = new LinkedList<>();
        LinkedList<Integer> b = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        int num = 30;
        init(num, a);
        move(num, a, b, c);
        print(a, b, c);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    /**
     * 思路：首先c为目标，b为借助，a为需移动元素。
     * 把前n-1个全部移动到b，然后第n个移动到c；此时b成为a的角色，重复上述逻辑，直至每轮最后一个都移动到c
     * @param num
     * @param a
     * @param b
     * @param c
     */
    private static void move(int num, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c){
        if (num == 0) {
            return;
        }

        move(num -1, a, c, b);
        c.addLast(a.removeLast());
//        print(a,b,c);

        move(num -1, b, a, c);

    }

    static void init(int num, LinkedList<Integer> a) {
        for (int i = num; i >= 1; i--) {
            a.addLast(i);
        }
    }

    private static void print(LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("--------------------------------------------------------------------------------");
    }

}
