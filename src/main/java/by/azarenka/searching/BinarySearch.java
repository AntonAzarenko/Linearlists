package by.azarenka.searching;

public class BinarySearch {

    private double[] array;

    public BinarySearch(double[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch(new double[]
                {-16, -9, -5, 0, 3, 7, 12, 18, 20, 24, 30, 32, 38, 47, 50});
        System.out.println(binarySearch.search(7));
    }

    public int search(double x) {
        int i = -1;
        if (this.array != null) {
            int low = 0, mid, height = this.array.length;
            while (low < height) {
                mid = (low + height) / 2;
                if (x == this.array[mid]) {
                    i = mid;
                    break;
                } else {
                    if (x <= this.array[mid]) {
                        height = mid;
                    } else {
                        low = mid + 1;
                    }
                }
            }
        }
        return i;
    }
}
