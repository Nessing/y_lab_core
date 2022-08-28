package lesson_1.task_2;


public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        combSort(array);
    }

    private static void combSort(int[] array) {
        int gap = array.length;
        boolean isSorted = false;

        while (!isSorted || gap != 1) {
            if (gap > 1) {
                gap = gap * 10 / 13;
            } else {
                gap = 1;
            }

            isSorted = true;
            for (int i = gap; i < array.length; i++) {
                if (array[i] < array[i - gap]) {
                    int temp = array[i];
                    array[i] = array[i - gap];
                    array[i - gap] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
