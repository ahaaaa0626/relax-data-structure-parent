package com.relax.binary.search;

/**
 * @Author relax
 * @Date 2024/8/16 15:12
 * @Description TODO
 * @Version 1.0
 **/
public class BasicVersion {

    /**
     *
     * @param a
     * @param target
     * @return return the target index in array while exist,otherwise return -1
     */
    public int binarySearch(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;

        while (i <= j) {

            // unsigned right move
            int middle = (i + j) >>> 1;

            if (a[middle] < target) {
                i = middle + 1;
            } else if (a[middle] > target) {
                j = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }


    /**
     * 思路：寻找到后一直往左边缩直至结束边界
     * @param a
     * @param target
     * @return return left most target index in array while exist,otherwise return -1
     */
    public int binarySearchLeftMost(int[] a, int target) {
        int i = 0;
        int j = a.length - 1;
        int candidate = -1;

        while (i <= j) {

            // unsigned right move
            int middle = (i + j) >>> 1;

            if (a[middle] < target) {
                i = middle + 1;
            } else if (a[middle] > target) {
                j = middle - 1;
            } else {
                candidate = middle;
                j = middle - 1;

                // right most
//                i = middle + 1;
            }
        }

        return candidate;
    }


    /**
     * 思路：遍历到只剩下只剩下一个
     * @param a
     * @param target
     * @return
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        return (a[i] == target) ? i : -1;
    }

}
