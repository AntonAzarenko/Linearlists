package by.azarenka.sorting;

import java.util.Random;

public class QuickSort {

    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int i = left, j = right;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        sort(array, left, cur);
        sort(array, cur + 1, right);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 8, 2, 1, 5, 4, 7, 5, 2};
        QuickSort sort = new QuickSort();
        sort.sort(ints);
        for (int f : ints) {
            System.out.println(f);
        }
    }
}
