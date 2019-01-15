package by.azarenka.sorting;

public class MergeSort {

    public MergeSort() {
    }

    public void merge(int[] array, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        int remaining = left.length + right.length;
        while (remaining > 0) {
            if (leftIndex >= left.length) {
                array[targetIndex] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                array[targetIndex] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                array[targetIndex] = left[leftIndex++];
            } else {
                array[targetIndex] = right[rightIndex++];
            }

            targetIndex++;
            remaining--;
        }
    }

    public void sort(int[] array) {
        int length = array.length;
        if (array.length <= 1) {
            return;
        }
        int leftSize = length / 2;
        int rightSize = length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(array, 0, left, 0, leftSize);
        System.arraycopy(array, leftSize, right, 0, rightSize);
        sort(left);
        sort(right);
        merge(array, left, right);

    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 8, 2, 1, 5, 4, 7, 5, 2};
        MergeSort sort = new MergeSort();
        sort.sort(ints);
        for (int f : ints) {
            System.out.println(f);
        }
    }
}
