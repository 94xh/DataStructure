package com.data.structure.sort;

import java.sql.SQLOutput;

/**
 * 十大经典排序算法
 * 1 冒泡排序
 * 2 选择排序
 * 3 插入排序
 * 4 希尔排序
 * 5 归并排序
 * 6 快速排序
 * 7 堆排序
 * 8 计数排序
 * 9 桶排序
 * 10 基数排序
 * <p>
 * 算法稳定性的意义：
 * 如果我们现在有 10 万条订单数据，我们希望按照金额从小到大对订单数据排序。对于金额相同的订单，我们希望按照下单时间从早到晚有序。
 * 对于这样一个排序需求，我们怎么来做呢？
 * 稳定排序算法可以保持金额相同的两个对象，在排序之后的前后顺序不变。
 * 第一次排序之后，所有的订单按照下单时间从早到晚有序了。
 * 在第二次排序中，我们用的是稳定的排序算法，所以经过第二次排序之后，相同金额的订单仍然保持下单时间从早到晚有序。
 */
public class SortTest {

    public static int[] INTS = {1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 3, 4, 5, 6, 7, 9, 8, 10};

    public static void main(String[] args) throws Exception {
        int nums[] = INTS;
        System.out.println("一、冒泡排序：");
        BubbleSort bubbleSort = new BubbleSort();
        printNums(bubbleSort.sort(nums));

        System.out.println("二、选择排序：");
        SelectionSort selectionSort = new SelectionSort();
        printNums(selectionSort.sort(nums));

        System.out.println("三、插入排序：");
        InsertionSort insertionSort = new InsertionSort();
        printNums(insertionSort.sort(nums));

        System.out.println("四、希尔排序：");
        ShellSort shellSort = new ShellSort();
        printNums(shellSort.sort(nums));

        System.out.println("五、归并排序：");
        MergeSort mergeSort = new MergeSort();
        printNums(mergeSort.sort(nums));

        System.out.println("六、快速排序：");
        QuickSort quickSort = new QuickSort();
        printNums(quickSort.sort(nums));

        System.out.println("七、堆排序：");
        HeapSort heapSort = new HeapSort();
        printNums(heapSort.sort(nums));

        System.out.println("八、计数排序");
        CountingSort countingSort = new CountingSort();
        printNums(countingSort.sort(nums));

        System.out.println("未排序：");
        printNums(nums);
    }

    private static void printNums(int[] nums) {
        for (int i : nums) {
            System.out.print(i + "、");
        }
        System.out.println();
    }
}
