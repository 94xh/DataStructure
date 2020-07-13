package com.data.structure.sort;

import java.util.Arrays;

public class MergeSort implements IArraySort {


    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        if (arr.length < 2) {
            return arr;
        }
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);

        return merge(sort(left), sort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            if (left[l] > right[r]) {
                result[k++] = right[r++];
            } else {
                result[k++] = left[l++];
            }
        }
        while (l < left.length)
            result[k++] = left[l++];
        while (r < right.length)
            result[k++] = right[r++];
        return result;
    }

}
