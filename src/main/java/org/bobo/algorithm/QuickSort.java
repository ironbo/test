package org.bobo.algorithm;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author huangjiangbo
 * @date 2021-04-26 17:38
 * @description 快速排序
 */
class QuickSort {

    public static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("快速排序：最好情况O(n)，最坏情况O(n2)");

        System.out.println("乱序情况");
        int[] unsorted1 = {44, 54, 88, 66, 77, 976, 33, 2, 22, 5};
        System.out.println("第0次排完前数据：" + StringUtils.join(unsorted1, ','));
        sort(unsorted1, 0, unsorted1.length - 1);
        System.out.println("当n=" + unsorted1.length + "时，执行次数：" + count);
        count = new AtomicInteger(0);

        System.out.println("最好情况");
        int[] unsorted2 = {1, 3, 4, 6, 11, 22, 33, 44, 78, 976};
        System.out.println("第0次排完前数据：" + StringUtils.join(unsorted2, ','));
        sort(unsorted2, 0, unsorted2.length - 1);
        System.out.println("当n=" + unsorted2.length + "时，执行次数：" + count);
        count = new AtomicInteger(0);

        System.out.println("第二好情况");
        int[] unsorted3 = {1, 3, 4, 11, 22, 33, 44, 79, 78, 976};
        System.out.println("第0次排完前数据：" + StringUtils.join(unsorted3, ','));
        sort(unsorted3, 0, unsorted3.length - 1);
        System.out.println("当n=" + unsorted3.length + "时，执行次数：" + count);
        count = new AtomicInteger(0);


        System.out.println("最坏情况");
        int[] unsorted4 = {13321, 1312, 123, 12, 10, 9, 4, 3, 2, 1};
        System.out.println("第0次排完前数据：" + StringUtils.join(unsorted4, ','));
        sort(unsorted4, 0, unsorted4.length - 1);
        System.out.println("当n=" + unsorted4.length + "时，执行次数：" + count);
        count = new AtomicInteger(0);
    }


    public static void sort(int[] args, int start, int end) {
        if (start < end) {
            int index = compare(args, start, end);
            sort(args, start, index - 1);
            sort(args, index + 1, end);
        }

    }

    public static int compare(int[] args, int start, int end) {
        // 执行次数统计
        count.addAndGet(1);
        // 以第一个元素为基准，进行筛选
        int value = args[start];
        while (start < end) {
            // 当尾指针所指元素比待排元素大时，向左移动指针
            while (value <= args[end] && start < end) {
                end--;
            }
            // 当尾指针所指元素比待排元素小，把该元素赋值到头指针所指元素，保证左边的元素都比待排元素小
            args[start] = args[end];
            // 当头指针所指元素比待排元素小时，向右移动指针
            while (value >= args[start] && start < end) {
                start++;
            }
            // 当头指针所指元素比待排元素大时，把该元素赋值到尾指针所指元素，保证右边的元素都比待排元素大
            args[end] = args[start];

        }
        // 当头指针和尾指针相遇时，跳出循环，即该位置为待排元素所在位置
        args[start] = value;
        System.out.println("第" + count.get() + "次排完后数据：" + StringUtils.join(args, ',') + "，index：" + start);
        return start;
    }
}