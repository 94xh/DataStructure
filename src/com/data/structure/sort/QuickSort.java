package com.data.structure.sort;

import java.util.Arrays;

public class QuickSort implements IArraySort {

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }
    //   ix
    // p i           r
    //{6,1,7,8,4,5,3,2}
    // 0 1 2 3 4 5 6 7
    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        //循环前{6,1,7,8,4,5,3,2}
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        //循环后{6,1,4,5,3,2,7,8}
        swap(arr, pivot, index - 1);
        //交换后{2,1,4,5,3,6,7,8}，返回pivot所在的index，然后递归调用排序基准的左边和右边
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

    public static void main(String[] args) throws Exception {
        int[] nums = {6,1,7,8,4,5,3,2};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(nums);
    }

}
