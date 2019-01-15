package by.azarenka.sorting;

public class InsertSort {

    private int[] array;

    public InsertSort(int[] array) {
        this.array = array;
    }

    public void insertIntoSort() {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i + 1];
                array[i + 1] = array[i];
                int j = i;
                while (j > 0 && temp < array[j - 1]){
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 8, 4, 9, 6, 3, 1, 48, 45, 12, 99, 15, 14, 3,77, -5};
        InsertSort sort = new InsertSort(ints);
        sort.insertIntoSort();
        for (int f : ints) {
            System.out.println(f);
        }
    }
}
