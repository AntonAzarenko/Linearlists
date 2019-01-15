package by.azarenka.sorting;

public class BubbleSort {

    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 8, 4, 9, 6, 3, 1, 48, 45, 12, 99, 15, 14, 3};
        BubbleSort sort = new BubbleSort(ints);
        sort.sort();
        for (int f : ints) {
            System.out.println(f);
        }
    }
}
