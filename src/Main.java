import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        boolean isEnd = true;
        boolean isSorted = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 100));
        }
        System.out.println(Arrays.toString(array));
        while (isEnd) {
            System.out.println("1. Отсортировать массив.");
            System.out.println("2. Поиск элента в массиве.");
            System.out.println("3. Завершить программу.");
            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    System.out.println(Arrays.toString(bubbleSort(array)));
                    isSorted = true;
                    break;
                case 2:
                    if (!isSorted) {
                        System.out.println("Массив не отсортирован!");
                        break;
                    }
                    System.out.println("Введите элемент для поиска...");
                    int key = sc.nextInt();
                    int elem = binarySearch(array, key);
                    if (elem == -1) {
                        System.out.println("такого элемента нет в массиве");
                    } else
                        System.out.println(elem);
                    break;
                case 3:
                    isEnd = false;
                    break;
            }
        }
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + high / 2;
            if (array[mid] == key) {
                return mid;
            } else if (key > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int[] bubbleSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    isSorted = false;
                }
            }
        }
        return arr;
    }
}