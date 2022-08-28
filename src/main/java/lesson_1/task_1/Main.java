package lesson_1.task_1;


public class Main {
    public static void main(String[] args) {
        int[][] array = new int[5][5];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = random(i, j);
            }
        }
        searchingValues(array);
    }

    private static int random(int a, int b) {
        long randomNum = System.currentTimeMillis();
        try {
            Thread.sleep(5 + a + b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int random = (int) (randomNum % 100);
        return random;
    }

    private static void searchingValues(int[][] array) {
        int min = array[0][0];
        int max = 0;
        int avg = 0;
        int sizeArray = array.length * array.length;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                avg += array[i][j];
                if (array[i][j] < min) {
                    min = array[i][j];
                } else if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        avg = avg / sizeArray;

        System.out.printf("min: %d\nmax: %d\navg: %d\n", min, max, avg);
    }
}
