package by.azarenka.searching;

public class LinearSearching {

    private String[] array;

    public LinearSearching(String[] array) {
        this.array = array;
    }

    /**
     * Search character in the array strings
     *
     * @param x
     * @return count character found
     */
    public int search(char x) {
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            String word = array[i];
            for (int j = 0; j < word.length(); j++) {
                word = word.toLowerCase();
                if (x == word.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        LinearSearching searching = new LinearSearching(new String[]{"Привет красавчик.", "Антон"});
        System.out.println(searching.search('п'));
    }
}

